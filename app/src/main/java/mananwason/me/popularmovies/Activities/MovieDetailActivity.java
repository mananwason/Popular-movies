package mananwason.me.popularmovies.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.Utils.Strings;

/**
 * Created by Manan Wason on 16/09/16.
 */
public class MovieDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_movies_detail);
        ImageView movieImage = (ImageView) findViewById(R.id.movie_poster_image);
        TextView synopsis = (TextView) findViewById(R.id.synopsis);
        TextView title = (TextView) findViewById(R.id.title);
        TextView relaseDate = (TextView) findViewById(R.id.release_date);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Movie movie = (Movie) getIntent().getSerializableExtra(Strings.INTENT_MOVIE_NAME);

        Picasso.with(this).load(movie.getBackdrop_path()).error(R.drawable.ic_filter_list_white_24dp).into(movieImage);
        synopsis.setText(movie.getOverview());
        title.setText(movie.getTitle());
        ratingBar.setRating((float) movie.getVote_average());

        relaseDate.setText(getFormattedDate(movie.getRelease_date()));


    }

    public String getFormattedDate(String rawDate) {
        SimpleDateFormat rawFormat = new SimpleDateFormat("yyyy-dd-MM");
        rawFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = rawFormat.parse(rawDate);
        } catch (ParseException e) {
            Log.d("Error", e.toString());
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);

    }
}
