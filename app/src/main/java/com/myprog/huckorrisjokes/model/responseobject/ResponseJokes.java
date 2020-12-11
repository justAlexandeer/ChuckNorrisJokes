package com.myprog.huckorrisjokes.model.responseobject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseJokes {
    @SerializedName("type")
    public String type;
    @SerializedName("value")
    public List<Joke> jokeList;

    public List<Joke> getJokeList() {
        return jokeList;
    }
}
