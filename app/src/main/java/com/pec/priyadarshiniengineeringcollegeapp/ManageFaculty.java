package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ManageFaculty extends AppCompatActivity {
ActionBar actionBar;
RecyclerView cse, ece, eee, civil, mechanical, mba, mca;
LinearLayout no_data_cse, no_data_ece, no_data_eee, no_data_civil, no_data_mechanical, no_data_mba, no_data_mca;
List<ModalFaculty> list1, list2, list3, list4, list5, list6, list7;
AdapterFaculty adapterFaculty;
ProgressDialog progressDialog;
DatabaseReference databaseReference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_faculty);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Manage Faculty");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_faculty");

        //recyclerview initializations
        cse=findViewById(R.id.cse);
        ece=findViewById(R.id.ece);
        eee=findViewById(R.id.eee);
        civil=findViewById(R.id.civil);
        mechanical=findViewById(R.id.mechanical);
        mba=findViewById(R.id.mba);
        mca=findViewById(R.id.mca);

        //no data found initializations
        no_data_cse=findViewById(R.id.no_data_cse);
        no_data_ece=findViewById(R.id.no_data_ece);
        no_data_eee=findViewById(R.id.no_data_eee);
        no_data_civil=findViewById(R.id.no_data_civil);
        no_data_mechanical=findViewById(R.id.no_data_mechanical);
        no_data_mba=findViewById(R.id.no_data_mba);
        no_data_mca=findViewById(R.id.no_data_mca);

        //getData
        cse();
        ece();
        eee();
        civil();
        mechanical();
        mba();
        mca();
    }

    private void cse() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_cse.setVisibility(View.VISIBLE);
                    cse.setVisibility(View.GONE);
                }
                else
                {
                    no_data_cse.setVisibility(View.GONE);
                    cse.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list1.add(modalFaculty);
                    }

                    cse.setHasFixedSize(true);
                    cse.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list1);
                    cse.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void ece() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("ECE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_ece.setVisibility(View.VISIBLE);
                    ece.setVisibility(View.GONE);
                }
                else
                {
                    no_data_ece.setVisibility(View.GONE);
                    ece.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list2.add(modalFaculty);
                    }

                    ece.setHasFixedSize(true);
                    ece.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list2);
                    ece.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void eee() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("EEE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_eee.setVisibility(View.VISIBLE);
                    eee.setVisibility(View.GONE);
                }
                else
                {
                    no_data_eee.setVisibility(View.GONE);
                    eee.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list3.add(modalFaculty);
                    }

                    eee.setHasFixedSize(true);
                    eee.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list3);
                    eee.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void civil() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("CIVIL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_civil.setVisibility(View.VISIBLE);
                    civil.setVisibility(View.GONE);
                }
                else
                {
                    no_data_civil.setVisibility(View.GONE);
                    civil.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list4.add(modalFaculty);
                    }

                    civil.setHasFixedSize(true);
                    civil.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list4);
                    civil.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void mechanical() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("MECHANICAL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_mechanical.setVisibility(View.VISIBLE);
                    mechanical.setVisibility(View.GONE);
                }
                else
                {
                    no_data_mechanical.setVisibility(View.GONE);
                    mechanical.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list5.add(modalFaculty);
                    }

                    mechanical.setHasFixedSize(true);
                    mechanical.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list5);
                    mechanical.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void mba() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("MBA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_mba.setVisibility(View.VISIBLE);
                    mba.setVisibility(View.GONE);
                }
                else
                {
                    no_data_mba.setVisibility(View.GONE);
                    mba.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list6.add(modalFaculty);
                    }

                    mba.setHasFixedSize(true);
                    mba.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list6);
                    mba.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void mca() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("MCA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_mca.setVisibility(View.VISIBLE);
                    mca.setVisibility(View.GONE);
                }
                else
                {
                    no_data_mca.setVisibility(View.GONE);
                    mca.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalFaculty modalFaculty=snapshot.getValue(ModalFaculty.class);
                        list7.add(modalFaculty);
                    }

                    mca.setHasFixedSize(true);
                    mca.setLayoutManager(new LinearLayoutManager(ManageFaculty.this));
                    adapterFaculty=new AdapterFaculty(ManageFaculty.this, list7);
                    mca.setAdapter(adapterFaculty);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
