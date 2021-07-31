package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed extends AppCompatActivity {
    ActionBar actionBar;
    RecyclerView recyclerView;
    List<ModalNotice> list;
    AdapterNoticeStudentSide adapterNoticeStudentSide;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Newsfeed");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_notice");

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
                        ModalNotice modalNotice=snapshot.getValue(ModalNotice.class);
                        list.add(0, modalNotice);   //showing latest notice at top of the page i.e. index at 0
                    }

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(NewsFeed.this));
                    adapterNoticeStudentSide=new AdapterNoticeStudentSide(NewsFeed.this, list);
                    recyclerView.setAdapter(adapterNoticeStudentSide);
                    progressDialog.dismiss();
                }

                else
                {
                    Toast.makeText(NewsFeed.this, "No data available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
