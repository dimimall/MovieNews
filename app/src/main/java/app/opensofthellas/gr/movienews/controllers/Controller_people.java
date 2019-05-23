package app.opensofthellas.gr.movienews.controllers;

import android.content.Context;
import android.util.Log;

import app.opensofthellas.gr.movienews.MainActivity;
import app.opensofthellas.gr.movienews.interfaces.MovieApi;
import app.opensofthellas.gr.movienews.interfaces.OnGetMoviesCallback;
import app.opensofthellas.gr.movienews.interfaces.OnGetPeopleCallback;
import app.opensofthellas.gr.movienews.models.MoviesResponse;
import app.opensofthellas.gr.movienews.models.PeopleResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller_people {

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    Context context;
    private static Controller_people repository;

    private MovieApi api;

    private Controller_people(MovieApi api) {
        this.api = api;
    }

    public static Controller_people getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new Controller_people(retrofit.create(MovieApi.class));
        }

        return repository;
    }

    public void getPeople(final OnGetPeopleCallback callback) {
        api.getPopularPerson("8dc2e4947c8c911cbfbe7fdfb08c16c3", "en-US", 1)
                .enqueue(new Callback<PeopleResponse>() {
                    @Override
                    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                        if (response.isSuccessful()) {
                            PeopleResponse peopleResponse = response.body();
                            if (peopleResponse != null && peopleResponse.getPeopleList() != null) {
                                callback.onSuccess(peopleResponse.getPeopleList());
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<PeopleResponse> call, Throwable t) {
                        callback.onError();
                        Log.e("Error callback",t.getLocalizedMessage());
                    }
                });
    }

}
