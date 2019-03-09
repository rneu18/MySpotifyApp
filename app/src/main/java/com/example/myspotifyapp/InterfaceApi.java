package com.example.myspotifyapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceApi {
    @GET("/facts/random")
    Call<SongsDescription> getRandomSongs();
    //https://cat-fact.herokuapp.com/facts/random
}
