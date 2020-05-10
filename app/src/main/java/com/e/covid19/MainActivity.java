package com.e.covid19;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView donate, services, help, more, appo, self, news, contact, govt;
    private WebView mywebView;
    boolean doubleBackToExitPressedOnce = false;

    @Override

    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(this, "Welcome to CoVID Care : All Services in one app", Toast.LENGTH_LONG);
        toast.show();
        setContentView(R.layout.activity_main);

        mywebView = (WebView)findViewById(R.id.webView1);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        mywebView.getSettings().setAppCacheEnabled(true);
        mywebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        mywebView.getSettings().setAllowFileAccess(true);

        if(!isNetworkAvailable()) {
            mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
            openDialog();
        }
        else
        {
            mywebView.clearCache(true);
            mywebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        }

       mywebView.loadUrl("https://www.covid19india.org/");

        govt = (CardView) findViewById(R.id.govt);
        services = (CardView) findViewById(R.id.services);
        donate = (CardView) findViewById(R.id.donate);
        help = (CardView) findViewById(R.id.helpline);
        appo = (CardView) findViewById(R.id.appointment);
        news = (CardView) findViewById(R.id.news);
        contact = (CardView) findViewById(R.id.contact);
        self = (CardView) findViewById(R.id.self);
        more = (CardView) findViewById(R.id.more);

        govt.setOnClickListener(this);
        more.setOnClickListener(this);
        self.setOnClickListener(this);
        donate.setOnClickListener(this);
        services.setOnClickListener(this);
        help.setOnClickListener(this);
        appo.setOnClickListener(this);
        news.setOnClickListener(this);
        contact.setOnClickListener(this);
    }

    private void openDialog() {
        dialog d = new dialog();
        d.show(getSupportFragmentManager(), "dialog");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()){
            case R.id.donate : i = new Intent(this, Donate.class);startActivity(i);break;
            case R.id.services : i = new Intent(this, Choose.class);startActivity(i);break;
            case R.id.helpline : i = new Intent(
                    this, Help.class);startActivity(i);break;
            case R.id.more : i = new Intent(this, More.class);startActivity(i);break;
            case R.id.appointment : i = new Intent(this, Appointment.class);startActivity(i);break;
            case R.id.self : i = new Intent(this, Self.class);startActivity(i);break;
            case R.id.news : i = new Intent(this, News.class);startActivity(i);break;
            case R.id.contact : i = new Intent(this, Menu.class);startActivity(i);break;
            case R.id.govt : i = new Intent(this, Govt.class);startActivity(i);break;
            default:break;
        }
    }
}
