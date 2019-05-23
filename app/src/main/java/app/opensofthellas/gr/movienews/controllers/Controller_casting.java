package app.opensofthellas.gr.movienews.controllers;

import android.util.Log;

import app.opensofthellas.gr.movienews.interfaces.MovieApi;
import app.opensofthellas.gr.movienews.interfaces.OnGetCastCallback;
import app.opensofthellas.gr.movienews.models.CastingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller_casting {

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Controller_casting repository;
    private MovieApi api;

    private Controller_casting(MovieApi api) {
        this.api = api;
    }

    public static Controller_casting getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Controller_casting(retrofit.create(MovieApi.class));
        }

        return repository;
    }

    public void getCasting(final OnGetCastCallback callback, int id) {
        api.getCastingMovie(id, "8dc2e4947c8c911cbfbe7fdfb08c16c3")
                .enqueue(new Callback<CastingResponse>() {
                    @Override
                    public void onResponse(Call<CastingResponse> call, Response<CastingResponse> response) {
                        if (response.isSuccessful()) {
                            CastingResponse castingResponse = response.body();
                            if (castingResponse != null && castingResponse.getCastingList() != null) {
                                Log.d("Controllers","passs");
                                callback.onSuccess(castingResponse.getCastingList());
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<CastingResponse> call, Throwable t) {
                        callback.onError();
                        Log.e("Error callback",t.getLocalizedMessage());
                    }
                });
    }
}
