package com.example.apodflow.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Start_End_DateActivity extends AppCompatActivity {

    private ToolKit tk = new ToolKit();
    private  String api_key = tk.getApiKey();

    private RetrofitClientApod cl = new RetrofitClientApod();

    private Retrofit retrofit;

    private ApodService apodService;

    private List<Apod> apod_list;

    private EditText inputStartDate, inputEndDate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_end_date);

        apod_list = new ArrayList<>();

        retrofit = cl.getClient();

        apodService = retrofit.create(ApodService.class);

        inputStartDate = findViewById(R.id.start_end_date_inputStartDate);
        inputEndDate = findViewById(R.id.start_end_date_inputEndDate);

    }

    public void start_end_date_createApodList(View view){

        Log.d("Start_End_DateActivity", "Botão clicado!");


        String startDate = inputStartDate.getText().toString().trim();
        String endDate = inputEndDate.getText().toString().trim();

        if (!startDate.isEmpty() && !endDate.isEmpty()){
            startDate = tk.formatDate(startDate);
            endDate = tk.formatDate(endDate);

            if (startDate != null && endDate != null){

                Log.d("Retrofit", "startDate: " + startDate + ", endDate: " + endDate);

                Call<List<Apod>> call = apodService.start_end_dateSearch(api_key, startDate, endDate);

                call.enqueue(new Callback<List<Apod>>() {
                    @Override
                    public void onResponse(Call<List<Apod>> call, Response<List<Apod>> response) {
                        if (response.isSuccessful()){

                            Log.d("Retrofit", "DEU CERTOOOOOOOOOOOOOOOOOOOOO");

                            List<Apod> apod_recuperados = response.body();
                            apod_list.addAll(apod_recuperados);

                            Intent intent = new Intent(Start_End_DateActivity.this, ApodListActivity.class);
                            intent.putParcelableArrayListExtra("apod_list", new ArrayList<>(apod_list));
                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Apod>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                Toast.makeText(this, "Ocorreu um erro! Insira as datas no formato DDMMAAAA.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Por favor, preencha os campos!", Toast.LENGTH_SHORT).show();
        }

    }

    public void start_end_dateLayoutFinish(View view){
        finish();
    }
}