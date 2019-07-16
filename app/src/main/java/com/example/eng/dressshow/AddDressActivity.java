package com.example.eng.dressshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDressActivity extends AppCompatActivity {

    EditText mImageUrlET;
    EditText mDescriptionET;
    EditText mPriceET;
    EditText mWeightET;
    EditText mContactInfoET;
    Button saveBT;

    String imageUrl;
    String description;
    String price;
    String weight;
    String contactInfo;
    DatabaseReference mRefrence;
    Dress dress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dress);
//        Intent intent = getIntent();
//        final String dresskind = intent.getStringExtra("dresskindKey");

        mImageUrlET = findViewById(R.id.image_url_et);
        mDescriptionET = findViewById(R.id.description_et);
        mPriceET = findViewById(R.id.price_et);
        mWeightET = findViewById(R.id.weight_et);
        mContactInfoET = findViewById(R.id.contact_info_et);
        saveBT = findViewById(R.id.save_bt);
        imageUrl = mImageUrlET.getText().toString();
        description = mDescriptionET.getText().toString();
        price = mPriceET.getText().toString();
        weight = mWeightET.getText().toString();
        contactInfo = mContactInfoET.getText().toString();

        saveBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(dresskind .equals("CasualDresses")){
//               mRefrence = FirebaseDatabase.getInstance().getReference("CasualDresses/11");
//               dress = new Dress(description,imageUrl,weight,contactInfo,price);
//               mRefrence.push().setValue(dress);
//                    Toast.makeText(getApplicationContext(),"inseted successfully",Toast.LENGTH_LONG).show();
//                }
//                else {
//
//                }
            }
        });

    }
}
