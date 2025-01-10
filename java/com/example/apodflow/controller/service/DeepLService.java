package com.example.apodflow.controller.service;

import com.example.apodflow.model.deepl.DeepLResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DeepLService {

    @FormUrlEncoded
    @POST("v2/translate")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<DeepLResponse> translate(
            @Field("auth_key") String apiKey,
            @Field("text") String text,
            @Field("target_lang") String targetLang,
            @Field("source_lang") String sourceLang
    );

}
