package app.opensofthellas.gr.movienews.interfaces;

import java.util.List;

import app.opensofthellas.gr.movienews.models.Movie;

public interface OnGetSimilarCallback {

    void onSuccess(List<Movie> similar);

    void onError();
}
