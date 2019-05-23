package app.opensofthellas.gr.movienews;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import app.opensofthellas.gr.movienews.abstracts.FavoriteDatabase;
import app.opensofthellas.gr.movienews.adapters.CastingAdapter;
import app.opensofthellas.gr.movienews.adapters.ImageAdapter;
import app.opensofthellas.gr.movienews.adapters.SimilarAdapter;
import app.opensofthellas.gr.movienews.controllers.Controller_casting;
import app.opensofthellas.gr.movienews.controllers.Controller_similar;
import app.opensofthellas.gr.movienews.interfaces.FavoriteDao;
import app.opensofthellas.gr.movienews.interfaces.OnGetCastCallback;
import app.opensofthellas.gr.movienews.interfaces.OnGetSimilarCallback;
import app.opensofthellas.gr.movienews.models.Casting;
import app.opensofthellas.gr.movienews.models.Favorite;
import app.opensofthellas.gr.movienews.models.Movie;

public class ItemActivity extends AppCompatActivity {

    private Controller_casting controller_casting;
    private Controller_similar controller_similar;
    private TextView title,release,overview,rating;
    private RecyclerView recyclerViewCasting;
    private RecyclerView recyclerViewSimilar;
    private RecyclerView.Adapter castingAdapter;
    private RecyclerView.Adapter similarAdapter;
    private RecyclerView.LayoutManager layoutManagerCasting,layoutManagerSimilar;
    private ImageView poster;
    private ImageView favorite;
    private boolean like = false;
    private Favorite favorite_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final Movie movie = (Movie) getIntent().getSerializableExtra("item");

        favorite_obj = new Favorite();
        favorite_obj.setImageUrl(movie.getPosterPath());
        favorite_obj.setName(movie.getTitle());
        favorite_obj.setRelease_date(movie.getReleaseDate());
        favorite_obj.setOverview(movie.getOverview());

        title = findViewById(R.id.textView);
        release = findViewById(R.id.textView2);
        overview = findViewById(R.id.textView3);
        rating = findViewById(R.id.textView5);
        poster = findViewById(R.id.imageView);
        favorite = findViewById(R.id.imageView3);
        favorite.setColorFilter(Color.DKGRAY);
        recyclerViewCasting = (RecyclerView) findViewById(R.id.casting);
        recyclerViewSimilar = (RecyclerView) findViewById(R.id.similar);

        recyclerViewCasting.setHasFixedSize(true);
        recyclerViewSimilar.setHasFixedSize(true);

        layoutManagerCasting = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCasting.setLayoutManager(layoutManagerCasting);

        layoutManagerSimilar = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewSimilar.setLayoutManager(layoutManagerSimilar);

        new DownloadImageFromInternet((ImageView)
                findViewById(R.id.imageView))
                .execute("http://image.tmdb.org/t/p/w500/"+movie.getPosterPath());

        title.setText(movie.getTitle());
        release.setText(movie.getReleaseDate());
        overview.setText(movie.getOverview());
        rating.setText(movie.getRating()+"/"+"10");

        controller_casting = Controller_casting.getInstance();
        controller_casting.getCasting(new OnGetCastCallback(){
            @Override
            public void onSuccess(List<Casting> castings) {
                castingAdapter = new CastingAdapter(castings,ItemActivity.this);
                recyclerViewCasting.setAdapter(castingAdapter);
            }

            @Override
            public void onError() {

            }
        },movie.getId());

        controller_similar = Controller_similar.getInstance();
        controller_similar.getSimilar(new OnGetSimilarCallback() {
            @Override
            public void onSuccess(List<Movie> similar) {
                similarAdapter = new SimilarAdapter(similar,ItemActivity.this);
                recyclerViewSimilar.setAdapter(similarAdapter);
            }

            @Override
            public void onError() {

            }
        },movie.getId());

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!like){
                    FavoriteDao favoriteDao = (FavoriteDao)FavoriteDatabase.getInstance(getApplicationContext()).favorite();
                    favoriteDao.insert(favorite_obj);
                    favorite.setColorFilter(Color.RED);
                    like = true;
                }
                else {
                    FavoriteDao favoriteDao = (FavoriteDao)FavoriteDatabase.getInstance(getApplicationContext()).favorite();
                    favoriteDao.deleteFavorite(favorite_obj);
                    favorite.setColorFilter(Color.DKGRAY);
                    like = false;
                }
            }
        });
    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            Toast.makeText(ItemActivity.this, "Please wait, it may take a few minute...", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
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
