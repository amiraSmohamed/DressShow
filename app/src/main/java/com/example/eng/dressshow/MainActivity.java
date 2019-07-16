package com.example.eng.dressshow;

//import androidx.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
Button mWeddingBT;
Button mCasualBT;
Toolbar mTopToolbar;
private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
        mWeddingBT = findViewById(R.id.wedding_bt_id);
        mCasualBT = findViewById(R.id.casual_bt_id);
        mWeddingBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String buttonText = mWeddingBT.getText().toString();
                Intent intent = new Intent(MainActivity.this,DressListActivity.class);
              intent.putExtra("weddingKey",buttonText);
                startActivity(intent);
            }
        });
        mCasualBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = mCasualBT.getText().toString();
                Intent intent = new Intent(MainActivity.this,DressListActivity.class);
                intent.putExtra("casualKey",buttonText);
                startActivity(intent);
            }
        });

    }
}
