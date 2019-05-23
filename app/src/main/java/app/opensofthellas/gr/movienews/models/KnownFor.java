package app.opensofthellas.gr.movienews.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class KnownFor implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("media_type")
    @Expose
    private String mediaType;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("vote_average")
    @Expose
    private float rating;

    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds;

    @SerializedName("release_date")
    @Expose
    private String release_date;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() { return this.id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public void setRelease_date(String release_date){
        this.release_date = release_date;
    }
    
    public String getRelease_date(){
        return this.release_date;
    }
}
