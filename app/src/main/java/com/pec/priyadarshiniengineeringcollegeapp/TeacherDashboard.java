package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherDashboard extends AppCompatActivity {
ActionBar actionBar;
CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Faculty Dashboard");

        cardView1=findViewById(R.id.cardView1);
        cardView2=findViewById(R.id.cardView2);
        cardView3=findViewById(R.id.cardView3);
        cardView4=findViewById(R.id.cardView4);
        cardView5=findViewById(R.id.cardView5);
        cardView6=findViewById(R.id.cardView6);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherDashboard.this, AddNotice.class);
                startActivity(intent1);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(TeacherDashboard.this, DeleteNotice.class);
                startActivity(intent2);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(TeacherDashboard.this, AddNotes.class);
                startActivity(intent3);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(TeacherDashboard.this, DeleteNotes.class);
                startActivity(intent4);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(TeacherDashboard.this, AddGallery.class);
                startActivity(intent5);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(TeacherDashboard.this, ManageGallery.class);
                startActivity(intent6);
            }
        });

    }
}
