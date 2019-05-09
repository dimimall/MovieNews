package app.opensofthellas.gr.movienews;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.opensofthellas.gr.movienews.adapters.ImageAdapter;
import app.opensofthellas.gr.movienews.controllers.Controller_upcoming;
import app.opensofthellas.gr.movienews.interfaces.OnGetMoviesCallback;
import app.opensofthellas.gr.movienews.models.Movie;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private ViewPager viewPager;
    private Controller_upcoming controller_upcoming;
    private ImageAdapter adapter;

    ImageButton cat1;
    ImageButton cat2;
    ImageButton cat3;
    ImageButton cat4;
    ImageButton cat5;
    ImageButton cat6;
    ImageButton cat7;
    ImageButton cat8;
    ImageButton cat9;

    TextView cat1TextView;
    TextView cat2TextView;
    TextView cat3TextView;
    TextView cat4TextView;
    TextView cat5TextView;
    TextView cat6TextView;
    TextView cat7TextView;
    TextView cat8TextView;
    TextView cat9TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat1 = (ImageButton) findViewById(R.id.cat1);
        cat2 = (ImageButton) findViewById(R.id.cat2);
        cat3 = (ImageButton) findViewById(R.id.cat3);
        cat4 = (ImageButton) findViewById(R.id.cat4);
        cat5 = (ImageButton) findViewById(R.id.cat5);
        cat6 = (ImageButton) findViewById(R.id.cat6);
        cat7 = (ImageButton) findViewById(R.id.cat7);
        cat8 = (ImageButton) findViewById(R.id.cat8);


        cat1TextView = (TextView) findViewById(R.id.cat1Text);
        cat2TextView = (TextView) findViewById(R.id.cat2Text);
        cat3TextView = (TextView) findViewById(R.id.cat3Text);
        cat4TextView = (TextView) findViewById(R.id.cat4Text);
        cat5TextView = (TextView) findViewById(R.id.cat5Text);
        cat6TextView = (TextView) findViewById(R.id.cat6Text);
        cat7TextView = (TextView) findViewById(R.id.cat7Text);
        cat8TextView = (TextView) findViewById(R.id.cat8Text);

        cat1.setOnClickListener(this);
        cat1TextView.setOnClickListener(this);

        cat2.setOnClickListener(this);
        cat2TextView.setOnClickListener(this);

        cat3.setOnClickListener(this);
        cat3TextView.setOnClickListener(this);

        cat4.setOnClickListener(this);
        cat4TextView.setOnClickListener(this);

        cat5.setOnClickListener(this);
        cat5TextView.setOnClickListener(this);

        cat6.setOnClickListener(this);
        cat6TextView.setOnClickListener(this);

        cat7.setOnClickListener(this);
        cat7TextView.setOnClickListener(this);

        cat8.setOnClickListener(this);
        cat8TextView.setOnClickListener(this);

        controller_upcoming = Controller_upcoming.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = findViewById(R.id.pager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewPager.setVisibility(View.VISIBLE);
        indicator.setViewPager(viewPager);

        controller_upcoming.getMovies(new OnGetMoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                adapter = new ImageAdapter(MainActivity.this,movies);
                viewPager.setAdapter(adapter);
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this, "Please check your internet connection.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.sync) {

        } else if (id == R.id.about) {

        }
        else if (id == R.id.contact) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent clickIntent;
        switch (v.getId()) {
            case R.id.cat1:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","1");
                startActivity(clickIntent);
                break;
            case R.id.cat1Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","1");
                startActivity(clickIntent);
                break;

            case R.id.cat2:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","2");
                startActivity(clickIntent);
                break;
            case R.id.cat2Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","2");
                startActivity(clickIntent);
                break;
            case R.id.cat3:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","3");
                startActivity(clickIntent);
                break;
            case R.id.cat3Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","3");
                startActivity(clickIntent);
                break;
            case R.id.cat4:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","4");
                startActivity(clickIntent);
                break;
            case R.id.cat4Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","4");
                startActivity(clickIntent);
                break;
            case R.id.cat5:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","5");
                startActivity(clickIntent);
                break;
            case R.id.cat5Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","5");
                startActivity(clickIntent);
                break;
            case R.id.cat6:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","6");
                startActivity(clickIntent);
                break;
            case R.id.cat6Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","6");
                startActivity(clickIntent);
                break;
            case R.id.cat7:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","7");
                startActivity(clickIntent);
                break;
            case R.id.cat7Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","7");
                startActivity(clickIntent);
                break;
            case R.id.cat8:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","8");
                startActivity(clickIntent);
                break;
            case R.id.cat8Text:
                clickIntent = new Intent(MainActivity.this,ItemListActivity.class);
                clickIntent.putExtra("controller","8");
                startActivity(clickIntent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
