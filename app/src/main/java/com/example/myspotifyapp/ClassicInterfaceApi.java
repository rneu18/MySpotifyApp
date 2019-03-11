package com.example.myspotifyapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClassicInterfaceApi {
    @GET("search?term=classic&amp;media=music&amp;entity=song&amp;limit=50")
    Call<SongsDescription> getRandomSongs();
    //https://cat-fact.herokuapp.com/facts/random

    //SomeClass getSomeClass(@Query("param") int param);
}
