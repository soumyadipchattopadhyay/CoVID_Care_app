package com.e.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    private WebView feed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Toast toast = Toast.makeText(this, "Give your valuable feedback", Toast.LENGTH_LONG);
        toast.show();

        feed = (WebView) findViewById(R.id.feed);
        WebSettings webSettings = feed.getSettings();
        webSettings.setJavaScriptEnabled(true);
        feed.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        feed.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdD0rG_tPPJMDyv8KE30lhkVxLD1O-XSLjeVYbGZMEc4N58RQ/viewform?vc=0&c=0&w=1");
    }
}
