package com.appku.elharies.yourmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appku.elharies.yourmovie.R;
import com.appku.elharies.yourmovie.model.Result;

import java.util.List;

/**
 * Created by El Haries on 6/1/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<Result> movies ;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView judul, adult, release, popularity, vote_avg;
        ImageView poster;

        public MovieViewHolder(View v) {
            super(v);
            linearLayout = (LinearLayout) v.findViewById(R.id.layout_movie);
            judul = (TextView) v.findViewById(R.id.title_film);
            adult = (TextView) v.findViewById(R.id.adult);
            release = (TextView) v.findViewById(R.id.release);
            popularity = (TextView) v.findViewById(R.id.populer);
            vote_avg = (TextView) v.findViewById(R.id.vote_avg);
            poster = (ImageView) v.findViewById(R.id.poster);
        }


    }

    public MovieAdapter(List<Result> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.judul.setText(movies.get(position).getTitle());
        //String sAdult = Boolean.toString(movies.get(position).getAdult());
        holder.adult.setText("Adult: " + movies.get(position).getAdult());
        holder.release.setText(movies.get(position).getReleaseDate());
        String sPopularity = Double.toString(movies.get(position).getPopularity());
        holder.popularity.setText("Popularity: " + sPopularity);
        String sAvg = Double.toString(movies.get(position).getVoteAverage());
        holder.vote_avg.setText("Vote Average: " + sAvg);
        //Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + movies.get(position)
          //      .getBackdropPath()).resize(200, 250).into(holder.poster);
    }

    public int getItemCount() {
        return movies.size();
    }

}
