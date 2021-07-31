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
import android.widget.EditText;
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
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class UpdateFaculty extends AppCompatActivity {
    ActionBar actionBar;
    CardView cardView;
    ImageView imageView;
    EditText editText1;
    Spinner spinner1, spinner2;
    Button button;

    DatabaseReference databaseReference, dbRef;
    StorageReference storageReference;

    private Bitmap bitmap;
    private String downloadUrl;
    private final int REQ_CODE=1;
    ProgressDialog progressDialog;

    //creating global variables to store data as existing data in all EditTexts
    String image, name, designation, dept, unique_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Update Faculty");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_faculty");
        storageReference= FirebaseStorage.getInstance().getReference("faculty");

        cardView=findViewById(R.id.cardView);
        imageView=findViewById(R.id.imageView);
        editText1=findViewById(R.id.editText1);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        button=findViewById(R.id.button);

        String[] items1=new String[]{"--Select Designation--", "Principal", "HOD", "Associate Professor", "Assistant Professor", "Lab Assistant"};
        spinner1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1));
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String designation=spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] items2=new String[]{"--Select Department--", "CSE", "ECE", "EEE", "CIVIL", "MECHANICAL", "MBA", "MCA"};
        spinner2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2));
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dept=spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

        //getting data from source activity and displaying in this destination activity
        image=getIntent().getStringExtra("image");
        name=getIntent().getStringExtra("name");
        designation=getIntent().getStringExtra("designation");
        dept=getIntent().getStringExtra("dept");
        unique_key=getIntent().getStringExtra("unique_key");

        //setting data as existing data
        Picasso.get().load(image).into(imageView);
        editText1.setText(name);

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
        String name=editText1.getText().toString().trim();
        String designation=spinner1.getSelectedItem().toString();
        String dept=spinner2.getSelectedItem().toString();

        if(name.isEmpty())
        {
            editText1.setError("Required");
            editText1.requestFocus();
            return;
        }

        else if(designation.equals("--Select Designation--"))
        {
            Toast.makeText(this, "Please select designation", Toast.LENGTH_LONG).show();
        }

        else if(dept.equals("--Select Department--"))
        {
            Toast.makeText(this, "Please select department", Toast.LENGTH_LONG).show();
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
        filePath=storageReference.child(spinner2.getSelectedItem().toString()).child(System.currentTimeMillis() + "jpg");
        final UploadTask uploadTask=filePath.putBytes(finalImage);

        uploadTask.addOnCompleteListener(UpdateFaculty.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
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
                    Toast.makeText(UpdateFaculty.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void uploadData() {
        String name=editText1.getText().toString().trim();
        String designation=spinner1.getSelectedItem().toString();
        String dept=spinner2.getSelectedItem().toString();

        if(name.isEmpty())
        {
            editText1.setError("Required");
            editText1.requestFocus();
            return;
        }

        else if(designation.equals("--Select Designation--"))
        {
            Toast.makeText(this, "Please select designation", Toast.LENGTH_LONG).show();
        }

        else if(dept.equals("--Select Department--"))
        {
            Toast.makeText(this, "Please select department", Toast.LENGTH_LONG).show();
        }

        HashMap<String, Object> hashMap=new HashMap<>();

        hashMap.put("image", downloadUrl);
        hashMap.put("name", name);
        hashMap.put("designation", designation);
        hashMap.put("dept", dept);
        hashMap.put("unique_key", unique_key);

        dbRef=databaseReference.child(dept);
        dbRef.child(unique_key).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        Toast.makeText(UpdateFaculty.this, "Data updated successfully", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(UpdateFaculty.this, ManageFaculty.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(UpdateFaculty.this, "Failed to update data", Toast.LENGTH_LONG).show();
            }
        });

    }

}

