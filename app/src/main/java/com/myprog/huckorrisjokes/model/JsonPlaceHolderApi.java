package com.myprog.huckorrisjokes.model;

import com.myprog.huckorrisjokes.model.responseobject.ResponseJokes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("jokes/random/{count}")
    Call<ResponseJokes> getJokes(@Path("count") int count);
}
