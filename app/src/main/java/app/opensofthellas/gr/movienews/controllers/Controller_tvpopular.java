package app.opensofthellas.gr.movienews.controllers;

import android.content.Context;
import android.util.Log;

import app.opensofthellas.gr.movienews.MainActivity;
import app.opensofthellas.gr.movienews.interfaces.MovieApi;
import app.opensofthellas.gr.movienews.interfaces.OnGetTvCallback;
import app.opensofthellas.gr.movienews.models.TvResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller_tvpopular {

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    MainActivity mainActivity;
    Context context;
    private static Controller_tvpopular repository;

    private MovieApi api;

    private Controller_tvpopular(MovieApi api) {
        this.api = api;
    }

    public static Controller_tvpopular getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Controller_tvpopular(retrofit.create(MovieApi.class));
        }

        return repository;
    }

    public void getTvPopular(final OnGetTvCallback callback) {
        api.getTvPopular("8dc2e4947c8c911cbfbe7fdfb08c16c3", "en-US", 1)
                .enqueue(new Callback<TvResponse>() {
                    @Override
                    public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                        if (response.isSuccessful()) {
                            TvResponse tvResponse = response.body();
                            if (tvResponse != null && tvResponse.getTelevisions() != null) {
                                Log.d("Controllers","passs");
                                callback.onSuccess(tvResponse.getTelevisions());
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<TvResponse> call, Throwable t) {
                        callback.onError();
                        Log.e("Error callback",t.getLocalizedMessage());
                    }
                });
    }
}
