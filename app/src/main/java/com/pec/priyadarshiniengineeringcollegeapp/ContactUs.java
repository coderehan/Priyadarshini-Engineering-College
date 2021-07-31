package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContactUs extends AppCompatActivity {
ActionBar actionBar;
ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Contact PEC");

        imageView=findViewById(R.id.imageView1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pec_map();
            }
        });
    }

    private void pec_map() {
        Uri uri=Uri.parse("geo:0, 0?q=Priyadarshini Engineering College, Vaniyambadi");

        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
