package mananwason.me.popularmovies.api;

import mananwason.me.popularmovies.Models.Reviews;
import mananwason.me.popularmovies.Models.Trailers;
import mananwason.me.popularmovies.Models.parseExtras;
import mananwason.me.popularmovies.Utils.ApiKey;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Manan Wason on 12/09/16.
 */
public interface MoviesApi {

    @GET("/3/movie/popular")
    Call<parseExtras> getPopularMovies(@Query("api_key") String key);

    @GET("/3/movie/top_rated")
    Call<parseExtras> getTopMovies(@Query("api_key") String key);

    @GET ("movie/{id}/videos?api_key="+ ApiKey.API_KEY)
    Call<Trailers> getTrailers(
            @Path("id") int id

    );
    @GET ("movie/{id}/reviews?api_key="+ApiKey.API_KEY)
    Call<Reviews> getReview(
            @Path("id") int id
    );


}
