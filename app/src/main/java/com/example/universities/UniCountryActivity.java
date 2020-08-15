package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UniCountryActivity extends AppCompatActivity {

    private Button australia, singapore;
    private TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_country);

        australia=findViewById(R.id.btnAustralia);
        singapore=findViewById(R.id.btnSingapore);

        australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniCountryActivity.this, AustraliaActivity.class);
                startActivity(intent);
            }
        });

        singapore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniCountryActivity.this, SingaporeActivity.class);
                startActivity(intent);
            }
        });
    }
}
