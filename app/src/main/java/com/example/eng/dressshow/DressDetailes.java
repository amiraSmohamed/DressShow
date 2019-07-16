package com.example.eng.dressshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DressDetailes extends AppCompatActivity {
    ImageView dressPoster;
    TextView dressPriceTV;
    TextView dressExpectedWieghtTV;
    TextView dressDescriptionTV;
    TextView contactInfoTV;
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_detailes);
//        Intent intent = getIntent();
//        String dressKind = intent.getStringExtra("dresskind");
//        Log.v("dresskind"," "+dressKind);
        dressPoster = findViewById(R.id.dress_poster_iv);
        dressPriceTV = findViewById(R.id.price);
        dressDescriptionTV = findViewById(R.id.description);
        dressExpectedWieghtTV = findViewById(R.id.expected_wieght);
        contactInfoTV = findViewById(R.id.contact_info_id);
        mFloatingActionButton = findViewById(R.id.add_fab);
        Intent dresslistIntent = getIntent();
        if(dresslistIntent != null && ((dresslistIntent.hasExtra("LIST_KEY")) |(dresslistIntent.hasExtra("dresskind")))) {
            Dress dress = (Dress) dresslistIntent.getSerializableExtra("LIST_KEY");
            dressExpectedWieghtTV.setText(dress.getExpectedWieght());
            dressDescriptionTV.setText(dress.getDressDescription());
            dressPriceTV.setText(dress.getPrice());
            contactInfoTV.setText(dress.getContactInfo());
            Glide.with(this).load(dress.getDressImage()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.loading).error(R.drawable.error).centerCrop().into(dressPoster);
        }
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_SEND);
                mIntent.setType("text/plain");
                String shareBody = "This application to show varity of dresses to sell or rent ";
                String shareSub = "Dress show app ";
                mIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                mIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(mIntent, "share using"));


// Intent addIntent  = new Intent(getApplicationContext(),AddDressActivity.class);
//                    addIntent.putExtra("dresskindKey",dressKind);
//                    startActivity(addIntent);

            }
        });


    }
}