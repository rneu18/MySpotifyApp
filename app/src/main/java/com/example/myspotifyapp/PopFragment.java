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

public class PopFragment extends Fragment {

    static ArrayList<String> artist_name = new ArrayList<>();
    static ArrayList<String> song_pic = new ArrayList<>();
    static ArrayList<String> collection_name = new ArrayList<>();
    static ArrayList<String> art_work_url = new ArrayList<>();
    static ArrayList<String> track_price = new ArrayList<>();


    RecyclerView recyclerView;
    PopListAdapter PopListAdapter;

    static int result_count;
    String Base_Url = "https://itunes.apple.com/";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pop, container, false);

        initializedRetrofit();

        recyclerView = (RecyclerView) view.findViewById(R.id.pop_songs_holder);

        PopListAdapter = new PopListAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public void initializedRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PopInterfaceApi popInterfaceApi = retrofit.create(PopInterfaceApi.class);
        popInterfaceApi.getRandomSongs().enqueue(new Callback<SongsDescription>() {


            // @Override
            public void onResponse(Call<SongsDescription> call, Response<SongsDescription> response) {

                result_count = response.body().getResultCount();
                try {
                    for(int i=0; i<result_count; i++){
                        song_pic.add(response.body().getResults().get(i).getArtworkUrl60());
                   }
                } catch(Exception e){
                    song_pic.add("");
                }
                try {
                    for(int i=0; i<result_count; i++){
                        artist_name.add(response.body().getResults().get(i).getArtistName());
                    }
                } catch(Exception e){
                    artist_name.add("");
                }
                try {
                    for(int i=0; i<result_count; i++){
                        collection_name.add(response.body().getResults().get(i).getCollectionName());
                    }
                } catch(Exception e){
                    collection_name.add("");
                }
                try {
                    for(int i=0; i<result_count; i++){
                        art_work_url.add(response.body().getResults().get(i).getPreviewUrl());
                    }
                } catch(Exception e){
                    art_work_url.add("");
                }
                try {
                    for(int i=0; i<result_count; i++){
                        track_price.add(response.body().getResults().get(i).getTrackPrice().toString());
                    }

                } catch(Exception e){
                    track_price.add("");
                }
                recyclerView.setAdapter(PopListAdapter);


            }

            @Override
            public void onFailure(Call<SongsDescription> call, Throwable t) {


                Toast.makeText(getActivity().getBaseContext(), "Failure", LENGTH_SHORT).show();

            }
        });


    }


}

