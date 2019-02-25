package com.myapp.traktapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {
    String BASE_URL = "https://api-v2launch.trakt.tv/movies/";
    @GET("popular?page=1&extended=full,images")
    Call<List<ModelMovieList>> getMovieList(@Header("Content-Type") String type,
                                            @Header("trakt-api-version") String version,
                                            @Header("trakt-api-key") String key
    );
}
