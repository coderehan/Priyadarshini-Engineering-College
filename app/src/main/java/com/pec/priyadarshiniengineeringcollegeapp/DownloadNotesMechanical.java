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

public class DownloadNotesMechanical extends AppCompatActivity {
    ActionBar actionBar;
    RecyclerView sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8;
    LinearLayout no_data_sem1, no_data_sem2, no_data_sem3, no_data_sem4, no_data_sem5, no_data_sem6, no_data_sem7, no_data_sem8;
    List<ModalNotes> list1, list2, list3, list4, list5, list6, list7, list8;
    AdapterNotesStudentSide adapterNotesStudentSide;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference, dbRef1, dbRef2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_notes_mechanical);

        actionBar=getSupportActionBar();
        actionBar.setTitle("MECHANICAL Dept");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_notes");

        //recyclerview initializations
        sem1=findViewById(R.id.sem1);
        sem2=findViewById(R.id.sem2);
        sem3=findViewById(R.id.sem3);
        sem4=findViewById(R.id.sem4);
        sem5=findViewById(R.id.sem5);
        sem6=findViewById(R.id.sem6);
        sem7=findViewById(R.id.sem7);
        sem8=findViewById(R.id.sem8);

        //no data found initializations
        no_data_sem1=findViewById(R.id.no_data_sem1);
        no_data_sem2=findViewById(R.id.no_data_sem2);
        no_data_sem3=findViewById(R.id.no_data_sem3);
        no_data_sem4=findViewById(R.id.no_data_sem4);
        no_data_sem5=findViewById(R.id.no_data_sem5);
        no_data_sem6=findViewById(R.id.no_data_sem6);
        no_data_sem7=findViewById(R.id.no_data_sem7);
        no_data_sem8=findViewById(R.id.no_data_sem8);

        //getData
        sem1();
        sem2();
        sem3();
        sem4();
        sem5();
        sem6();
        sem7();
        sem8();

    }

    private void sem1() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 1");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem1.setVisibility(View.VISIBLE);
                    sem1.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem1.setVisibility(View.GONE);
                    sem1.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list1.add(modalNotes);
                    }

                    sem1.setHasFixedSize(true);
                    sem1.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list1);
                    sem1.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem2() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 2");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem2.setVisibility(View.VISIBLE);
                    sem2.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem2.setVisibility(View.GONE);
                    sem2.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list2.add(modalNotes);
                    }

                    sem2.setHasFixedSize(true);
                    sem2.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list2);
                    sem2.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem3() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 3");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem3.setVisibility(View.VISIBLE);
                    sem3.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem3.setVisibility(View.GONE);
                    sem3.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list3.add(modalNotes);
                    }

                    sem3.setHasFixedSize(true);
                    sem3.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list3);
                    sem3.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem4() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 4");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem4.setVisibility(View.VISIBLE);
                    sem4.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem4.setVisibility(View.GONE);
                    sem4.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list4.add(modalNotes);
                    }

                    sem4.setHasFixedSize(true);
                    sem4.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list4);
                    sem4.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem5() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 5");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem5.setVisibility(View.VISIBLE);
                    sem5.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem5.setVisibility(View.GONE);
                    sem5.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list5.add(modalNotes);
                    }

                    sem5.setHasFixedSize(true);
                    sem5.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list5);
                    sem5.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem6() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 6");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem6.setVisibility(View.VISIBLE);
                    sem6.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem6.setVisibility(View.GONE);
                    sem6.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list6.add(modalNotes);
                    }

                    sem6.setHasFixedSize(true);
                    sem6.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list6);
                    sem6.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem7() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 7");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem7.setVisibility(View.VISIBLE);
                    sem7.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem7.setVisibility(View.GONE);
                    sem7.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list7.add(modalNotes);
                    }

                    sem7.setHasFixedSize(true);
                    sem7.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list7);
                    sem7.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sem8() {
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        dbRef1=databaseReference.child("MECHANICAL");
        dbRef2=dbRef1.child("SEMESTER 8");
        dbRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8=new ArrayList<>();

                if (!dataSnapshot.exists())
                {
                    no_data_sem8.setVisibility(View.VISIBLE);
                    sem8.setVisibility(View.GONE);
                }
                else
                {
                    no_data_sem8.setVisibility(View.GONE);
                    sem8.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ModalNotes modalNotes=snapshot.getValue(ModalNotes.class);
                        list8.add(modalNotes);
                    }

                    sem8.setHasFixedSize(true);
                    sem8.setLayoutManager(new LinearLayoutManager(DownloadNotesMechanical.this));
                    adapterNotesStudentSide=new AdapterNotesStudentSide(DownloadNotesMechanical.this, list8);
                    sem8.setAdapter(adapterNotesStudentSide);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
