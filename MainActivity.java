package com.solvedge.androidsampleexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvSampleView;
    private ArrayList<SampleModel> sampleList;
    private SampleListAdapter sampleListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvSampleView = (RecyclerView) findViewById(R.id.rvSampleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSampleView.setLayoutManager(linearLayoutManager);
        sampleList = new ArrayList<>();

        if(savedInstanceState == null || !savedInstanceState.containsKey("Store")) {
            for (int i = 1; i <= 500; i++) {
                SampleModel model = new SampleModel("Sample"+i,"False");
                sampleList.add(model);
            }


        }else{
            sampleList = savedInstanceState.getParcelableArrayList("Store");
        }

        sampleListAdapter = new SampleListAdapter(this, sampleList);
        rvSampleView.setAdapter(sampleListAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("Store", new ArrayList<>(sampleListAdapter.getSampleModelList()));
        super.onSaveInstanceState(outState);
    }
}
