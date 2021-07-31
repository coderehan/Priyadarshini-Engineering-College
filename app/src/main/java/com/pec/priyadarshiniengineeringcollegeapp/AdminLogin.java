package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminLogin extends AppCompatActivity {
    ActionBar actionBar;

    EditText editText1, editText2;
    Button button;
    ProgressBar progressBar;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        actionBar=getSupportActionBar();
        actionBar.setTitle("Admin Login");

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        progressBar=findViewById(R.id.progressBar);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {
        String email_id=editText1.getText().toString().trim();
        String password=editText2.getText().toString().trim();

        if(email_id.isEmpty())
        {
            editText1.setError("Email ID Required");
            editText1.requestFocus();
            return;
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(email_id).matches())
        {
            editText1.setError("Invalid Email ID");
            editText1.requestFocus();
            return;
        }

        else if(password.isEmpty())
        {
            editText2.setError("Password Required");
            editText2.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email_id, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(AdminLogin.this, "Login Successful", Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(AdminLogin.this, AdminDashboard.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(AdminLogin.this, "Please check your Email ID and Password", Toast.LENGTH_LONG).show();
            }
        });
    }
}
