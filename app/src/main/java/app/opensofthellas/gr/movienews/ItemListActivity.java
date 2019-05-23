package app.opensofthellas.gr.movienews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import app.opensofthellas.gr.movienews.adapters.ImageAdapter;
import app.opensofthellas.gr.movienews.adapters.MoviesAdapter;
import app.opensofthellas.gr.movienews.adapters.PeopleAdapter;
import app.opensofthellas.gr.movienews.adapters.TvAdapter;
import app.opensofthellas.gr.movienews.controllers.Controller_nowplaying;
import app.opensofthellas.gr.movienews.controllers.Controller_people;
import app.opensofthellas.gr.movienews.controllers.Controller_popular;
import app.opensofthellas.gr.movienews.controllers.Controller_toprate;
import app.opensofthellas.gr.movienews.controllers.Controller_tvontheair;
import app.opensofthellas.gr.movienews.controllers.Controller_tvpopular;
import app.opensofthellas.gr.movienews.controllers.Controller_tvtoprated;
import app.opensofthellas.gr.movienews.controllers.Controller_upcoming;
import app.opensofthellas.gr.movienews.interfaces.OnGetMoviesCallback;
import app.opensofthellas.gr.movienews.interfaces.OnGetPeopleCallback;
import app.opensofthellas.gr.movienews.interfaces.OnGetTvCallback;
import app.opensofthellas.gr.movienews.models.Movie;
import app.opensofthellas.gr.movienews.models.People;
import app.opensofthellas.gr.movienews.models.Television;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter tvAdapter;
    private RecyclerView.Adapter peopleAdapter;
    private Controller_popular controller_popular;
    private Controller_upcoming controller_upcoming;
    private Controller_toprate controller_toprate;
    private Controller_nowplaying controller_nowplaying;
    private Controller_tvontheair controller_tvontheair;
    private Controller_tvpopular controller_tvpopular;
    private Controller_tvtoprated controller_tvtoprated;
    private Controller_people controller_people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        String controller = getIntent().getStringExtra("controller");

        if (controller.equals("1"))
        {
            Log.e("Error",controller);

            controller_popular = Controller_popular.getInstance();
            controller_popular.getMovies(new OnGetMoviesCallback() {
                @Override
                public void onSuccess(List<Movie> movies) {
                    mAdapter = new MoviesAdapter(movies,ItemListActivity.this);
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("2"))
        {
            controller_upcoming = Controller_upcoming.getInstance();
            controller_upcoming.getMovies(new OnGetMoviesCallback() {
                @Override
                public void onSuccess(List<Movie> movies) {
                    mAdapter = new MoviesAdapter(movies,ItemListActivity.this);
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("3"))
        {
            controller_toprate = Controller_toprate.getInstance();
            controller_toprate.getMovies(new OnGetMoviesCallback() {
                @Override
                public void onSuccess(List<Movie> movies) {
                    mAdapter = new MoviesAdapter(movies,ItemListActivity.this);
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("4"))
        {
            controller_tvontheair = Controller_tvontheair.getInstance();
            controller_tvontheair.getTvOnAir(new OnGetTvCallback() {
                @Override
                public void onSuccess(List<Television> televisions) {
                    tvAdapter = new TvAdapter(televisions);
                    recyclerView.setAdapter(tvAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("5"))
        {
            controller_tvpopular = Controller_tvpopular.getInstance();
            controller_tvpopular.getTvPopular(new OnGetTvCallback() {
                @Override
                public void onSuccess(List<Television> televisions) {
                    tvAdapter = new TvAdapter(televisions);
                    recyclerView.setAdapter(tvAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("6"))
        {
            controller_tvtoprated= Controller_tvtoprated.getInstance();
            controller_tvtoprated.getTvTopRated(new OnGetTvCallback() {
                @Override
                public void onSuccess(List<Television> televisions) {
                    tvAdapter = new TvAdapter(televisions);
                    recyclerView.setAdapter(tvAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("7"))
        {
            controller_nowplaying = Controller_nowplaying.getInstance();
            controller_nowplaying.getMovies(new OnGetMoviesCallback() {
                @Override
                public void onSuccess(List<Movie> movies) {
                    mAdapter = new MoviesAdapter(movies,ItemListActivity.this);
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (controller.equals("8"))
        {
            controller_people = Controller_people.getInstance();
            controller_people.getPeople(new OnGetPeopleCallback() {
                @Override
                public void onSuccess(List<People> people) {
                    peopleAdapter = new PeopleAdapter(people,ItemListActivity.this);
                    recyclerView.setAdapter(peopleAdapter);
                }

                @Override
                public void onError() {
                    Toast.makeText(ItemListActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });

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
