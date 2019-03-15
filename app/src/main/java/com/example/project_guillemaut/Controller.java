package com.example.project_guillemaut;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

public class Controller  {

    static final String BASE_URL = "https://clementguillemaut.github.io/";
    static MainActivity mActivity;

    public void start(MainActivity myActivity) {
        mActivity = myActivity;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CatAPI catAPI = retrofit.create(CatAPI.class);

        Call<ApiCatResponse> call = catAPI.loadChanges();

        call.enqueue(new Callback<ApiCatResponse>() {
            @Override
            public void onResponse(Call<ApiCatResponse> call, Response<ApiCatResponse> response) {
                Log.i("onResponse", "Is in onResponse");
                Log.i("Response", "Response status : "+response.code());

                if(response.isSuccessful()) {
                    Log.i("Response", "Response status : "+response.message());
                    ApiCatResponse changesList = response.body();
                    mActivity.setMyDataset((ArrayList<Cat>) changesList.getResults());
                    Log.i("onResponse", "Response is successful and dataset loaded");
                    mActivity.showList((ArrayList<Cat>) changesList.getResults());

                } else {
                    Log.i("onResponse", "Response is not successful :"+response.errorBody());
                    Log.i("Response", "Response status : "+response.message());

                }
            }

            @Override
            public void onFailure(Call<ApiCatResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Log.i("start", "call passed");

    }

}

