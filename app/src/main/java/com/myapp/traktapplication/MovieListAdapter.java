package com.myapp.traktapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends  RecyclerView.Adapter<MovieListAdapter.MyViewHolder>{

    private LayoutInflater mInflater;
    Context context;
    ArrayList<ModelMovieList> moviesArray;

    public MovieListAdapter(Context context, ArrayList<ModelMovieList> trendingsArr)
    {
        mInflater = LayoutInflater.from(context);
        this.context=context;
        this.moviesArray=trendingsArr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(mInflater.inflate(R.layout.content_movie_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        ModelMovieList movies =moviesArray.get(i);

        final String title = movies.getTitle();
        final String year = movies.getYear().toString();
        final String overview = movies.getOverview();
        final String released_date = movies.getReleased();
        final String runtime = movies.getRuntime().toString();
        final String rating = movies.getRating().toString();
        List<String> genresList = movies.getGenres();

        final String genres = genresList.toString();

        myViewHolder.Movie_name_view.setText(title);
        myViewHolder.Movie_year_view.setText(year);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,MovieDetails.class);
                intent.putExtra("title",title);
                intent.putExtra("year",year);
                intent.putExtra("overview",overview);
                intent.putExtra("released_date",released_date);
                intent.putExtra("runtime",runtime);
                intent.putExtra("genresString",genres);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Movie_name_view;
        TextView Movie_year_view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.Movie_name_view = (TextView) itemView.findViewById(R.id.movie_name);
            this.Movie_year_view = (TextView) itemView.findViewById(R.id.release_year);
        }
    }
}
