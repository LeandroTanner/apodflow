package com.example.apodflow.model.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApod {

    public RetrofitClientApod(){}

    private static final String BASE_URL = "https://api.nasa.gov/planetary/";

    private  static Retrofit retrofit = null;

    public Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }
}
