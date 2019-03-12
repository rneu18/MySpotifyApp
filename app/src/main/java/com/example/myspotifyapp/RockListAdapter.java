package com.example.myspotifyapp;

import android.support.v7.widget.CardView;
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
        public String imageUri;
        CardView cv;
        private TextView artist_name, collection_name, song_url, track_price;

        public ListViewHolder( View itemView) {
            super(itemView);
            artist_name = (TextView) itemView.findViewById(R.id.artist_name);
            collection_name = (TextView) itemView.findViewById(R.id.collection_name);
          //  song_url = (TextView) itemView.findViewById(R.id.artworkUrl);
            track_price = (TextView) itemView.findViewById(R.id.track_price);
            song_image = (ImageView) itemView.findViewById(R.id.songs_image);
            Picasso.with(itemView.getContext()).load(imageUri).into(song_image);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }

        public  void bindView(int i) {
            try{
                track_price.setText(RockFragment.track_price.get(i)+ " USD");
            }
            catch (Exception e){
                track_price.setText("");
            }
            try{
                artist_name.setText(RockFragment.artist_name.get(i));
            }
            catch (Exception e){
                artist_name.setText("");
            }
            try{
                collection_name.setText(RockFragment.collection_name.get(i));
            }
            catch (Exception e){
                collection_name.setText("");
            }

            try{
                Picasso.with(itemView.getContext()).load(RockFragment.song_pic.get(i)).into(song_image);
                imageUri = RockFragment.song_pic.get(i);
                //  song_url.setText("");

            }
            catch (Exception e){
                imageUri = "";

            }
        }
        public void onClick(View view){

        }
    }
}
