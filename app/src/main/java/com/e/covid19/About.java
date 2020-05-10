package com.e.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class About extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toast toast = Toast.makeText(this, "CoVID-19 Tip : Maintain Social Distancing of at least 1 meter (3 feet)", Toast.LENGTH_LONG);
        toast.show();

        mywebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.getSettings().setAppCacheEnabled(true);
        mywebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        mywebView.getSettings().setAllowFileAccess(true);
        mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        if(!isNetworkAvailable()) {
           mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        mywebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        mywebView.loadUrl("https://www.google.com/intl/en_in/covid19/");

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
