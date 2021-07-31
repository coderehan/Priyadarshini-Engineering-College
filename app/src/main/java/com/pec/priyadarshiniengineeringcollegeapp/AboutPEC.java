package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class AboutPEC extends AppCompatActivity {
ActionBar actionBar;
ImageView imageView1, imageView2;
TextView textView1, textView2, textView3, textView4;
ProgressDialog progressDialog;
DatabaseReference databaseReference1, databaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_p_e_c);

        actionBar=getSupportActionBar();
        actionBar.setTitle("About PEC");

        progressDialog=new ProgressDialog(this);

        databaseReference1= FirebaseDatabase.getInstance().getReference("add_correspondent");
        databaseReference2= FirebaseDatabase.getInstance().getReference("add_principal");

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        textView1=findViewById(R.id.textView5);
        textView2=findViewById(R.id.textView6);
        textView3=findViewById(R.id.textView8);
        textView4=findViewById(R.id.textView9);

        progressDialog.setMessage("Please wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalCorrespondent modalCorrespondent=snapshot.getValue(ModalCorrespondent.class);
                        Picasso.get().load(modalCorrespondent.getImage()).into(imageView1);
                        textView1.setText(modalCorrespondent.getName());
                        textView2.setText(modalCorrespondent.getMessage());
                    }
                    progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    ModalPrincipal modalPrincipal=snapshot.getValue(ModalPrincipal.class);
                    Picasso.get().load(modalPrincipal.getImage()).into(imageView2);
                    textView3.setText(modalPrincipal.getName());
                    textView4.setText(modalPrincipal.getMessage());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
