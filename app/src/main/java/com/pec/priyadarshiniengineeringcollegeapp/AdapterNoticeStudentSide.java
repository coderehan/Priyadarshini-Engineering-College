package com.pec.priyadarshiniengineeringcollegeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class AdapterNoticeStudentSide extends RecyclerView.Adapter<AdapterNoticeStudentSide.ViewHolder> {

    Context context;
    List<ModalNotice> list;

    public AdapterNoticeStudentSide(Context context, List<ModalNotice> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModalNotice modalNotice=list.get(position);

        Picasso.get().load(modalNotice.getImage()).into(holder.imageView1);
        String date="Updated at" + " " + modalNotice.getDate() + " " + modalNotice.getTime();
        holder.textView1.setText(date);
        holder.textView2.setText(modalNotice.getTitle());

        if(modalNotice.getImage()==null)                //showing text only and hiding image on student side if teacher doesn't upload any image on teacher side dashboard
        {
            holder.imageView1.setVisibility(ImageView.GONE);
            holder.textView2.setVisibility(TextView.VISIBLE);
        }

        else if(modalNotice.getTitle()==null)                //showing image only and hiding text on student side if teacher doesn't update any text on teacher side dashboard
        {
            holder.imageView1.setVisibility(ImageView.VISIBLE);
            holder.textView2.setVisibility(TextView.GONE);
        }

        else
        {
            holder.imageView1.setVisibility(ImageView.VISIBLE);
            holder.textView2.setVisibility(TextView.VISIBLE);
        }

        //applying zooming effect to imageView and taking user to next page by viewing full image
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing data from this source activity to destination activity
                Intent intent=new Intent(context, FullImageView.class);
                intent.putExtra("image", modalNotice.getImage());
                context.startActivity(intent);
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.imageView2);
            textView1=itemView.findViewById(R.id.textView2);
            textView2=itemView.findViewById(R.id.textView3);

        }
    }
}
