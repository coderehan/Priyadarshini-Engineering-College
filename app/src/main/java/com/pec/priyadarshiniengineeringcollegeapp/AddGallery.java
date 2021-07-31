package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AddGallery extends AppCompatActivity {
ActionBar actionBar;

    CardView cardView;
    ImageView imageView;
    Spinner spinner1;
    Button button;
    DatabaseReference databaseReference, dbRef;
    StorageReference storageReference;

    private Bitmap bitmap;
    private String downloadUrl;
    private final int REQ_CODE=1;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gallery);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Upload Gallery Photos");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_gallery");
        storageReference= FirebaseStorage.getInstance().getReference("gallery");

        cardView=findViewById(R.id.cardView);
        imageView=findViewById(R.id.imageView1);
        spinner1=findViewById(R.id.spinner1);
        button=findViewById(R.id.button);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

        String[] items=new String[]{"--Select Category--", "Graduation Day", "Induction Day", "CSE", "ECE", "EEE", "CIVIL", "MECHANICAL", "MBA", "MCA", "Other Events"};
        spinner1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items));
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String category=spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void openGallery() {
        Intent pickImage=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE && resultCode==RESULT_OK)
        {
            Uri uri=data.getData();
            try {
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    private void validation() {
        String category=spinner1.getSelectedItem().toString();

        if (category.equals("--Select Category--"))
        {
            Toast.makeText(this, "Please select gallery category", Toast.LENGTH_LONG).show();
        }

        else if(bitmap==null)
        {
            uploadData();
        }

        else
        {
            uploadImage();
        }
    }

    private void uploadImage() {
        progressDialog.setMessage("Uploading Image...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] finalImage=baos.toByteArray();
        final StorageReference filePath;
        filePath=storageReference.child(spinner1.getSelectedItem().toString()).child(System.currentTimeMillis() + "jpg");
        final UploadTask uploadTask=filePath.putBytes(finalImage);

        uploadTask.addOnCompleteListener(AddGallery.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if(task.isSuccessful())
                {
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    downloadUrl=String.valueOf(uri);
                                    uploadData();
                                }
                            });
                        }
                    });
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(AddGallery.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void uploadData() {
        String category=spinner1.getSelectedItem().toString();

        if (category.equals("--Select Category--"))
        {
            Toast.makeText(this, "Please select gallery category", Toast.LENGTH_LONG).show();
        }

        final String unique_key=databaseReference.push().getKey();

        dbRef=databaseReference.child(spinner1.getSelectedItem().toString());
        dbRef.child(unique_key).setValue(downloadUrl)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        Toast.makeText(AddGallery.this, "Data added successfully", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(AddGallery.this, ManageGallery.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(AddGallery.this, "Data added successfully", Toast.LENGTH_LONG).show();
            }
        });
    }


}

