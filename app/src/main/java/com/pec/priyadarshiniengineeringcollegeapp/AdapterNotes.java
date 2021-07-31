package com.pec.priyadarshiniengineeringcollegeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {

    Context context;
    List<ModalNotes> list;

    public AdapterNotes(Context context, List<ModalNotes> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_item_delete, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ModalNotes modalNotes=list.get(position);

        holder.textView1.setText(modalNotes.getPdf_name());

        //this is used to download pdf
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(list.get(position).getUrl()));
               context.startActivity(intent);
            }
        });

        //this is used to view pdf in app itself
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PDFViewer.class);
                intent.putExtra("url", list.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        //delete button
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj=new AlertDialog.Builder(context);

                obj.setTitle("This page says:");
                obj.setMessage("Do you really want to delete this notes?");
                obj.setCancelable(true);

                obj.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("add_notes");
                        DatabaseReference dbRef1=databaseReference.child(modalNotes.getDept());
                        DatabaseReference dbRef2=dbRef1.child(modalNotes.getSemester());
                        dbRef2.child(modalNotes.getPdf_name()).removeValue()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(context, "Notes deleted successfully", Toast.LENGTH_LONG).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(context, "Failed to delete notes", Toast.LENGTH_LONG).show();
                            }
                        });

                        //deleting image from firebase storage

                        StorageReference storageReference= FirebaseStorage.getInstance().getReferenceFromUrl(modalNotes.getUrl());
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
        ImageView imageView1, imageView2;
        TextView textView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.imageView2);
            imageView2=itemView.findViewById(R.id.imageView3);
            textView1=itemView.findViewById(R.id.textView1);
        }
    }
}
