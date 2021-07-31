package com.pec.priyadarshiniengineeringcollegeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterNotice extends RecyclerView.Adapter<AdapterNotice.ViewHolder> {

    Context context;
    List<ModalNotice> list;

    public AdapterNotice(Context context, List<ModalNotice> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_notice_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModalNotice modalNotice=list.get(position);

        Picasso.get().load(modalNotice.getImage()).into(holder.imageView2);
        String date="Updated at" + " " + modalNotice.getDate() + " " + modalNotice.getTime();
        holder.textView1.setText(date);
        holder.textView2.setText(modalNotice.getTitle());

        if(modalNotice.getImage()==null)                //showing text only and hiding image on student side if teacher doesn't upload any image on teacher side dashboard
        {
            holder.imageView2.setVisibility(ImageView.GONE);
            holder.textView2.setVisibility(TextView.VISIBLE);
        }

        else if(modalNotice.getTitle()==null)                //showing image only and hiding text on student side if teacher doesn't update any text on teacher side dashboard
        {
            holder.imageView2.setVisibility(ImageView.VISIBLE);
            holder.textView2.setVisibility(TextView.GONE);
        }

        else
        {
            holder.imageView2.setVisibility(ImageView.VISIBLE);
            holder.textView2.setVisibility(TextView.VISIBLE);
        }

        //delete button
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder obj=new AlertDialog.Builder(context);

                obj.setTitle("This page says:");
                obj.setMessage("Do you really want to delete this data?");
                obj.setCancelable(true);

                obj.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("add_notice");
                        databaseReference.child(modalNotice.getUnique_key()).removeValue()
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

                        try {
                            StorageReference storageReference= FirebaseStorage.getInstance().getReferenceFromUrl(modalNotice.getImage());
                            storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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
        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.imageView2);
            imageView2=itemView.findViewById(R.id.imageView3);
            textView1=itemView.findViewById(R.id.textView2);
            textView2=itemView.findViewById(R.id.textView3);

        }
    }
}
