package com.appku.elharies.yourmovie.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by El Haries on 6/1/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "http://api.themoviedb.com/3/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        return retrofit == null ? retrofit = new Retrofit.Builder().
                baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() : retrofit;
    }
}
