package app.opensofthellas.gr.movienews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.List;

import app.opensofthellas.gr.movienews.abstracts.FavoriteDatabase;
import app.opensofthellas.gr.movienews.adapters.RoomAdapterFavorite;
import app.opensofthellas.gr.movienews.interfaces.FavoriteDao;
import app.opensofthellas.gr.movienews.models.Favorite;

public class FavoriteListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewRoom;
    private RecyclerView.Adapter favoriteAdapter;
    private RecyclerView.LayoutManager layoutManagerFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        recyclerViewRoom = (RecyclerView) findViewById(R.id.favoriteList);
        recyclerViewRoom.setHasFixedSize(true);
        layoutManagerFavorite = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewRoom.setLayoutManager(layoutManagerFavorite);

        FavoriteDao favoriteDao = (FavoriteDao) FavoriteDatabase.getInstance(getApplicationContext()).favorite();
        favoriteDao.getAllFavorites().observe(this, (List<Favorite> favorite) -> {
            favoriteAdapter = new RoomAdapterFavorite(FavoriteListActivity.this, favorite);
            recyclerViewRoom.setAdapter(favoriteAdapter);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
