package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.card.MaterialCardView;

public class HomePageActivity extends AppCompatActivity {

    private MaterialCardView myAcc, universities, calendar, favourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        myAcc=findViewById(R.id.myaccount);
        universities=findViewById(R.id.universities);
        calendar=findViewById(R.id.calendar);
        favourites=findViewById(R.id.favourites);

        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this,FavoriteActivity.class);
                startActivity(intent);
            }
        });
        universities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, UniCountryActivity.class);
                startActivity(intent);
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
        myAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this,MyAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}