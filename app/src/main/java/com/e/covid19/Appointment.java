package com.e.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Appointment extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        Toast toast = Toast.makeText(this, "CoVID-19 Tip : Take help of police and authorities if its emergency", Toast.LENGTH_LONG);
        toast.show();
        mywebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        mywebView.loadUrl("https://ors.gov.in/copp/frm_mobileNo_registration.jsp?NICSecurityORS=A48U-2Y8C-SON8-YYPG-UO43-WQAQ-2JC1-MRO4&NICSecurityORS=A48U-2Y8C-SON8-YYPG-UO43-WQAQ-2JC1-MRO4");

    }
}
