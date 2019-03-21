package com.example.project_guillemaut.controller;

import com.example.project_guillemaut.model.ApiCatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatAPI {

    @GET("cat.json")
    Call<ApiCatResponse> loadChanges();
}