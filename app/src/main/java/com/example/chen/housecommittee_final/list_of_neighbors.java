package com.example.chen.housecommittee_final;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class list_of_neighbors extends AppCompatActivity {

    ListView neighborsView;
    String[] neighborsName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_neighbors);

        Resources res = getResources();
        neighborsView = (ListView)findViewById(R.id.neighborsListView);
        neighborsName = res.getStringArray(R.array.neighbors);

        neighborsView.setAdapter(new ArrayAdapter<String>(this,R.layout.neighbors_detail, neighborsName));

    }
}
