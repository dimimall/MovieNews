package app.opensofthellas.gr.movienews.interfaces;

import java.util.List;

import app.opensofthellas.gr.movienews.models.Movie;

public interface OnGetMoviesCallback {

    void onSuccess(List<Movie> movies);

    void onError();
}
