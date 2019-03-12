package com.example.myspotifyapp.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PopInterfaceApi {
    @GET("search?term=pop&amp;media=music&amp;entity=song&amp;limit=50")
    Call<SongsDescription> getRandomSongs();

}
