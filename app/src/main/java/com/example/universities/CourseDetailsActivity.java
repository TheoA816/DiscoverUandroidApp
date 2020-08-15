package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CourseDetailsActivity extends AppCompatActivity {

    private TextView courseName, courseDuration, courseRequirements, ujianNasional, other, fee, facultyWebsite, admissionDeadline;
    private ImageView schoolLogo;
    private Button addToCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        courseDuration=findViewById(R.id.courseDuration);
        courseName=findViewById(R.id.courseName);
        courseRequirements=findViewById(R.id.courseRequirements);
        ujianNasional=findViewById(R.id.ujianNasionalEntry);
        other=findViewById(R.id.otherEntry);
        fee=findViewById(R.id.fee);
        facultyWebsite=findViewById(R.id.facultyWebsite);
        courseRequirements.setText("Course Requirements");
        schoolLogo=findViewById(R.id.schoolLogo);
        admissionDeadline=findViewById(R.id.admissionDeadline);
        addToCalendar=findViewById(R.id.addToCalendar);

        addToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseDetailsActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        final String uni = getIntent().getStringExtra("initial");
        final Integer position = getIntent().getIntExtra("position",-1);
        if(uni.equals("NTU")){
            final uniCourse uniCourse = utils.getInstance().getNTU(position);
            setData(uniCourse);
            facultyWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CourseDetailsActivity.this, WebViewActivity.class);
                    intent.putExtra("url", uniCourse.getFacultyWebsite());
                    startActivity(intent);
                }
            } );
        }else if(uni.equals("NUS")){
            final uniCourse uniCourse = utils.getInstance().getNUS(position);
            setData(uniCourse);
            facultyWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CourseDetailsActivity.this, WebViewActivity.class);
                    intent.putExtra("url", uniCourse.getFacultyWebsite());
                    startActivity(intent);
                }
            } );
        }else if(uni.equals("melU")){
            final uniCourse uniCourse = utils.getInstance().getmelU(position);
            setData(uniCourse);
            facultyWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CourseDetailsActivity.this, WebViewActivity.class);
                    intent.putExtra("url", uniCourse.getFacultyWebsite());
                    startActivity(intent);
                }
            });
        }else if(uni.equals("UNSW")){
            final uniCourse uniCourse = utils.getInstance().getUNSW(position);
            setData(uniCourse);
            facultyWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CourseDetailsActivity.this, WebViewActivity.class);
                    intent.putExtra("url", uniCourse.getFacultyWebsite());
                    startActivity(intent);
                }
            });
        }
    }

    private void setData(uniCourse uniCourse){
        courseName.setText(uniCourse.getCourseName());
        courseDuration.setText(uniCourse.getCourseDuration());
        facultyWebsite.setText("Click to go to Website");
        fee.setText(uniCourse.getFee() + "per annum");
        ujianNasional.setText(uniCourse.getUNentry());
        other.setText(uniCourse.getOtherEntry());
        admissionDeadline.setText("Admission Deadline:\n" +
                uniCourse.getAdmissionDeadline());

        Glide.with(CourseDetailsActivity.this)
                .asBitmap()
                .load(uniCourse.getUrl())
                .into(schoolLogo);
    }


}