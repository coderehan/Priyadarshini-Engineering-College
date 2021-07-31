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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class AddPrincipal extends AppCompatActivity {
    ActionBar actionBar;
    CardView cardView;
    ImageView imageView;
    EditText editText1, editText2;
    Button button;

    DatabaseReference databaseReference;
    StorageReference storageReference;

    private Bitmap bitmap;
    private String downloadUrl;
    private final int REQ_CODE=1;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_principal);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Add Principal");

        progressDialog=new ProgressDialog(this);

        databaseReference= FirebaseDatabase.getInstance().getReference("add_principal");
        storageReference= FirebaseStorage.getInstance().getReference("principal");

        cardView=findViewById(R.id.cardView);
        imageView=findViewById(R.id.imageView);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
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
        String message=editText2.getText().toString().trim();

        if(name.isEmpty())
        {
            editText1.setError("Required");
            editText1.requestFocus();
            return;
        }

        else if(message.isEmpty())
        {
            editText2.setError("Required");
            editText2.requestFocus();
            return;
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
        filePath=storageReference.child(System.currentTimeMillis() + "jpg");
        final UploadTask uploadTask=filePath.putBytes(finalImage);

        uploadTask.addOnCompleteListener(AddPrincipal.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
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
                    Toast.makeText(AddPrincipal.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void uploadData() {
        String name=editText1.getText().toString().trim();
        String message=editText2.getText().toString().trim();

        if(name.isEmpty())
        {
            editText1.setError("Required");
            editText1.requestFocus();
            return;
        }

        else if(message.isEmpty())
        {
            editText2.setError("Required");
            editText2.requestFocus();
            return;
        }

        final String unique_key=databaseReference.push().getKey();

        ModalPrincipal modalPrincipal=new ModalPrincipal(downloadUrl, name, message, unique_key);

        databaseReference.child(unique_key).setValue(modalPrincipal)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        Toast.makeText(AddPrincipal.this, "Data added successfully", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(AddPrincipal.this, AdminDashboard.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(AddPrincipal.this, "Data added successfully", Toast.LENGTH_LONG).show();
            }
        });
    }


}
