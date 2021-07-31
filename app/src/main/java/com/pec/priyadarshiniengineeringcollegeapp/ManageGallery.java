package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class ManageGallery extends AppCompatActivity {
    ActionBar actionBar;
    RecyclerView graduation, induction, cse, ece, eee, civil, mechanical, mba, mca, other;
    LinearLayout no_data_graduation, no_data_induction, no_data_cse, no_data_ece, no_data_eee, no_data_civil, no_data_mechanical, no_data_mba, no_data_mca, no_data_other;
    List<String> list_graduation, list_induction, list1, list2, list3, list4, list5, list6, list7, list_other;
    AdapterGallery adapterGallery;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_gallery);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Manage Gallery");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_gallery");

        //recyclerview initializations
        graduation=findViewById(R.id.graduation);
        induction=findViewById(R.id.induction);
        cse=findViewById(R.id.cse);
        ece=findViewById(R.id.ece);
        eee=findViewById(R.id.eee);
        civil=findViewById(R.id.civil);
        mechanical=findViewById(R.id.mechanical);
        mba=findViewById(R.id.mba);
        mca=findViewById(R.id.mca);
        other=findViewById(R.id.other);

        //no data found initializations
        no_data_graduation=findViewById(R.id.no_data_graduation);
        no_data_induction=findViewById(R.id.no_data_induction);
        no_data_cse=findViewById(R.id.no_data_cse);
        no_data_ece=findViewById(R.id.no_data_ece);
        no_data_eee=findViewById(R.id.no_data_eee);
        no_data_civil=findViewById(R.id.no_data_civil);
        no_data_mechanical=findViewById(R.id.no_data_mechanical);
        no_data_mba=findViewById(R.id.no_data_mba);
        no_data_mca=findViewById(R.id.no_data_mca);
        no_data_other=findViewById(R.id.no_data_other);

        //getData
        graduation();
        induction();
        cse();
        ece();
        eee();
        civil();
        mechanical();
        mba();
        mca();
        other();
    }

    private void graduation() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("Graduation Day");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_graduation=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_graduation.setVisibility(View.VISIBLE);
                    graduation.setVisibility(View.GONE);
                }
                else
                {
                    no_data_graduation.setVisibility(View.GONE);
                    graduation.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        String data= (String) snapshot.getValue();
                        list_graduation.add(0,data);
                    }

                    graduation.setHasFixedSize(true);
                    graduation.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list_graduation);
                    graduation.setAdapter(adapterGallery);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void induction() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("Induction Day");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_induction=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_induction.setVisibility(View.VISIBLE);
                    induction.setVisibility(View.GONE);
                }
                else
                {
                    no_data_induction.setVisibility(View.GONE);
                    induction.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        String data= (String) snapshot.getValue();
                        list_induction.add(0,data);
                    }

                    induction.setHasFixedSize(true);
                    induction.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list_induction);
                    induction.setAdapter(adapterGallery);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
                        String data= (String) snapshot.getValue();
                        list1.add(0,data);
                    }

                    cse.setHasFixedSize(true);
                    cse.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list1);
                    cse.setAdapter(adapterGallery);
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
                        String data= (String) snapshot.getValue();
                        list2.add(0,data);
                    }

                    ece.setHasFixedSize(true);
                    ece.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list2);
                    ece.setAdapter(adapterGallery);
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
                        String data= (String) snapshot.getValue();
                        list3.add(0,data);
                    }

                    eee.setHasFixedSize(true);
                    eee.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list3);
                    eee.setAdapter(adapterGallery);
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
                        String data= (String) snapshot.getValue();
                        list4.add(0,data);
                    }

                    civil.setHasFixedSize(true);
                    civil.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list4);
                    civil.setAdapter(adapterGallery);
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
                        String data= (String) snapshot.getValue();
                        list5.add(0,data);
                    }

                    mechanical.setHasFixedSize(true);
                    mechanical.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list5);
                    mechanical.setAdapter(adapterGallery);
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
                        String data= (String) snapshot.getValue();
                        list6.add(0,data);
                    }

                    mba.setHasFixedSize(true);
                    mba.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list6);
                    mba.setAdapter(adapterGallery);
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
                        String data= (String) snapshot.getValue();
                        list7.add(0,data);
                    }

                    mca.setHasFixedSize(true);
                    mca.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list7);
                    mca.setAdapter(adapterGallery);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void other() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef=databaseReference.child("Other Events");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_other=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_other.setVisibility(View.VISIBLE);
                    other.setVisibility(View.GONE);
                }
                else
                {
                    no_data_other.setVisibility(View.GONE);
                    other.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        String data= (String) snapshot.getValue();
                        list_other.add(0,data);
                    }

                    other.setHasFixedSize(true);
                    other.setLayoutManager(new GridLayoutManager(ManageGallery.this, 3));
                    adapterGallery=new AdapterGallery(ManageGallery.this, list_other);
                    other.setAdapter(adapterGallery);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
