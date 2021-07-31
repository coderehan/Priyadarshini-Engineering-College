package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimeTable extends AppCompatActivity {
    ActionBar actionBar;
    TextView textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView41, textView42, textView43, textView44, textView45, textView46, textView47, textView48, textView51, textView52, textView53, textView54, textView55, textView56, textView57, textView58, textView61, textView62, textView63, textView64, textView65, textView66, textView67, textView68;
    Button button;
    DatabaseHelperRead read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Time Table");

        textView11=findViewById(R.id.d11);
        textView12=findViewById(R.id.d12);
        textView13=findViewById(R.id.d13);
        textView14=findViewById(R.id.d14);
        textView15=findViewById(R.id.d15);
        textView16=findViewById(R.id.d16);
        textView17=findViewById(R.id.d17);
        textView18=findViewById(R.id.d18);

        textView21=findViewById(R.id.d21);
        textView22=findViewById(R.id.d22);
        textView23=findViewById(R.id.d23);
        textView24=findViewById(R.id.d24);
        textView25=findViewById(R.id.d25);
        textView26=findViewById(R.id.d26);
        textView27=findViewById(R.id.d27);
        textView28=findViewById(R.id.d28);

        textView31=findViewById(R.id.d31);
        textView32=findViewById(R.id.d32);
        textView33=findViewById(R.id.d33);
        textView34=findViewById(R.id.d34);
        textView35=findViewById(R.id.d35);
        textView36=findViewById(R.id.d36);
        textView37=findViewById(R.id.d37);
        textView38=findViewById(R.id.d38);

        textView41=findViewById(R.id.d41);
        textView42=findViewById(R.id.d42);
        textView43=findViewById(R.id.d43);
        textView44=findViewById(R.id.d44);
        textView45=findViewById(R.id.d45);
        textView46=findViewById(R.id.d46);
        textView47=findViewById(R.id.d47);
        textView48=findViewById(R.id.d48);

        textView51=findViewById(R.id.d51);
        textView52=findViewById(R.id.d52);
        textView53=findViewById(R.id.d53);
        textView54=findViewById(R.id.d54);
        textView55=findViewById(R.id.d55);
        textView56=findViewById(R.id.d56);
        textView57=findViewById(R.id.d57);
        textView58=findViewById(R.id.d58);

        textView61=findViewById(R.id.d61);
        textView62=findViewById(R.id.d62);
        textView63=findViewById(R.id.d63);
        textView64=findViewById(R.id.d64);
        textView65=findViewById(R.id.d65);
        textView66=findViewById(R.id.d66);
        textView67=findViewById(R.id.d67);
        textView68=findViewById(R.id.d68);

        button=findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this, TimeTableEdit.class);
                startActivity(intent);
            }
        });

        read=new DatabaseHelperRead(this);

        Cursor result=read.displayData();

        while (result.moveToNext())
        {
            textView11.setText(result.getString(0));
            textView12.setText(result.getString(1));
            textView13.setText(result.getString(2));
            textView14.setText(result.getString(3));
            textView15.setText(result.getString(4));
            textView16.setText(result.getString(5));
            textView17.setText(result.getString(6));
            textView18.setText(result.getString(7));

            textView21.setText(result.getString(8));
            textView22.setText(result.getString(9));
            textView23.setText(result.getString(10));
            textView24.setText(result.getString(11));
            textView25.setText(result.getString(12));
            textView26.setText(result.getString(13));
            textView27.setText(result.getString(14));
            textView28.setText(result.getString(15));

            textView31.setText(result.getString(16));
            textView32.setText(result.getString(17));
            textView33.setText(result.getString(18));
            textView34.setText(result.getString(19));
            textView35.setText(result.getString(20));
            textView36.setText(result.getString(21));
            textView37.setText(result.getString(22));
            textView38.setText(result.getString(23));

            textView41.setText(result.getString(24));
            textView42.setText(result.getString(25));
            textView43.setText(result.getString(26));
            textView44.setText(result.getString(27));
            textView45.setText(result.getString(28));
            textView46.setText(result.getString(29));
            textView47.setText(result.getString(30));
            textView48.setText(result.getString(31));

            textView51.setText(result.getString(32));
            textView52.setText(result.getString(33));
            textView53.setText(result.getString(34));
            textView54.setText(result.getString(35));
            textView55.setText(result.getString(36));
            textView56.setText(result.getString(37));
            textView57.setText(result.getString(38));
            textView58.setText(result.getString(39));

            textView61.setText(result.getString(40));
            textView62.setText(result.getString(41));
            textView63.setText(result.getString(42));
            textView64.setText(result.getString(43));
            textView65.setText(result.getString(44));
            textView66.setText(result.getString(45));
            textView67.setText(result.getString(46));
            textView68.setText(result.getString(47));

        }
    }
}


