package app.opensofthellas.gr.movienews.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import app.opensofthellas.gr.movienews.R;
import app.opensofthellas.gr.movienews.models.Movie;
import app.opensofthellas.gr.movienews.models.Television;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder>{

    private List<Television> televisions;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    public TvAdapter(List<Television> televisions) {
        this.televisions = televisions;
    }

    @Override
    public TvAdapter.TvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new TvAdapter.TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TvAdapter.TvViewHolder holder, int position) {
        holder.bind(televisions.get(position));
    }

    @Override
    public int getItemCount() {
        return televisions.size();
    }

    class TvViewHolder extends RecyclerView.ViewHolder {
        TextView releaseDate;
        TextView title;
        TextView rating;
        ImageView poster;

        public TvViewHolder(View itemView) {
            super(itemView);
            releaseDate = itemView.findViewById(R.id.item_movie_release_date);
            title = itemView.findViewById(R.id.item_movie_title);
            rating = itemView.findViewById(R.id.item_movie_rating);
            poster = itemView.findViewById(R.id.item_movie_poster);
        }

        public void bind(Television television) {
            releaseDate.setText(television.getFirstAirDate().split("-")[0]);
            title.setText(television.getTitle());
            rating.setText(String.valueOf(television.getRating()));

            Glide.with(itemView)
                    .load(IMAGE_BASE_URL + television.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    .into(poster);
        }
    }

}
