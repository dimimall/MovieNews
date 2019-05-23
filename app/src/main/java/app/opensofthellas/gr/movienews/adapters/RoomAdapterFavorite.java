package app.opensofthellas.gr.movienews.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import app.opensofthellas.gr.movienews.R;
import app.opensofthellas.gr.movienews.models.Favorite;

public class RoomAdapterFavorite extends RecyclerView.Adapter<RoomAdapterFavorite.RoomViewHolder> {

    private List<Favorite> favoriteList;
    private Context context;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    public RoomAdapterFavorite(Context context, List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_fav_layout, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder roomViewHolder, int i) {
        Favorite favorite = favoriteList.get(i);
        Picasso.with(context).load(IMAGE_BASE_URL + favorite.getImageUrl()).memoryPolicy(MemoryPolicy.NO_CACHE).into(roomViewHolder.movieImage);
        roomViewHolder.title.setText(favorite.getName());
        roomViewHolder.release_date.setText(favorite.getRelease_date());
        roomViewHolder.overiview.setText(favorite.getOverview());
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        public TextView title,release_date,overiview;
        public ImageView movieImage;

        public RoomViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            title = itemView.findViewById(R.id.textView6);
            release_date = itemView.findViewById(R.id.textView7);
            overiview = itemView.findViewById(R.id.textView9);
        }
    }
}
