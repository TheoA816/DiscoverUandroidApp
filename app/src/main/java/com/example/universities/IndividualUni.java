package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class IndividualUni extends AppCompatActivity {

    private TextView schoolName, faculty1, faculty2;
    private Button addToFav;
    private ImageView schoolPhoto, down1, down2, up1, up2;
    private RelativeLayout facultySet1, facultySet2, courseDrop1, courseDrop2;
    private ListView courseChoice, courseChoices2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_uni);

        initViews();

        String[] array = getResources().getStringArray(R.array.FacultyOfScience);

        ArrayAdapter<String> uniadapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                array
        );

        String[] array2 = getResources().getStringArray(R.array.BusinessSchool);

        ArrayAdapter<String> uniadapter2 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                array2
        );

        courseChoice.setAdapter(uniadapter);
        courseChoices2.setAdapter(uniadapter2);

        Intent incomingIntent = getIntent();
        String country = getIntent().getStringExtra("country");
        Integer rank = getIntent().getIntExtra("rank", -1);
        final String initial = getIntent().getStringExtra("initial");

        courseChoice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(IndividualUni.this, CourseDetailsActivity.class);
                intent.putExtra("initial",initial);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });

        courseChoices2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(IndividualUni.this, CourseDetailsActivity.class);
                intent.putExtra("initial",initial);
                intent.putExtra("position",i+3);
                startActivity(intent);
            }
        });

        if(country.equals("Singapore")){
            university newUni = utils.getInstance().getUniSingapore(rank);
            setData(newUni);
            handleFavorites(newUni);
        }else{
            university newUni = utils.getInstance().getUniAussie(rank);
            setData(newUni);
            handleFavorites(newUni);
        }

        down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseDrop1.setVisibility(View.VISIBLE);
                down1.setVisibility(View.GONE);
            }
        });
        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseDrop2.setVisibility(View.VISIBLE);
                down2.setVisibility(View.GONE);
            }
        });
        up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                down1.setVisibility(View.VISIBLE);
                courseDrop1.setVisibility(View.GONE);
            }
        });
        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                down2.setVisibility(View.VISIBLE);
                courseDrop2.setVisibility(View.GONE);
            }
        });
    }

    private void handleFavorites(final university newUni) {
        ArrayList<university> favorite = utils.getInstance().getFavorites();
        boolean existInFav = false;

        for(university u: favorite){
            if(u.getQSworldRank()==newUni.getQSworldRank()){
                existInFav=true;
            }
        }
        if(existInFav){
            addToFav.setEnabled(false);
        }else{
            addToFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(utils.getInstance().addToFavorites(newUni)){
                        Toast.makeText(IndividualUni.this, newUni.getUniName()+" added to favorites", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(IndividualUni.this, FavoriteActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    private void setData(university newUni) {

        Glide.with(IndividualUni.this)
                .asBitmap()
                .load(newUni.getUniPhoto())
                .into(schoolPhoto);

        schoolName.setText(newUni.getUniName());
    }

    private void initViews(){
        courseChoices2=findViewById(R.id.courseChoices2);
        courseChoice=findViewById(R.id.courseChoices);
        addToFav=findViewById(R.id.addToFavorite);
        schoolPhoto=findViewById(R.id.SchoolPhoto);
        schoolName=findViewById(R.id.SchoolName);
        faculty1=findViewById(R.id.Faculty1);
        faculty2=findViewById(R.id.Faculty2);
        down1=findViewById(R.id.down1);
        down2=findViewById(R.id.down2);
        up1=findViewById(R.id.up1);
        up2=findViewById(R.id.up2);
        facultySet1=findViewById(R.id.facultyset1);
        facultySet2=findViewById(R.id.facultyset2);
        courseDrop1=findViewById(R.id.courseDropDown1);
        courseDrop2=findViewById(R.id.courseDropDown2);

    }
}