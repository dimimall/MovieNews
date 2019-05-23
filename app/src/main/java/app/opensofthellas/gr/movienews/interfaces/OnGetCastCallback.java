package app.opensofthellas.gr.movienews.interfaces;

import java.util.List;

import app.opensofthellas.gr.movienews.models.Casting;

public interface OnGetCastCallback {

    void onSuccess(List<Casting> castings);

    void onError();
}
