package app.opensofthellas.gr.movienews.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import app.opensofthellas.gr.movienews.MainActivity;
import app.opensofthellas.gr.movienews.interfaces.MovieApi;
import app.opensofthellas.gr.movienews.interfaces.OnGetMoviesCallback;
import app.opensofthellas.gr.movienews.models.Movie;
import app.opensofthellas.gr.movienews.models.MoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller_upcoming{

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    MainActivity mainActivity;
    Context context;
    private static Controller_upcoming repository;

    private MovieApi api;

    private Controller_upcoming(MovieApi api) {
        this.api = api;
    }

    public static Controller_upcoming getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Controller_upcoming(retrofit.create(MovieApi.class));
        }

        return repository;
    }

    public void getMovies(final OnGetMoviesCallback callback) {
        api.loadChanges("8dc2e4947c8c911cbfbe7fdfb08c16c3", "en-US", 1)
                .enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if (response.isSuccessful()) {
                            MoviesResponse moviesResponse = response.body();
                            if (moviesResponse != null && moviesResponse.getMovies() != null) {
                                Log.d("Controllers","passs");
                                callback.onSuccess(moviesResponse.getMovies());
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        callback.onError();
                        Log.e("Error callback",t.getLocalizedMessage());
                    }
                });
    }
}
