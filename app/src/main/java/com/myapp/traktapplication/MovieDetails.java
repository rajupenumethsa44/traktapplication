package com.myapp.traktapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        String title= intent.getStringExtra("title");
        String year=intent.getStringExtra("year");
        String overview=intent.getStringExtra("overview");
        String released_date=intent.getStringExtra("released_date");
        String runtime=intent.getStringExtra("runtime");
        String genresString=intent.getStringExtra("genresString");

        TextView movie_name = (TextView) findViewById(R.id.moviedetails_name);
        TextView movie_year = (TextView) findViewById(R.id.moviedetails_year);
        TextView movie_overview = (TextView) findViewById(R.id.moviedetails_overview);
        TextView movie_genre = (TextView) findViewById(R.id.moviedetails_genere);

        movie_name.setText(title);
        movie_year.setText(released_date);
        movie_overview.setText(overview);
        movie_genre.setText(genresString);


        getSupportActionBar().setTitle(title);

    }

}

