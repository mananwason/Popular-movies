package mananwason.me.popularmovies.Activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.fragments.MoviesFragment;

public class MainActivity extends AppCompatActivity {
    int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_frame, new MoviesFragment()).commit();


    }
    @Override
    public void onBackPressed() {
        count--;
        if(count == 1){
            Snackbar.make(this.findViewById(android.R.id.content),getResources().getText(R.string.exit),Snackbar.LENGTH_LONG).show();
        }
        else
            super.onBackPressed();

    }


}
