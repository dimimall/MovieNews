package app.opensofthellas.gr.movienews.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import app.opensofthellas.gr.movienews.R;
import app.opensofthellas.gr.movienews.models.Movie;

public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.SimilarViewHolder> {

    private List<Movie> movieList;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";
    private Context context;

    public SimilarAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public SimilarAdapter.SimilarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.castinglayout, viewGroup, false);
        return new SimilarAdapter.SimilarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarAdapter.SimilarViewHolder similarViewHolder, int i) {
        similarViewHolder.bind(movieList.get(i));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class SimilarViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView cast_img;

        public SimilarViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView8);
            cast_img = itemView.findViewById(R.id.cast_profile);

        }

        public void bind(Movie movie) {
            name.setText(movie.getTitle());
            Picasso.with(context).load(IMAGE_BASE_URL + movie.getPosterPath()).resize(300,300).memoryPolicy(MemoryPolicy.NO_CACHE).into(cast_img);
        }

    }
}
