package mananwason.me.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import mananwason.me.popularmovies.Models.parseExtras;
import mananwason.me.popularmovies.Utils.Strings;
import mananwason.me.popularmovies.api.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ABC", "MADE");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        APIClient apiClient = new APIClient();
        apiClient.getMoviesAPI().getMovies(Strings.API_KEY).enqueue(new Callback<parseExtras>() {
            @Override
            public void onResponse(Call<parseExtras> call, Response<parseExtras> response) {
                if (response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<parseExtras> call, Throwable t) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
