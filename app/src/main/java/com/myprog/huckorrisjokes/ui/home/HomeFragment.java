package com.myprog.huckorrisjokes.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myprog.huckorrisjokes.R;
import com.myprog.huckorrisjokes.adapter.MainJokeAdapter;
import com.myprog.huckorrisjokes.model.responseobject.Joke;

import java.util.List;

public class HomeFragment extends Fragment {

    private Context context;
    private HomeViewModel homeViewModel;
    private Button buttonReload;
    private EditText countJokes;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        context = getActivity().getApplicationContext();
        buttonReload = root.findViewById(R.id.button_home);
        countJokes = root.findViewById(R.id.editText_home);
        recyclerView = root.findViewById(R.id.recyclerView_home);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        MainJokeAdapter adapter = new MainJokeAdapter();
        recyclerView.setAdapter(adapter);

        buttonReload.setOnClickListener(v -> {
            onClickButton();
        });

        homeViewModel.getJokes().observe(this, list ->{
            adapter.setJokes(list);
        });

        return root;
    }

    private void onClickButton(){
        String count = countJokes.getText().toString();
        if(count.length() == 0){
            Toast.makeText(context, "Введите колличество шуток", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Integer.valueOf(count) < 0){
            Toast.makeText(context, "Кол-во шуток должно быть положительным", Toast.LENGTH_SHORT).show();
            return;
        }
        homeViewModel.getJokesFromServer(Integer.valueOf(count));
    }
}