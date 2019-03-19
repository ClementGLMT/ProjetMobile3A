package com.example.project_guillemaut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        Controller controller = new Controller();
        controller.start(this);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(this, myDataset, listener);
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

   /* public void toSecondActivity(View view) {
        // Create an Intent to start the second activity
        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("MyClass", obj);;
        startActivity(randomIntent);



    }*/



    public void setMyDataset(ArrayList<Cat> myDataset){
        this.myDataset = myDataset;
    }
}


