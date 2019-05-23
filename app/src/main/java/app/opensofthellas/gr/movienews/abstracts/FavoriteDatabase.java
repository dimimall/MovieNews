package app.opensofthellas.gr.movienews.abstracts;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.opensofthellas.gr.movienews.interfaces.FavoriteDao;
import app.opensofthellas.gr.movienews.models.Favorite;

@Database(entities = {Favorite.class}, version = 1, exportSchema = false)
public abstract class FavoriteDatabase extends RoomDatabase {

    private static FavoriteDatabase favoriteDatabase;
    public abstract FavoriteDao favorite();
    private Context context;
    public static FavoriteDatabase getInstance(Context context){
        if(favoriteDatabase == null){
            favoriteDatabase = Room.databaseBuilder(context.getApplicationContext(), FavoriteDatabase.class, "favorite_table")
                    .allowMainThreadQueries()
                    .build();
        }
        return favoriteDatabase;
    }

    public static void destroyInstance() {
        favoriteDatabase = null;
    }
}
