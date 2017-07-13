package mananwason.me.popularmovies.Adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mananwason.me.popularmovies.Activities.MovieDetailActivity;
import mananwason.me.popularmovies.Models.Movie;
import mananwason.me.popularmovies.R;
import mananwason.me.popularmovies.Utils.Strings;
import mananwason.me.popularmovies.fragments.DetailsFragment;
import mananwason.me.popularmovies.fragments.MoviesFragment;

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
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mView.getContext().getResources().getBoolean(R.bool.twoPaneMode)) {
                    FragmentManager manager = ((Activity) holder.mView.getContext()).getFragmentManager();
// add
                    FragmentTransaction ft = manager.beginTransaction();
                    DetailsFragment detailsFragment = new DetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Strings.INTENT_MOVIE_NAME, movies.get(position));
                    detailsFragment.setArguments(bundle);
                    ft.replace(R.id.details, detailsFragment);
// alternatively add it with a tag
// trx.add(R.id.your_placehodler, new YourFragment(), "detail");
                    ft.commit();

                } else {
                    Intent intent = new Intent(holder.poster.getContext(), MovieDetailActivity.class);
                    intent.putExtra(Strings.INTENT_MOVIE_NAME, movies.get(position));
                    holder.poster.getContext().startActivity(intent);
                }
            }
        });
        holder.dView.setText(movies.get(position).getRelease_date());
        holder.tView.setText(movies.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;
        TextView tView;
        TextView dView;
        View mView;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            poster = (ImageView) itemView.findViewById(R.id.movie_poster);
            tView = (TextView) itemView.findViewById(R.id.movie_name);
            dView = (TextView) itemView.findViewById(R.id.releaseDateMainActivit);

        }
    }
}
