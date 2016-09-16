package mananwason.me.popularmovies.Adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mananwason.me.popularmovies.Activities.MovieDetailActivity;
import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.Utils.Strings;

/**
 * Created by Manan Wason on 14/09/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    ArrayList<Movie> movies;

    public MoviesAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Uri uri = Uri.parse(movies.get(position).getPoster_path());
        Picasso.with(holder.poster.getContext()).load(uri).placeholder(R.drawable.ic_perm_identity_black_24dp).into(holder.poster);
        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.poster.getContext(), MovieDetailActivity.class);
                intent.putExtra(Strings.INTENT_MOVIE_NAME, movies.get(position));
                holder.poster.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.movie_poster);
        }
    }
}
