package com.example.myspotifyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class RockFragment extends Fragment {

    static ArrayList<String> artist_name = new ArrayList<>();
    static ArrayList<String> song_pic = new ArrayList<>();
    static ArrayList<String> collection_name = new ArrayList<>();
    static ArrayList<String> art_work_url = new ArrayList<>();
    static ArrayList<String> track_price = new ArrayList<>();


    RecyclerView recyclerView;
    RockListAdapter RockListAdapter;

    static int result_count;
    String Base_Url = "https://itunes.apple.com/";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rock, container, false);


        initializedRetrofit();

        recyclerView = (RecyclerView) view.findViewById(R.id.rock_songs_holder);

        RockListAdapter = new RockListAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
}

    public void initializedRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RockInterfaceApi rockInterfaceApi = retrofit.create(RockInterfaceApi.class);
        rockInterfaceApi.getRandomSongs().enqueue(new Callback<SongsDescription>() {


            // @Override
            public void onResponse(Call<SongsDescription> call, Response<SongsDescription> response) {



                //tv_fact.setText(response.body().getText());
                // tv_type.setText(response.body().getType());

                result_count = response.body().getResultCount();


                try {
                    for(int i=0; i<result_count; i++){

                        song_pic.add(response.body().getResults().get(i).getArtworkUrl60());
                        artist_name.add(response.body().getResults().get(i).getArtistName());
                        collection_name.add(response.body().getResults().get(i).getCollectionName());
                        art_work_url.add(response.body().getResults().get(i).getPreviewUrl());
                        track_price.add(response.body().getResults().get(i).getTrackPrice().toString());

                    }

                } catch(Exception e){

                    track_price.add("");
                    artist_name.add("");
                    song_pic.add("");
                    collection_name.add("");
                    art_work_url.add("");


                }




                recyclerView.setAdapter(RockListAdapter);


            }

            @Override
            public void onFailure(Call<SongsDescription> call, Throwable t) {


                Toast.makeText(getActivity().getBaseContext(), "Failure", LENGTH_SHORT).show();

            }
        });


    }


}

