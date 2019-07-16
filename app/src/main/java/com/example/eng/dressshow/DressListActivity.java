package com.example.eng.dressshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DressListActivity extends AppCompatActivity {
    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mRootReference;
    ArrayList<Dress> casaulDresses;
    ArrayList<Dress> weddingDresses;
    DressesAdapter mdressesAdapter;
    GridView gridView;
    Dress dress;
    String dressKind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_list);
//        setTitle(gettingIntent());
        dress = new Dress();
        casaulDresses = new ArrayList<>();
        weddingDresses = new ArrayList<>();
        gridView = findViewById(R.id.dresses_gridview);
        //dressKind=
         gettingIntent();
//        Log.v("dresslistactivitykey",dressKind);

    }
    public String gettingIntent(){
        String returnPath = null;
        Intent intent = getIntent();
        if (intent.hasExtra("weddingKey")){
             returnPath = "Wedding Dresses";

        }
        else if (intent.hasExtra("casualKey")){
            returnPath = "CasualDresses";
        }
        gettingData(returnPath);
        return returnPath;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
    public void gettingData(final String path){
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mRootReference = mfirebaseDatabase.getReference(path);
        mRootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    dress = ds.getValue(Dress.class);
                    if (path.equals("CasualDresses")) {
                        casaulDresses.add(dress);
                        Log.v("retrievingdata", "is successful");
                        mdressesAdapter = new DressesAdapter(getApplicationContext(), casaulDresses);
                    } else if (path.equals("WeddingDresses")) {
                        weddingDresses.add(dress);
                        mdressesAdapter = new DressesAdapter(getApplicationContext(), weddingDresses);

                    }
                }
                Log.v("casualsize()"," "+casaulDresses.size());
                Log.v("weddingsize()"," "+weddingDresses.size());
                gridView.setAdapter(mdressesAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("retrievingdata", "not successful"+databaseError);
            }
        });

    }

}
