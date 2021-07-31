package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TimeTableEdit extends AppCompatActivity {
    ActionBar actionBar;
    EditText d11,d12,d13,d14,d15,d16,d17,d18,d21,d22,d23,d24,d25,d26,d27,d28,d31,d32,d33,d34,d35,d36,d37,d38,d41,d42,d43,d44,d45,d46,d47,d48,d51,d52,d53,d54,d55,d56,d57,d58,d61,d62,d63,d64,d65,d66,d67,d68;
    Button button;
    DatabaseHelperAdd add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_edit);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Edit Time Table");

        add=new DatabaseHelperAdd(this);

        d11=findViewById(R.id.d11);
        d12=findViewById(R.id.d12);
        d13=findViewById(R.id.d13);
        d14=findViewById(R.id.d14);
        d15=findViewById(R.id.d15);
        d16=findViewById(R.id.d16);
        d17=findViewById(R.id.d17);
        d18=findViewById(R.id.d18);

        d21=findViewById(R.id.d21);
        d22=findViewById(R.id.d22);
        d23=findViewById(R.id.d23);
        d24=findViewById(R.id.d24);
        d25=findViewById(R.id.d25);
        d26=findViewById(R.id.d26);
        d27=findViewById(R.id.d27);
        d28=findViewById(R.id.d28);

        d31=findViewById(R.id.d31);
        d32=findViewById(R.id.d32);
        d33=findViewById(R.id.d33);
        d34=findViewById(R.id.d34);
        d35=findViewById(R.id.d35);
        d36=findViewById(R.id.d36);
        d37=findViewById(R.id.d37);
        d38=findViewById(R.id.d38);

        d41=findViewById(R.id.d41);
        d42=findViewById(R.id.d42);
        d43=findViewById(R.id.d43);
        d44=findViewById(R.id.d44);
        d45=findViewById(R.id.d45);
        d46=findViewById(R.id.d46);
        d47=findViewById(R.id.d47);
        d48=findViewById(R.id.d48);

        d51=findViewById(R.id.d51);
        d52=findViewById(R.id.d52);
        d53=findViewById(R.id.d53);
        d54=findViewById(R.id.d54);
        d55=findViewById(R.id.d55);
        d56=findViewById(R.id.d56);
        d57=findViewById(R.id.d57);
        d58=findViewById(R.id.d58);

        d61=findViewById(R.id.d61);
        d62=findViewById(R.id.d62);
        d63=findViewById(R.id.d63);
        d64=findViewById(R.id.d64);
        d65=findViewById(R.id.d65);
        d66=findViewById(R.id.d66);
        d67=findViewById(R.id.d67);
        d68=findViewById(R.id.d68);

        button=findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {
        String do11=d11.getText().toString();
        String do12=d12.getText().toString();
        String do13=d13.getText().toString();
        String do14=d14.getText().toString();
        String do15=d15.getText().toString();
        String do16=d16.getText().toString();
        String do17=d17.getText().toString();
        String do18=d18.getText().toString();

        String do21=d21.getText().toString();
        String do22=d22.getText().toString();
        String do23=d23.getText().toString();
        String do24=d24.getText().toString();
        String do25=d25.getText().toString();
        String do26=d26.getText().toString();
        String do27=d27.getText().toString();
        String do28=d28.getText().toString();

        String do31=d31.getText().toString();
        String do32=d32.getText().toString();
        String do33=d33.getText().toString();
        String do34=d34.getText().toString();
        String do35=d35.getText().toString();
        String do36=d36.getText().toString();
        String do37=d37.getText().toString();
        String do38=d38.getText().toString();

        String do41=d41.getText().toString();
        String do42=d42.getText().toString();
        String do43=d43.getText().toString();
        String do44=d44.getText().toString();
        String do45=d45.getText().toString();
        String do46=d46.getText().toString();
        String do47=d47.getText().toString();
        String do48=d48.getText().toString();

        String do51=d51.getText().toString();
        String do52=d52.getText().toString();
        String do53=d53.getText().toString();
        String do54=d54.getText().toString();
        String do55=d55.getText().toString();
        String do56=d56.getText().toString();
        String do57=d57.getText().toString();
        String do58=d58.getText().toString();

        String do61=d61.getText().toString();
        String do62=d62.getText().toString();
        String do63=d63.getText().toString();
        String do64=d64.getText().toString();
        String do65=d65.getText().toString();
        String do66=d66.getText().toString();
        String do67=d67.getText().toString();
        String do68=d68.getText().toString();

        boolean result=add.insertData(do11,do12,do13,do14,do15,do16,do17,do18,
                do21,do22,do23,do24,do25,do26,do27,do28,
                do31,do32,do33,do34,do35,do36,do37,do38,
                do41,do42,do43,do44,do45,do46,do47,do48,
                do51,do52,do53,do54,do55,do56,do57,do58,
                do61,do62,do63,do64,do65,do66,do67,do68);
        if(result==true)
        {
            Toast.makeText(this, "Time Table Edited Successfully", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(TimeTableEdit.this, TimeTable.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Time Table Edited Failed", Toast.LENGTH_LONG).show();
        }
    }
}

