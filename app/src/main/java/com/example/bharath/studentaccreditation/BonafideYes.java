package com.example.bharath.studentaccreditation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BonafideYes extends AppCompatActivity {

    String cid;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonafide_yes);

        cid=getIntent().getStringExtra("cid");

        db=openOrCreateDatabase("stuacc", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        ContentValues cv=new ContentValues();
        String status="Approved";
        cv.put("status", status);

        String[] args=new String[]{cid};
        db.update("certificate",cv,"id=?",args);

        Toast.makeText(getApplicationContext(), "Bonafide Approved", Toast.LENGTH_LONG).show();
        Intent i=new Intent(getApplicationContext(),AdminHome.class);
        startActivity(i);


    }
}
