package com.example.bharath.studentaccreditation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class StudentYes extends AppCompatActivity {

    String sid;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_yes);

        sid=getIntent().getStringExtra("sid");

        db=openOrCreateDatabase("stuacc", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        ContentValues cv=new ContentValues();
        String status="yes";
        cv.put("status", status);

        String[] args=new String[]{sid};
        db.update("student",cv,"sid=?",args);

        Toast.makeText(getApplicationContext(), "Student Approved", Toast.LENGTH_LONG).show();
        Intent i=new Intent(getApplicationContext(),AdminHome.class);
        startActivity(i);


    }
}
