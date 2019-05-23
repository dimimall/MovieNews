package app.opensofthellas.gr.movienews.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.List;

import app.opensofthellas.gr.movienews.R;
import app.opensofthellas.gr.movienews.SubListPersonActivity;
import app.opensofthellas.gr.movienews.models.People;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{

    private List<People> peopleList;
    Context context;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    public PeopleAdapter(List<People> peopleList, Context context) {
        this.peopleList = peopleList;
        this.context = context;
    }

    @NonNull
    @Override
    public PeopleAdapter.PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new PeopleAdapter.PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.PeopleViewHolder peopleViewHolder, int position) {
        peopleViewHolder.bind(peopleList.get(position));
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView title;
        TextView rating;
        TextView release;
        ImageView poster;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_movie_release_date);
            title = itemView.findViewById(R.id.item_movie_title);
            rating = itemView.findViewById(R.id.item_movie_rating);
            release = itemView.findViewById(R.id.item_movie_release);
            poster = itemView.findViewById(R.id.item_movie_poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SubListPersonActivity.class);
                    intent.putExtra("knowForList", (Serializable) peopleList.get(getAdapterPosition()).getKnownFors());
                    context.startActivity(intent);
                }
            });
        }

        public void bind(People people) {
            title.setText(people.getName());
//            if (people.getKnownFors().get(0).getTitle() != null)
//                itemName.setText(people.getKnownFors().get(0).getTitle());
//            else {
//                itemName.setText(people.getKnownFors().get(0).getName());
//            }
//            if (people.getKnownFors().get(0).getRelease_date() != null)
//            {
//                release.setText(people.getKnownFors().get(0).getRelease_date());
//            }

            //rating.setText(String.valueOf(people.getKnownFors().get(0).getRating()));
            Glide.with(itemView)
                    .load(IMAGE_BASE_URL + people.getProfilePath())
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    .into(poster);
        }
    }
}
