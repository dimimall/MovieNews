package app.opensofthellas.gr.movienews.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "favorite_table")
public class Favorite {

    @NonNull
    @ColumnInfo(name = "image_url")
    String imageUrl;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    String name;
    @NonNull
    @ColumnInfo(name = "release_date")
    String release_date;
    @NonNull
    @ColumnInfo(name = "overview")
    String overview;

    public Favorite(){
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl(){return this.imageUrl;}

    public void setName(@NonNull String name){
        this.name = name;
    }
    public String getName() {return this.name;}

    public void setRelease_date(@NonNull String release_date){
        this.release_date = release_date;
    }
    public String getRelease_date() {return this.release_date;}

    public void setOverview(@NonNull String overview) {
        this.overview = overview;
    }
    public String getOverview() {return this.overview;}
}
