package mananwason.me.popularmovies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mananwason.me.popularmovies.R;

/**
 * Created by Manan Wason on 14/09/16.
 */
public class MoviesFragment extends Fragment {
    RecyclerView moviesRecycleView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        moviesRecycleView = (RecyclerView) view.findViewById(R.id.list_movies);

    }
}
