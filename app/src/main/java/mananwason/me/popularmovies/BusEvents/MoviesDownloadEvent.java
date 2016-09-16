package mananwason.me.popularmovies.BusEvents;

import java.util.ArrayList;

import mananwason.me.popularmovies.Models.Movie;

/**
 * Created by Manan Wason on 16/09/16.
 */
public class MoviesDownloadEvent {
    boolean isDownloadDone;
    ArrayList<Movie> movieResults;

    public MoviesDownloadEvent(boolean isDownloadDone, ArrayList<Movie> movieResults) {
        this.isDownloadDone = isDownloadDone;
        this.movieResults = movieResults;
    }

    public boolean isDownloadDone() {
        return isDownloadDone;
    }

    public void setDownloadDone(boolean downloadDone) {
        isDownloadDone = downloadDone;
    }

    public ArrayList<Movie> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(ArrayList<Movie> movieResults) {
        this.movieResults = movieResults;
    }

}
