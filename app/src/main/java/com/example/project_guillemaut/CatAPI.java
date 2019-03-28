package com.example.project_guillemaut;

import com.example.project_guillemaut.model.ApiCatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatAPI {

    @GET("cat.json")
    Call<ApiCatResponse> loadChanges();
}