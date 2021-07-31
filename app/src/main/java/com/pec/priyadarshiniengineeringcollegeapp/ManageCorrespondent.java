package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ManageCorrespondent extends AppCompatActivity {
    ActionBar actionBar;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    List<ModalCorrespondent> list;
    AdapterCorrespondent adapterCorrespondent;
    ProgressDialog progressDialog;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_correspondent);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Manage Correspondent");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_correspondent");

        fab=findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageCorrespondent.this, AddCorrespondent.class);
                startActivity(intent);
            }
        });

        recyclerView=findViewById(R.id.recyclerView);

        //getData
        displayData();

    }

    private void displayData() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list=new ArrayList<>();

                if(dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalCorrespondent modalCorrespondent=snapshot.getValue(ModalCorrespondent.class);
                        list.add(modalCorrespondent);
                    }

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ManageCorrespondent.this));
                    adapterCorrespondent=new AdapterCorrespondent(ManageCorrespondent.this, list);
                    recyclerView.setAdapter(adapterCorrespondent);
                    progressDialog.dismiss();
                }

                else
                {
                    Toast.makeText(ManageCorrespondent.this, "No data available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
