package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView favoriteRecView;
    private uniAdaptor uniAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        favoriteRecView=findViewById(R.id.favoriteRecView);
        uniAdaptor = new uniAdaptor(FavoriteActivity.this, "favorites");

        uniAdaptor.setUniArray(utils.getInstance().getFavorites());

        favoriteRecView.setAdapter(uniAdaptor);
        favoriteRecView.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));
    }
}