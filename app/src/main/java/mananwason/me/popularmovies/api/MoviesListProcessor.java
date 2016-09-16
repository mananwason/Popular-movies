package mananwason.me.popularmovies.api;

import android.util.Log;

import java.util.ArrayList;

import mananwason.me.popularmovies.BusEvents.MoviesDownloadEvent;
import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.Models.parseExtras;
import mananwason.me.popularmovies.PopularMoviesApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Manan Wason on 16/09/16.
 */
public class MoviesListProcessor implements Callback<parseExtras> {
    @Override
    public void onResponse(Call<parseExtras> call, Response<parseExtras> response) {
        ArrayList<Movie> resultMovies = new ArrayList<>();

        MoviesDownloadEvent moviesDownloadEvent = new MoviesDownloadEvent(false, resultMovies);
        if (response.isSuccessful()) {
            resultMovies = response.body().getResults();
            moviesDownloadEvent.setDownloadDone(true);
            moviesDownloadEvent.setMovieResults(resultMovies);
            Log.d("ABC",resultMovies.size()+"");
            PopularMoviesApp.postEventOnUIThread(new MoviesDownloadEvent(true, resultMovies));

        }

    }

    @Override
    public void onFailure(Call<parseExtras> call, Throwable t) {
        PopularMoviesApp.postEventOnUIThread(new MoviesDownloadEvent(false, null));
    }
}
