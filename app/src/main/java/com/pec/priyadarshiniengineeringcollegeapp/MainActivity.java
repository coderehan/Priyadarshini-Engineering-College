package com.pec.priyadarshiniengineeringcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class MainActivity extends AppCompatActivity {
    SliderLayout sliderLayout;
DrawerLayout drawerLayout;
Toolbar toolbar;
ActionBarDrawerToggle actionBarDrawerToggle;
NavigationView navigationView;
CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;
FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //internet connection
        if(!isConnected(MainActivity.this))
        {
            showAlertDialog();
        }

        //auto image slider
        sliderLayout=findViewById(R.id.sliderLayout);

        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);
        setSliderView();

        fab=findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fabTT=new Intent(MainActivity.this, TimeTable.class);
                startActivity(fabTT);
            }
        });

        cardView1=findViewById(R.id.cardView1);
        cardView2=findViewById(R.id.cardView2);
        cardView3=findViewById(R.id.cardView3);
        cardView4=findViewById(R.id.cardView4);
        cardView5=findViewById(R.id.cardView5);
        cardView6=findViewById(R.id.cardView6);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, AboutPEC.class);
                startActivity(intent1);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this, NewsFeed.class);
                startActivity(intent2);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this, Faculty.class);
                startActivity(intent3);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(MainActivity.this, Gallery.class);
                startActivity(intent4);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(MainActivity.this, DownloadNotes.class);
                startActivity(intent5);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent6);
            }
        });

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Priyadarshini Engineering College");
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView=findViewById(R.id.navigationView);
        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "This is the Home page of PEC", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_time_table:
                        Intent intent7=new Intent(MainActivity.this, TimeTable.class);
                        startActivity(intent7);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_newsfeed:
                        Intent intent8=new Intent(MainActivity.this, NewsFeed.class);
                        startActivity(intent8);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_download_notes:
                        Intent intent9=new Intent(MainActivity.this, DownloadNotes.class);
                        startActivity(intent9);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_about_pec:
                        Intent intent10=new Intent(MainActivity.this, AboutPEC.class);
                        startActivity(intent10);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_faculty:
                        Intent intent11=new Intent(MainActivity.this, Faculty.class);
                        startActivity(intent11);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_gallery:
                        Intent intent12=new Intent(MainActivity.this, Gallery.class);
                        startActivity(intent12);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_contact_us:
                        Intent intent13=new Intent(MainActivity.this, ContactUs.class);
                        startActivity(intent13);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_admin_login:
                        Intent intent14=new Intent(MainActivity.this, AdminLogin.class);
                        startActivity(intent14);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_faculty_login:
                        Intent intent15=new Intent(MainActivity.this, TeacherLogin.class);
                        startActivity(intent15);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_about_developer:
                        Intent intent16=new Intent(MainActivity.this, AboutDeveloper.class);
                        startActivity(intent16);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_gpa_app:
                        String downloadGPA="https://play.google.com/store/apps/details?id=com.rehan.gpacgpacalculator";
                        Uri uri1=Uri.parse(downloadGPA);
                        Intent download=new Intent(Intent.ACTION_VIEW, uri1);
                        startActivity(download);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_rate_app:
                        String app_link="https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();
                        Uri uri2=Uri.parse(app_link);
                        Intent rate=new Intent(Intent.ACTION_VIEW, uri2);
                        try {
                            startActivity(rate);
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Something went wrong. Unable to open", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.nav_share_app:
                        try {
                            Intent share=new Intent(Intent.ACTION_SEND);
                            share.setType("text/plain");
                            String subject="Priyadarshini Engineering College App";
                            String body="Download PEC App from Google Play Store by clicking the below link. This app is made for PECians. Please rate this app and share this app with your friends and tell them to give feeback about this app in playstore. Your suggestions and feedbacks are always appreciated and delighted to hear.";
                            share.putExtra(Intent.EXTRA_SUBJECT, subject + "\n");
                            share.putExtra(Intent.EXTRA_TEXT, body + "\n\n" + "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                            startActivity(Intent.createChooser(share, "Share App With:"));
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Something went wrong. Unable to open", Toast.LENGTH_LONG).show();
                        }
                        break;

                }
                return true;
            }
        });
    }

    //auto image slider
    private void setSliderView() {
        for (int i=0; i<6; i++)
        {
            DefaultSliderView defaultSliderView=new DefaultSliderView(this);

            switch (i)
            {
                case 0:
                    defaultSliderView.setImageUrl("http://priyadarshini.net.in/pec_new/extra-images/02.jpg");
                    break;

                case 1:
                    defaultSliderView.setImageUrl("http://priyadarshini.net.in/pec_new/extra-images/01.jpg");
                    break;

                case 2:
                    defaultSliderView.setImageUrl("http://priyadarshini.net.in/pec_new/extra-images/03.jpg");
                    break;

                case 3:
                    defaultSliderView.setImageUrl("http://priyadarshini.net.in/pec_new/extra-images/04.jpg");
                    break;

                case 4:
                    defaultSliderView.setImageUrl("http://priyadarshini.net.in/pec_new/extra-images/05.jpg");
                    break;

                case 5:
                    defaultSliderView.setImageUrl("http://priyadarshini.net.in/pec_new/extra-images/07.jpg");
                    break;
            }

            defaultSliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(defaultSliderView);
        }
    }

    //checking internet connection
    private boolean isConnected(MainActivity mainActivity) {
        ConnectivityManager connectivityManager= (ConnectivityManager) mainActivity.getSystemService((Context.CONNECTIVITY_SERVICE));
        NetworkInfo wifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if((wifi!=null && wifi.isConnectedOrConnecting()) || (mobile!=null && mobile.isConnectedOrConnecting()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Dear user! Please connect app to internet to proceed further.");
        builder.setCancelable(false);

        builder.setPositiveButton("CONNECT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    //showing alert dialog box on closing app
    @Override
    public void onBackPressed() {
        AlertDialog.Builder obj=new AlertDialog.Builder(MainActivity.this);

        obj.setTitle("This Application Says:");
        obj.setMessage("Do you really want to close this app?");
        obj.setCancelable(true);

        obj.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        obj.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=obj.create();
        alertDialog.show();
    }
}
