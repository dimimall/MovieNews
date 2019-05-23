package app.opensofthellas.gr.movienews.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import app.opensofthellas.gr.movienews.models.Favorite;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface FavoriteDao {

    @Insert(onConflict = REPLACE)
    void insert(Favorite favorite);

    @Delete
    void deleteFavorite(Favorite favorite);

    @Query("SELECT * from favorite_table ORDER BY name ASC")
    LiveData<List<Favorite>> getAllFavorites();
}
