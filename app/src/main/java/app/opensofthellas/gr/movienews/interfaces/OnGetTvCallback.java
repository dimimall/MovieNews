package app.opensofthellas.gr.movienews.interfaces;

import java.util.List;

import app.opensofthellas.gr.movienews.models.Television;


public interface OnGetTvCallback {

    void onSuccess(List<Television> Television);

    void onError();
}
