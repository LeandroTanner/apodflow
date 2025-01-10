package com.example.apodflow.controller.service;

import com.example.apodflow.model.apod.Apod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApodService {

    @GET("apod")
    Call<Apod> dateSearch(@Query("api_key") String apiKey, @Query("date") String date);

    @GET("apod")
    Call<List<Apod>> start_end_dateSearch(@Query("api_key") String apiKey, @Query("start_date") String start_date, @Query("end_date") String end_date);

    @GET("apod")
    Call<List<Apod>> countSearch(@Query("api_key") String apiKey, @Query("count") int count);


}
