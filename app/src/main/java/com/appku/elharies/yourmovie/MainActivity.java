package com.appku.elharies.yourmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.appku.elharies.yourmovie.adapter.MovieAdapter;
import com.appku.elharies.yourmovie.model.MovieResponse;
import com.appku.elharies.yourmovie.model.Result;
import com.appku.elharies.yourmovie.rest.ApiClient;
import com.appku.elharies.yourmovie.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String API_KEY = "cfca9d4452fa2c08f658bda6fc1525ca";
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "PLease Obtain Your API Key", Toast.LENGTH_SHORT).show();
            return;
        }else {
            YourMovie();
        }


    }

    public void YourMovie() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_movie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getMoviePopular(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Result> movies = response.body().getResults();
                Log.d(TAG, "Number of Movies: " + movies.size());
                recyclerView.setAdapter(new MovieAdapter(movies, R.id.layout_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
