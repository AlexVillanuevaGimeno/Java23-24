package com.example.recyclerview_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    ArrayList<RecyclerView_list> list_RecyclerView;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        list_RecyclerView = new ArrayList<RecyclerView_list>();
        list_RecyclerView.add(new RecyclerView_list(R.drawable.english,"English"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.art,"Art"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.sport,"Sport"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.science,"Science"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.history,"History"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.tech,"Tech"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.geography,"Geography"));
        list_RecyclerView.add(new RecyclerView_list(R.drawable.education,"Education"));


        RecyclerView_adapter recyclerView_adapter = new RecyclerView_adapter(list_RecyclerView,this);
        recyclerView.setAdapter(recyclerView_adapter);
    }
}