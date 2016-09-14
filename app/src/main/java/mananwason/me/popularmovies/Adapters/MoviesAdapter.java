package mananwason.me.popularmovies.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.R;

/**
 * Created by Manan Wason on 14/09/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    ArrayList<Movie> movies;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.);
        }
    }
}
