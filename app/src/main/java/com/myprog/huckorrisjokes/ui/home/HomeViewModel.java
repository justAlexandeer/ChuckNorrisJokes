package com.myprog.huckorrisjokes.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.myprog.huckorrisjokes.model.JsonPlaceHolderApi;
import com.myprog.huckorrisjokes.model.responseobject.Joke;
import com.myprog.huckorrisjokes.model.responseobject.ResponseJokes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Joke>> jokeList;
    private Retrofit retrofit;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private final static String BASE_URL = "http://api.icndb.com/";

    public HomeViewModel() {
        jokeList = new MutableLiveData<>();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }

    public void getJokesFromServer(int count){
        Call<ResponseJokes> call = jsonPlaceHolderApi.getJokes(count);
        call.enqueue(new Callback<ResponseJokes>() {
            @Override
            public void onResponse(Call<ResponseJokes> call, Response<ResponseJokes> response) {
                if(response.body().getJokeList() != null) {
                    updateListJokes(response.body().getJokeList());
                }
            }
            @Override
            public void onFailure(Call<ResponseJokes> call, Throwable t) {
                Log.d("Throwable", t.toString());
            }
        });
    }

    private void updateListJokes(List<Joke> list){
        jokeList.setValue(list);
    }

    public LiveData<List<Joke>> getJokes(){return jokeList;}
}