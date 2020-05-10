package com.e.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Course extends AppCompatActivity {

    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        mywebView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mywebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        mywebView.loadUrl("https://www.nptel.ac.in/");
    }
}
