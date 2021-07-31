package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PDFViewer extends AppCompatActivity {
PDFView pdfView;

//creating global variable to store data
String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_viewer);

        getSupportActionBar().hide();

        pdfView=findViewById(R.id.pdfView);

        //getting data from source activity to destination activity
        url=getIntent().getStringExtra("url");

        new PdfDownload().execute(url);
    }


    private class PdfDownload extends AsyncTask<String, Void, InputStream>{
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream=null;

            try {
                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();

                if(urlConnection.getResponseCode()==200)
                {
                    inputStream=new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            super.onPostExecute(inputStream);
            pdfView.fromStream(inputStream).load();
        }
    }

}
