package mananwason.me.popularmovies;

import android.util.Log;

import mananwason.me.popularmovies.Models.parseExtras;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Manan Wason on 14/09/16.
 */
public class MoviesResponseProcessor implements Callback<parseExtras> {
    @Override
    public void onResponse(Call<parseExtras> call, Response<parseExtras> response) {
        if (response.isSuccessful()) {
            Log.d("ABC", String.valueOf(response.body().getResults().size()));
        }
    }

    @Override
    public void onFailure(Call<parseExtras> call, Throwable t) {
        Log.d("ABC", "FAIL");
    }
}
