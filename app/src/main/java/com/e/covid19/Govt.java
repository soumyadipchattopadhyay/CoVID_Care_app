package com.e.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class Govt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt);
        findViewById(R.id.ambu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialAmbu("108");
            }
        });
        findViewById(R.id.police).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPolice("100");
            }
        });
        findViewById(R.id.src).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialSenior("9830088884");
            }
        });
        findViewById(R.id.child).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialChild("1098");
            }
        });
    }
    private void dialAmbu(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    private void dialPolice(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    private void dialSenior(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    private void dialChild(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
