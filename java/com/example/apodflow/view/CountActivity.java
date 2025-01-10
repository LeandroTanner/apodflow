package com.example.apodflow.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apodflow.R;
import com.example.apodflow.controller.service.ApodService;
import com.example.apodflow.model.apod.Apod;
import com.example.apodflow.model.retrofit.RetrofitClientApod;
import com.example.apodflow.utils.ToolKit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CountActivity extends AppCompatActivity {

    private ToolKit tk = new ToolKit();
    private  String api_key = tk.getApiKey();

    private RetrofitClientApod cl = new RetrofitClientApod();

    private Retrofit retrofit;

    private ApodService apodService;

    private List<Apod> apod_list;

    private EditText inputCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        apod_list = new ArrayList<>();

        retrofit = cl.getClient();

        apodService = retrofit.create(ApodService.class);

        inputCount = findViewById(R.id.count_layout_inputCount);


    }

    public void count_createApodList(View view){

        String txtCount = inputCount.getText().toString().trim();
        Integer count = Integer.parseInt(txtCount);

        if (!txtCount.isEmpty() && count > 0){

            Call<List<Apod>> call = apodService.countSearch(api_key, count);

            call.enqueue(new Callback<List<Apod>>() {
                @Override
                public void onResponse(Call<List<Apod>> call, Response<List<Apod>> response) {
                    if (response.isSuccessful()){
                        List<Apod> apod_recuperados = response.body();
                        apod_list.addAll(apod_recuperados);

                        Intent intent = new Intent(getApplicationContext(), ApodListActivity.class);
                        intent.putParcelableArrayListExtra("apod_list", new ArrayList<>(apod_list)); // Esse extra é utilizado para passar dados mais complexos, como uma lista de objetos por exemplo
                        startActivity(intent);

                    }
                }

                @Override
                public void onFailure(Call<List<Apod>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(this, "Por favor, insira uma quantidade válida!", Toast.LENGTH_SHORT).show();
        }

    }

    public void countLayoutFinish(View view){
        finish();
    }
}