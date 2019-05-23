package app.opensofthellas.gr.movienews.interfaces;

import java.util.List;

import app.opensofthellas.gr.movienews.models.People;

public interface OnGetPeopleCallback {

    void onSuccess(List<People> peopleList);

    void onError();
}
