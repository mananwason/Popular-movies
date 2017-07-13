package mananwason.me.popularmovies.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.Utils.Strings;

/**
 * Created by Manan Wason on 16/09/16.
 */
public class MovieDetailActivity extends AppCompatActivity {
    private Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.fragment_movies_detail);
        ImageView movieImage = (ImageView) findViewById(R.id.movie_poster_image);
        TextView synopsis = (TextView) findViewById(R.id.synopsis);
        TextView title = (TextView) findViewById(R.id.title);
        TextView relaseDate = (TextView) findViewById(R.id.release_date);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        if (getIntent().getExtras() != null) {
            movie = (Movie) getIntent().getSerializableExtra(Strings.INTENT_MOVIE_NAME);
        }
        Picasso.with(this).load(movie.getBackdrop_path()).error(R.drawable.ic_filter_list_white_24dp).into(movieImage);
        synopsis.setText(movie.getOverview());
        title.setText(movie.getTitle());
        ratingBar.setRating((float) movie.getVote_average());
        relaseDate.setText(movie.getFormattedDate(movie.getRelease_date()));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(Strings.INTENT_MOVIE_NAME, movie);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        movie = (Movie) savedInstanceState.getSerializable(Strings.INTENT_MOVIE_NAME);

    }

}
