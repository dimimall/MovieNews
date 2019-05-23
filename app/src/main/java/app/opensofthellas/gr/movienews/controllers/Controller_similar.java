package app.opensofthellas.gr.movienews.controllers;

import android.util.Log;

import app.opensofthellas.gr.movienews.interfaces.MovieApi;
import app.opensofthellas.gr.movienews.interfaces.OnGetSimilarCallback;
import app.opensofthellas.gr.movienews.models.MoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller_similar {

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Controller_similar repository;
    private MovieApi api;

    private Controller_similar(MovieApi api) {
        this.api = api;
    }

    public static Controller_similar getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Controller_similar(retrofit.create(MovieApi.class));
        }

        return repository;
    }

    public void getSimilar(final OnGetSimilarCallback callback, int id) {
        api.getSimilarMovie(id, "8dc2e4947c8c911cbfbe7fdfb08c16c3")
                .enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if (response.isSuccessful()) {
                            MoviesResponse moviesResponse = response.body();
                            if (moviesResponse != null && moviesResponse.getMovies() != null) {
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
