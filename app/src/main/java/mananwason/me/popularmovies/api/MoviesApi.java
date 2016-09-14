package mananwason.me.popularmovies.api;

import mananwason.me.popularmovies.Models.parseExtras;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Manan Wason on 12/09/16.
 */
public interface MoviesApi {

    @GET("/3/movie/popular")
    Call<parseExtras> getMovies(@Query("api_key") String key);

}
