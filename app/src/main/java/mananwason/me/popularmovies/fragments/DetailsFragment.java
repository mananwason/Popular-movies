package mananwason.me.popularmovies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mananwason.me.popularmovies.Adapters.MoviesAdapter;
import mananwason.me.popularmovies.BusEvents.MoviesDownloadEvent;
import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.PopularMoviesApp;
import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.ResponseProcessors.MoviesListProcessor;
import mananwason.me.popularmovies.Utils.ApiKey;
import mananwason.me.popularmovies.Utils.Strings;
import mananwason.me.popularmovies.api.APIClient;

/**
 * Created by mananwason on 7/14/17.
 */

public class DetailsFragment extends Fragment {
    RecyclerView moviesRecyclerView;
    MoviesAdapter moviesAdapter;
    ArrayList<Movie> movies;
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_movies_detail, container, false);
        ImageView movieImage = (ImageView) view.findViewById(R.id.movie_poster_image);
        TextView synopsis = (TextView) view.findViewById(R.id.synopsis);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView relaseDate = (TextView) view.findViewById(R.id.release_date);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        Movie movie = (Movie) getArguments().getSerializable(Strings.INTENT_MOVIE_NAME);
        Picasso.with(view.getContext()).load(movie.getBackdrop_path()).error(R.drawable.ic_filter_list_white_24dp).into(movieImage);
        synopsis.setText(movie.getOverview());
        title.setText(movie.getTitle());
        ratingBar.setRating((float) movie.getVote_average());
        relaseDate.setText(movie.getFormattedDate(movie.getRelease_date()));


        return view;
    }

    @Subscribe
    public void MovieDownloadDoneEvent(MoviesDownloadEvent event) {
        if (event.isDownloadDone()) {
            movies.clear();
            movies = event.getMovieResults();
            moviesAdapter.setMovies(movies);
            moviesAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.sort_popular:
                new APIClient().getMoviesAPI().getPopularMovies(ApiKey.API_KEY).enqueue(new MoviesListProcessor());
                break;

            case R.id.sort_top:
                new APIClient().getMoviesAPI().getTopMovies(ApiKey.API_KEY).enqueue(new MoviesListProcessor());
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

