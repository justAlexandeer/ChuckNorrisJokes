package com.myprog.huckorrisjokes.model.responseobject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Joke {
    @SerializedName("id")
    public Integer id;
    @SerializedName("joke")
    public String joke;
    @SerializedName("categories")
    public List<Object> categories = null;

    public String getJoke() {
        return joke;
    }
}
