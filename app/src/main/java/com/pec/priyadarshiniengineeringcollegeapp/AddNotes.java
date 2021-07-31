package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddNotes extends AppCompatActivity {
ActionBar actionBar;
    CardView cardView;
    EditText editText1;
    Spinner spinner1, spinner2;
    Button button;

    DatabaseReference databaseReference, dbRef1, dbRef2;
    StorageReference storageReference, storageRef1, storageRef2, storageRef3;
    private final int REQ_CODE=1;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Upload Notes");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_notes");
        storageReference= FirebaseStorage.getInstance().getReference("notes");

        cardView=findViewById(R.id.cardView);
        editText1=findViewById(R.id.editText1);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        button=findViewById(R.id.button);
        button.setEnabled(false);

        String[] items1=new String[]{"--Select Department--", "CSE", "ECE", "EEE", "CIVIL", "MECHANICAL", "MBA", "MCA"};
        spinner1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1));
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dept=spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] items2=new String[]{"--Select Semester--", "SEMESTER 1", "SEMESTER 2", "SEMESTER 3", "SEMESTER 4", "SEMESTER 5", "SEMESTER 6", "SEMESTER 7", "SEMESTER 8"};
        spinner2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2));
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String semester=spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });
    }

    private void selectPDF() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "SELECT PDF FILE"), REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            button.setEnabled(true);
            editText1.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadPDF(data.getData());
                }
            });
        }
    }

    private void uploadPDF(Uri data) {
        progressDialog.setMessage("Uploading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        storageRef1=storageReference.child(spinner1.getSelectedItem().toString());
        storageRef2=storageRef1.child(spinner2.getSelectedItem().toString());
        storageRef3=storageRef2.child(editText1.getText().toString() + ".pdf");
        storageRef3.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri=uriTask.getResult();
                        ModalNotes modalNotes=new ModalNotes(editText1.getText().toString(), spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), uri.toString());
                        dbRef1=databaseReference.child(spinner1.getSelectedItem().toString());
                        dbRef2=dbRef1.child(spinner2.getSelectedItem().toString());
                        dbRef2.child(editText1.getText().toString()).setValue(modalNotes);
                        progressDialog.dismiss();
                        Toast.makeText(AddNotes.this, "Notes uploaded successfully", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(AddNotes.this, DeleteNotes.class);
                        startActivity(intent);
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("File Uploaded" + " " + (int) progress + "%");
            }
        });
    }
}
