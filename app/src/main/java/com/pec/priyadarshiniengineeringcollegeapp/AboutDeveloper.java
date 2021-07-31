package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutDeveloper extends AppCompatActivity {
ActionBar actionBar;
ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);

        actionBar=getSupportActionBar();
        actionBar.setTitle("About Developer");

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram("https://www.instagram.com/mohammedrehan6532");
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebook("https://www.facebook.com/mohammed.m.319");
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedin("https://www.linkedin.com/in/mohammed-rehan-74359816a");
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmail();
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                google_play("https://play.google.com/store/apps/dev?id=8077454561024306335");
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                your_quote("https://www.yourquote.in/mohammed-rehan-voir/quotes");
            }
        });
    }

    private void instagram(String s) {
        Uri uri=Uri.parse(s);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void facebook(String s) {
        Uri uri=Uri.parse(s);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void linkedin(String s) {
        Uri uri=Uri.parse(s);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void your_quote(String s) {
        Uri uri=Uri.parse(s);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void google_play(String s) {
        Uri uri=Uri.parse(s);
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void gmail() {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("email"));
        intent.setType("message/rfc822");
        String[] emailID={"mohammedrehan6532@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, emailID);
        intent.putExtra(Intent.EXTRA_SUBJECT, "PEC APP");
        intent.putExtra(Intent.EXTRA_TEXT, "Please write your feedback to developer here...");
        startActivity(Intent.createChooser(intent, "Share App With"));
    }

}
