package app.opensofthellas.gr.movienews.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastingResponse {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("cast")
    @Expose
    private List<Casting> castingList;

    public void setId(int id) {this.id = id;}
    public int getId() {return this.id;}
    public void setCastingList(List<Casting> castingList) { this.castingList = castingList; }
    public List<Casting> getCastingList() { return this.castingList; }
}
