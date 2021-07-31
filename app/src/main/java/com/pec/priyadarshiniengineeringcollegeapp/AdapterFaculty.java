package com.pec.priyadarshiniengineeringcollegeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFaculty extends RecyclerView.Adapter<AdapterFaculty.ViewHolder> {

    Context context;
    List<ModalFaculty> list;

    public AdapterFaculty(Context context, List<ModalFaculty> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_faculty_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModalFaculty modalFaculty=list.get(position);

        Picasso.get().load(modalFaculty.getImage()).into(holder.imageView1);
        holder.textView1.setText(modalFaculty.getName());
        holder.textView2.setText(modalFaculty.getDesignation());

        //update button
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing data from this source activity to destination activity
                Intent intent=new Intent(context, UpdateFaculty.class);
                intent.putExtra("image", modalFaculty.getImage());
                intent.putExtra("name", modalFaculty.getName());
                intent.putExtra("designation", modalFaculty.getDesignation());
                intent.putExtra("dept", modalFaculty.getDept());
                intent.putExtra("unique_key", modalFaculty.getUnique_key());
                context.startActivity(intent);
            }
        });

        //delete button
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj=new AlertDialog.Builder(context);

                obj.setTitle("This page says:");
                obj.setMessage("Do you really want to delete this data?");
                obj.setCancelable(true);

                obj.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("add_faculty");
                        DatabaseReference dbRef=databaseReference.child(modalFaculty.getDept());
                        dbRef.child(modalFaculty.getUnique_key()).removeValue()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(context, "Data deleted successfully", Toast.LENGTH_LONG).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(context, "Failed to delete data", Toast.LENGTH_LONG).show();
                            }
                        });

                        //deleting image from firebase storage

                        StorageReference storageReference= FirebaseStorage.getInstance().getReferenceFromUrl(modalFaculty.getImage());
                        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                    }
                });

                obj.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog=obj.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1;
        TextView textView1, textView2;
        Button button1, button2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.imageView1);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            button1=itemView.findViewById(R.id.button1);
            button2=itemView.findViewById(R.id.button2);
        }
    }
}
