package app.opensofthellas.gr.movienews.adapters;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
import app.opensofthellas.gr.movienews.models.Casting;

public class CastingAdapter extends RecyclerView.Adapter<CastingAdapter.CastingViewHolder>{

    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";
    private List<Casting> castingList;
    private Context context;

    public CastingAdapter(List<Casting> castingList, Context context) {
        this.castingList = castingList;
        this.context = context;
    }

    @NonNull
    @Override
    public CastingAdapter.CastingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.castinglayout, viewGroup, false);
        return new CastingAdapter.CastingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastingAdapter.CastingViewHolder castingViewHolder, int i) {
        castingViewHolder.bind(castingList.get(i));
    }

    @Override
    public int getItemCount() {
        return castingList.size();
    }

    class CastingViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView cast_img;

        public CastingViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView8);
            cast_img = itemView.findViewById(R.id.cast_profile);

        }

        public void bind(Casting casting) {
            name.setText(casting.getName());
            Picasso.with(context).load(IMAGE_BASE_URL + casting.getProfilePath()).resize(300,300).memoryPolicy(MemoryPolicy.NO_CACHE).into(cast_img);
        }

    }
}
