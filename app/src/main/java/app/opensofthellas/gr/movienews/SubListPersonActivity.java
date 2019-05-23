package app.opensofthellas.gr.movienews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import app.opensofthellas.gr.movienews.adapters.PeopleAdapter;
import app.opensofthellas.gr.movienews.adapters.PeopleMovieAdapter;
import app.opensofthellas.gr.movienews.models.KnownFor;

public class SubListPersonActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter peopleMovieAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_list_person);


        recyclerView = (RecyclerView) findViewById(R.id.sunListPerson);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        peopleMovieAdapter = new PeopleMovieAdapter((List<KnownFor>) getIntent().getSerializableExtra("knowForList"),SubListPersonActivity.this);
        recyclerView.setAdapter(peopleMovieAdapter);
    }
}
