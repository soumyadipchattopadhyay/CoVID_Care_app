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

public class Who extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);

        Toast toast = Toast.makeText(this, "CoVID-19 Tip : If you feel illness, cold & cough, consult your doctor as soon as possible", Toast.LENGTH_LONG);
        toast.show();


        mywebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.getSettings().setAppCacheEnabled(true);
        mywebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        mywebView.getSettings().setAllowFileAccess(true);
        mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


        mywebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        if(!isNetworkAvailable()) {
            mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        mywebView.loadUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/technical-guidance");

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
