package com.example.myspotifyapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RockListAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        ((ListViewHolder) holder).bindView(i);

    }

    @Override
    public int getItemCount() {
        return RockFragment.result_count;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView song_image;
        private String imageUri;
        private TextView artist_name, collection_name, song_url, track_price;

        public ListViewHolder( View itemView) {
            super(itemView);
            artist_name = (TextView) itemView.findViewById(R.id.artist_name);
            collection_name = (TextView) itemView.findViewById(R.id.collection_name);
            song_url = (TextView) itemView.findViewById(R.id.artworkUrl);
            track_price = (TextView) itemView.findViewById(R.id.track_price);
            song_image = (ImageView) itemView.findViewById(R.id.songs_image);
            Picasso.with(itemView.getContext()).load(imageUri).into(song_image);
        }

        public  void bindView(int i) {


            artist_name.setText(RockFragment.artist_name.get(i));
            collection_name.setText(RockFragment.collection_name.get(i));
            song_url.setText(RockFragment.art_work_url.get(i));

            //track_price.setText("123");
            track_price.setText(RockFragment.track_price.get(i)+ " USD");
            Picasso.with(itemView.getContext()).load(RockFragment.song_pic.get(i)).into(song_image);

        }
        public void onClick(View view){

        }
    }
}
