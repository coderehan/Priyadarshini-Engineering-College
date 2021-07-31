package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminDashboard extends AppCompatActivity {
    ActionBar actionBar;
    CardView cardView1, cardView2, cardView3, cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Admin Dashboard");

        cardView1=findViewById(R.id.cardView1);
        cardView2=findViewById(R.id.cardView2);
        cardView3=findViewById(R.id.cardView3);
        cardView4=findViewById(R.id.cardView4);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(AdminDashboard.this, ManageCorrespondent.class);
                startActivity(intent1);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(AdminDashboard.this, ManagePrincipal.class);
                startActivity(intent2);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(AdminDashboard.this, AddFaculty.class);
                startActivity(intent3);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(AdminDashboard.this, ManageFaculty.class);
                startActivity(intent4);
            }
        });
    }
}
