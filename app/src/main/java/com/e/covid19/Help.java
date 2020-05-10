package com.e.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class Help extends AppCompatActivity {
    private WebView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toast toast = Toast.makeText(this, "CoVID-19 Tip : Don't get confused with fake news, follow only trusted data providers", Toast.LENGTH_LONG);
        toast.show();
        WebView button = (WebView) findViewById(R.id.button3);
        WebSettings webSettings = button.getSettings();
        webSettings.setJavaScriptEnabled(true);
        button.loadUrl("https://wa.me/919013151515?text=Hi");
    }
}
