package com.example.myspotifyapp.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RockInterfaceApi {
    @GET("search?term=rock&amp;media=music&amp;entity=song&amp;limit=50")
    Call<SongsDescription> getRandomSongs();
    //https://cat-fact.herokuapp.com/facts/random

    //SomeClass getSomeClass(@Query("param") int param);
}
