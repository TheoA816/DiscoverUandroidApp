package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SingaporeActivity extends AppCompatActivity {

    private RecyclerView singaporeRecView;
    private uniAdaptor uniAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singapore);

        singaporeRecView=findViewById(R.id.singaporeRecyclerView);
        uniAdaptor = new uniAdaptor(SingaporeActivity.this, "singaporeShowAll");

        uniAdaptor.setUniArray(utils.getInstance().getSingapore());

        singaporeRecView.setAdapter(uniAdaptor);
        singaporeRecView.setLayoutManager(new LinearLayoutManager(SingaporeActivity.this));
    }
}