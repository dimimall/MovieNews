package app.opensofthellas.gr.movienews.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.List;

import app.opensofthellas.gr.movienews.ItemActivity;
import app.opensofthellas.gr.movienews.R;
import app.opensofthellas.gr.movienews.models.KnownFor;

public class PeopleMovieAdapter extends RecyclerView.Adapter<PeopleMovieAdapter.PeopleViewHolder>{

    private List<KnownFor> knownFors;
    Context context;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    public PeopleMovieAdapter(List<KnownFor> knownFors, Context context) {
        this.knownFors = knownFors;
        this.context = context;
    }

    @NonNull
    @Override
    public PeopleMovieAdapter.PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new PeopleMovieAdapter.PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleMovieAdapter.PeopleViewHolder peopleViewHolder, int position) {
        peopleViewHolder.bind(knownFors.get(position));
    }

    @Override
    public int getItemCount() {
        return knownFors.size();
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
                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra("item", (Serializable) knownFors.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }

        public void bind(KnownFor knownFor) {
            title.setText(knownFor.getMediaType());

            if (knownFor.getTitle() != null)
                itemName.setText(knownFor.getTitle());
            else {
                itemName.setText(knownFor.getName());
            }
            if (knownFor.getRelease_date() != null)
            {
                release.setText(knownFor.getRelease_date());
            }

            rating.setText(String.valueOf(knownFor.getRating()));

            Glide.with(itemView)
                    .load(IMAGE_BASE_URL + knownFor.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    .into(poster);
        }

    }
}
