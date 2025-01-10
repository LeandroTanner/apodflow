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

public class DateActivity extends AppCompatActivity {

    private ToolKit tk = new ToolKit();
    private  String api_key = tk.getApiKey();

    private RetrofitClientApod cl = new RetrofitClientApod();

    private Retrofit retrofit;

    private ApodService apodService;

    private List<Apod> apod_list;

    private EditText inputDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        apod_list = new ArrayList<>();

        retrofit = cl.getClient();

        apodService = retrofit.create(ApodService.class);

        inputDate = findViewById(R.id.date_layout_inputDate);

    }

    public  void date_createApodList(View view){
        String date = inputDate.getText().toString().trim();

        if (!date.isEmpty()){
            date = tk.formatDate(date);

            if (date != null){

                Call<Apod> call = apodService.dateSearch(api_key, date);

                call.enqueue(new Callback<Apod>() {
                    @Override
                    public void onResponse(Call<Apod> call, Response<Apod> response) {
                        Apod apodRecuperado = response.body();
                        apod_list.add(apodRecuperado);

                        Intent intent = new Intent(getApplicationContext(), ApodListActivity.class);
                        intent.putParcelableArrayListExtra("apod_list", new ArrayList<>(apod_list)); // Esse extra é utilizado para passar dados mais complexos, como uma lista de objetos por exemplo
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Apod> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                Toast.makeText(this, "Ocorreu um erro! Insira a data no formato DDMMAAAA.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Por favor, insira a data.", Toast.LENGTH_SHORT).show();
        }
    }

    public void dateLayoutFinish(View view){
        finish();
    }
}