package com.example.myspotifyapp.model;


import java.util.List;

import com.example.myspotifyapp.model.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SongsDescription {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Integer getResultCount() {
        return resultCount;
    }



    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}