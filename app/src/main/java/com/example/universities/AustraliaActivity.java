package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class AustraliaActivity extends AppCompatActivity {

    private RecyclerView australiaRecView;
    private uniAdaptor uniAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia);

        australiaRecView=findViewById(R.id.australiaRecyclerView);
        uniAdaptor = new uniAdaptor(AustraliaActivity.this, "australiaShowAll");

        uniAdaptor.setUniArray(utils.getInstance().getAustralia());

        australiaRecView.setAdapter(uniAdaptor);
        australiaRecView.setLayoutManager(new LinearLayoutManager(AustraliaActivity.this));


    }
}