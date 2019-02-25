package com.myapp.traktapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieList extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        String CLIENT_ID = "ad005b8c117cdeee58a1bdb7089ea31386cd489b21e14b19818c91511f12a086";
        Call<List<ModelMovieList>> movieListCall = api.getMovieList("application/json", "2", CLIENT_ID);

        movieListCall.enqueue(new Callback<List<ModelMovieList>>() {
            @Override
            public void onResponse(Call<List<ModelMovieList>> call, Response<List<ModelMovieList>> response) {

                ArrayList<ModelMovieList> movies = (ArrayList<ModelMovieList>) response.body();

                if (movies != null && movies.size() > 0) {

                    MovieListAdapter movieListAdapter = new MovieListAdapter(MovieList.this, movies);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MovieList.this));
                    recyclerView.setAdapter(movieListAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ModelMovieList>> call, Throwable t) {

            }
        });
    }

}
