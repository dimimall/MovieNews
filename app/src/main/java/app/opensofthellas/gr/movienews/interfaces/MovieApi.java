package app.opensofthellas.gr.movienews.interfaces;

import java.util.List;

import app.opensofthellas.gr.movienews.models.CastingResponse;
import app.opensofthellas.gr.movienews.models.Movie;
import app.opensofthellas.gr.movienews.models.MoviesResponse;
import app.opensofthellas.gr.movienews.models.PeopleResponse;
import app.opensofthellas.gr.movienews.models.TvResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/upcoming")
    Call<MoviesResponse> loadChanges(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page);

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("tv/on_the_air")
    Call<TvResponse> getTvOnTheAir(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("tv/popular")
    Call<TvResponse> getTvPopular(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("tv/top_rated")
    Call<TvResponse> getTvTopRated(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("person/popular")
    Call<PeopleResponse> getPopularPerson(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("person/popular")
    Call<MoviesResponse> getPersonMovie(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("movie/{movie_id}/credits")
    Call<CastingResponse> getCastingMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String apiKey
    );

    @GET("movie/{movie_id}/similar")
    Call<MoviesResponse> getSimilarMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String apiKey
    );
}
