package com.example.project_guillemaut;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class Controller implements Callback<List<Cat>> {

    static final String BASE_URL = "https://catAPI/";
    static MainActivity mActivity;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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

        Call<List<Cat>> call = catAPI.loadChanges("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
        if(response.isSuccessful()) {
            List<Cat> changesList = response.body();
            mActivity.setMyDataset((ArrayList<Cat>) changesList);
        } else {
            System.out.println(response.errorBody());
        }
        mActivity.showList();
    }

    @Override
    public void onFailure(Call<List<Cat>> call, Throwable t) {
        t.printStackTrace();
    }


}

