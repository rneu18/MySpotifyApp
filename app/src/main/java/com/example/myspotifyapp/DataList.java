package com.example.myspotifyapp;

public class DataList {

    private String songImage, songName, songArtist, songPrice, currancy;



    public DataList(String songImage, String songName, String songArtist, String songPrice, String currancy ) {
        this.songImage = songImage;
        this.songName = songName;
        this.songArtist = songArtist;
        this.songPrice = songPrice;
        this.currancy = currancy;
    }

    public String getSongImage() {
        return songImage;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongPrice() {
        return songPrice;
    }

    public String getCurrancy() {
        return currancy;
    }



}
