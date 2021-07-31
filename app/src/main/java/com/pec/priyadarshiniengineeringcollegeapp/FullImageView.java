package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FullImageView extends AppCompatActivity {
PhotoView photoView;
Button button;
BitmapDrawable drawable;
Bitmap bitmap;

//creating global variable to display data in this destination activity
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        getSupportActionBar().hide();

        photoView=findViewById(R.id.imageView);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadImage();
            }
        });

        //getting data from source activity and displaying in this destination activity
        image=getIntent().getStringExtra("image");

        //setting data in ImageView as existing data
        try {
            Glide.with(this).load(image).into(photoView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadImage() {
        drawable= (BitmapDrawable) photoView.getDrawable();
        bitmap=drawable.getBitmap();
        FileOutputStream outputStream=null;
        File SdCard= Environment.getExternalStorageDirectory();
        File directory=new File(SdCard.getAbsolutePath() + "/PEC");
        directory.mkdir();
        String fileName=String.format("%d.jpg", System.currentTimeMillis());
        File outFile=new File(directory, fileName);
        Toast.makeText(this, "Image saved successfully", Toast.LENGTH_LONG).show();
        try {
            outputStream=new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();

            Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.fromFile(outFile));
            sendBroadcast(intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
