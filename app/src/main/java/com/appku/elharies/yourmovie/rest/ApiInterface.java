package com.appku.elharies.yourmovie.rest;

import com.appku.elharies.yourmovie.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by El Haries on 6/1/2017.
 */

public interface ApiInterface {
    @GET("movie/popular")
    Call<MovieResponse> getMoviePopular(@Query("api_key") String apiKey);


    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
