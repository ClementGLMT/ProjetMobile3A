package com.example.project_guillemaut.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project_guillemaut.CatAdapter;
import com.example.project_guillemaut.controller.ClickListener;
import com.example.project_guillemaut.R;
import com.example.project_guillemaut.controller.Controller;
import com.example.project_guillemaut.model.Cat;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ClickListener{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Cat> myDataset;
    private Controller controller;



    public ArrayList<Cat> getMyDataset(){
        return this.myDataset;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDataset = new ArrayList<>();
        controller = new Controller();
        showCache();
        controller.start(this, mAdapter);
    }

    public void showList(ArrayList<Cat> dataset) {

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CatAdapter(this, dataset, this );
        mRecyclerView.setAdapter(mAdapter);
    }


    public void showCache(){
        int i;
        SharedPreferences cache = getPreferences(MODE_PRIVATE);
        Map kache = cache.getAll();
        Log.d("Cache", "cache size = "+kache.size());
        if(kache.isEmpty()){
            Log.d("Cache", "Cache empty");
        }
        else {
            for(i=1; i<=kache.size()/8; i++){
                Log.d("Cache", (String) kache.get("Cat_"+i+"_name="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_age="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_coat="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_color="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_height="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_mood="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_num="));
                Log.d("Cache", (String) kache.get("Cat_"+i+"_pic="));

            }
        }
    }

    public void setMyDataset(ArrayList<Cat> myDataset){
        this.myDataset = myDataset;
    }

    @Override
    public void onItemClick(Cat item) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Cat", item);
        startActivity(intent);
        Animatoo.animateInAndOut(this);
    }
}


