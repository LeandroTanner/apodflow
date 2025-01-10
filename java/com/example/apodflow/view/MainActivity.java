package com.example.apodflow.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.apodflow.R;
import com.example.apodflow.controller.apod.ApodAdapter;
import com.example.apodflow.controller.service.ApodService;
import com.example.apodflow.model.apod.Apod;
import com.example.apodflow.model.retrofit.RetrofitClientApod;
import com.example.apodflow.utils.ToolKit;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ToolKit tk = new ToolKit();
    private String api_key = tk.getApiKey();

    private RetrofitClientApod cl = new RetrofitClientApod();
    private Retrofit retrofit;
    private ApodService apodService;

    private RecyclerView recyclerView;
    private ApodAdapter adapter;
    private List<Apod> apodList;

    private boolean isLoading = false; // Para evitar multiplas chamadas
    private int currentPage = 1;// Para evitar duplicação de dados

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recycler);
        apodList = new ArrayList<>();
        adapter = new ApodAdapter(apodList);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Comportamento de "TikTok"
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        retrofit = cl.getClient();
        apodService = retrofit.create(ApodService.class);

        chamarQuantidade(3);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    isLoading = true; // Muda o estado para mostrar que está carregando
                    chamarQuantidade(3);
                }
            }
        });
    }

    public void chamarQuantidade(int quantidade) {
        Call<List<Apod>> call = apodService.countSearch(api_key, quantidade);

        call.enqueue(new Callback<List<Apod>>() {
            @Override
            public void onResponse(Call<List<Apod>> call, Response<List<Apod>> response) {
                if (response.isSuccessful()) {
                    List<Apod> apodRecuperados = response.body();
                    if (apodRecuperados != null && !apodRecuperados.isEmpty()) {
                        apodList.addAll(apodRecuperados);
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MainActivity.this, "Sem mais vídeos para carregar", Toast.LENGTH_SHORT).show();
                    }
                }
                isLoading = false; // MUda o estado para liberar o carregamento
            }

            @Override
            public void onFailure(Call<List<Apod>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                isLoading = false;
            }
        });
    }

    public  void menu(View view){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}