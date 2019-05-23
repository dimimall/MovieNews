package app.opensofthellas.gr.movienews.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Casting {

    @SerializedName("cast_id")
    @Expose
    private int cast_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    @SerializedName("character")
    @Expose
    private String character;

    public void setCast_id(int cast_id) { this.cast_id = cast_id; }
    public int getCast_id() { return this.cast_id; }
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setProfilePath(String profilePath) { this.profilePath = profilePath; }
    public String getProfilePath() { return this.profilePath; }
    public void setCharacter(String character) { this.character = character; }
    public String getCharacter() { return this.character; }
}
