package com.example.apodflow.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apodflow.R;
import com.example.apodflow.controller.apod.ApodAdapter;
import com.example.apodflow.model.apod.Apod;

import java.util.ArrayList;
import java.util.List;

public class ApodListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Apod> apodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apod_list);

        recyclerView = findViewById(R.id.apod_list_recycler);


        Intent intent = getIntent();
        apodList = intent.getParcelableArrayListExtra("apod_list");
        if (apodList == null) {
            apodList = new ArrayList<>();
        }


        ApodAdapter adapter = new ApodAdapter(apodList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Essa parte que da o efeito de tiktok, pois centraliza as imagens uma por vez
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}
