package app.opensofthellas.gr.movienews.controllers;

import android.content.Context;
import android.util.Log;

import app.opensofthellas.gr.movienews.MainActivity;
import app.opensofthellas.gr.movienews.interfaces.MovieApi;
import app.opensofthellas.gr.movienews.interfaces.OnGetMoviesCallback;
import app.opensofthellas.gr.movienews.models.MoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller_nowplaying {

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    MainActivity mainActivity;
    Context context;
    private static Controller_nowplaying repository;

    private MovieApi api;

    private Controller_nowplaying(MovieApi api) {
        this.api = api;
    }

    public static Controller_nowplaying getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Controller_nowplaying(retrofit.create(MovieApi.class));
        }

        return repository;
    }

    public void getMovies(final OnGetMoviesCallback callback) {
        api.getNowPlayingMovies("8dc2e4947c8c911cbfbe7fdfb08c16c3", "en-US", 1)
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
