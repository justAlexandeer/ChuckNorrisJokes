package com.myprog.huckorrisjokes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myprog.huckorrisjokes.R;
import com.myprog.huckorrisjokes.model.responseobject.Joke;

import java.util.List;

public class MainJokeAdapter extends RecyclerView.Adapter<MainJokeAdapter.MyViewHolder> {

    List<Joke> listJoke;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewJoke;
        public MyViewHolder(View itemView){
            super(itemView);
            textViewJoke = itemView.findViewById(R.id.jokeCell_textView);
        }
    }

    public void  setJokes(List<Joke> list){
        listJoke = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.joke_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Joke jokeNow = listJoke.get(position);
        holder.textViewJoke.setText(jokeNow.getJoke());
    }

    @Override
    public int getItemCount() {
        if(listJoke == null)
            return 0;
        return listJoke.size();
    }
}
