package com.example.project_guillemaut.view;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.project_guillemaut.controller.ClickListener;
import com.example.project_guillemaut.R;
import com.example.project_guillemaut.controller.Controller;
import com.example.project_guillemaut.model.Cat;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Cat> myDataset;
    private ClickListener listener;

    private static final Cat CAT_TO_SHOW = new Cat(null, null, null, null, null, null, null, null);


    public ArrayList<Cat> getMyDataset(){
        return this.myDataset;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //ActivityModifier.updateActivity(this);
        setContentView(R.layout.activity_main);

        myDataset = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(this, myDataset, listener);

        Controller controller = new Controller();
        showCache();
        controller.start(this, mAdapter);

        mRecyclerView.setAdapter(mAdapter);
    }

    public void showList(ArrayList<Cat> dataset) {

        Log.i("showList", "Is in showList");
        int i=0;
        for (Cat cat: dataset)
              {
            Log.i("Cat", cat.getCatName());
            i++;
        }
        Log.i("Cat", ""+i);
        // define an adapter
        mAdapter = new MyAdapter(this, dataset, listener );
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
}


