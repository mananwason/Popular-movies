package mananwason.me.popularmovies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import mananwason.me.popularmovies.Adapters.MoviesAdapter;
import mananwason.me.popularmovies.BusEvents.MoviesDownloadEvent;
import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.PopularMoviesApp;
import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.Utils.ApiKey;
import mananwason.me.popularmovies.api.APIClient;
import mananwason.me.popularmovies.ResponseProcessors.MoviesListProcessor;

/**
 * Created by Manan Wason on 14/09/16.
 */
public class MoviesFragment extends Fragment {
    RecyclerView moviesRecyclerView;
    MoviesAdapter moviesAdapter;
    ArrayList<Movie> movies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        movies = new ArrayList<>();
        PopularMoviesApp.getEventBus().register(this);
        moviesRecyclerView = (RecyclerView) view.findViewById(R.id.list_movies);
        moviesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        moviesAdapter = new MoviesAdapter(movies);
        moviesRecyclerView.setAdapter(moviesAdapter);

        APIClient apiClient = new APIClient();
        apiClient.getMoviesAPI().getPopularMovies(ApiKey.API_KEY).enqueue(new MoviesListProcessor());


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
