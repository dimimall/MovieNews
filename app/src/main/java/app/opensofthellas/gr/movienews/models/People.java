package app.opensofthellas.gr.movienews.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    @SerializedName("overview")
    @Expose
    private String rating;

    @SerializedName("popularity")
    @Expose
    private float popularity;

    @SerializedName("known_for")
    @Expose
    private List<KnownFor> knownFors;


    public void setId(int id)
    {
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setProfilePath(String profilePath) { this.profilePath = profilePath; }
    public String getProfilePath() { return this.profilePath; }
    public void setBackdropPath(String backdropPath){
        this.backdropPath = backdropPath;
    }
    public String getBackdropPath(){
        return this.backdropPath;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public String getRating(){
        return this.rating;
    }
    public void setPopularity(){
        this.popularity = popularity;
    }
    public float getPopularity(){
        return this.popularity;
    }
    public List<KnownFor> getKnownFors() { return knownFors; }
    public void setKnownFors(List<KnownFor> knownFors) { this.knownFors = knownFors; }
}
