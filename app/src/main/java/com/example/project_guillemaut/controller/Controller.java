package com.example.project_guillemaut.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.Serializable;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project_guillemaut.view.SplashActivity;
import com.example.project_guillemaut.model.ApiCatResponse;
import com.example.project_guillemaut.model.Cat;
import com.example.project_guillemaut.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class Controller  {

    private static final String BASE_URL = "https://clementguillemaut.github.io/";
    private SplashActivity mActivity;
    private ApiCatResponse catList;

    public void start(SplashActivity myActivity) {
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
                    catList = response.body();
                    storeDatasetInCache();
                    Intent intent = new Intent(mActivity, MainActivity.class);
                    intent.putExtra("Dataset", (Serializable) catList.getResults());
                    mActivity.startActivity(intent);
                    Animatoo.animateInAndOut(mActivity);
                    Log.i("onResponse", "Response is successful and dataset loaded");
                } else {
                    Log.i("onResponse", "Response is not successful :"+response.errorBody());
                    Log.i("Response", "Response status : "+response.message());

                }
            }



            private void storeDatasetInCache(){
                SharedPreferences cache = mActivity.getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = cache.edit();
                int i=1;

                for (Cat cat : catList.getResults()){

                    editor.putString("Cat_"+i+"_name=", cat.getCatName());
                    editor.putString("Cat_"+i+"_age=", cat.getCatAge());
                    editor.putString("Cat_"+i+"_coat=", cat.getCatCoat());
                    editor.putString("Cat_"+i+"_color=", cat.getCatColor());
                    editor.putString("Cat_"+i+"_height=", cat.getCatHeight());
                    editor.putString("Cat_"+i+"_mood=", cat.getCatMood());
                    editor.putString("Cat_"+i+"_num=", cat.getCatNum());
                    editor.putString("Cat_"+i+"_pic=", cat.getCatPic());
                    i++;
                }
                editor.apply();

            }

            @Override
            public void onFailure(Call<ApiCatResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
        Log.i("start", "call passed");

    }

}

