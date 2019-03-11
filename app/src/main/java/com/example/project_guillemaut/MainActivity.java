package com.example.project_guillemaut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Cat> myDataset;


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

    }

    public void showList(List<Cat> listBook, ArrayList<Cat> dataset) {
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // define an adapter
        mAdapter = new MyAdapter(this, dataset);
        mRecyclerView.setAdapter(mAdapter);
    }



    public void setMyDataset(ArrayList<Cat> myDataset){
        this.myDataset = myDataset;
    }
}


