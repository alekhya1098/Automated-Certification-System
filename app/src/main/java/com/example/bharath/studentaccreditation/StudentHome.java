package com.example.bharath.studentaccreditation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class StudentHome extends AppCompatActivity {

    TextView apply,status,logout;
    String sid,branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        apply= (TextView) findViewById(R.id.apply);
        status= (TextView) findViewById(R.id.status);
        logout= (TextView) findViewById(R.id.logout);

        sid=getIntent().getStringExtra("sid");
        branch=getIntent().getStringExtra("branch");

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StudentApply.class);
                intent.putExtra("sid",sid);
                intent.putExtra("branch",branch);
                startActivity(intent);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StudentStatus.class);
                intent.putExtra("sid",sid);
                intent.putExtra("branch",branch);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
