package com.example.project_guillemaut;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatAPI {

    @GET("changes/")
    Call<List<Cat>> loadChanges(@Query("q") String status);
}