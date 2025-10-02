package com.example.bharath.studentaccreditation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMemo extends AppCompatActivity {

    Button view,approved;
    String ubranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_memo);

        ubranch=getIntent().getStringExtra("ubranch");
        view= (Button) findViewById(R.id.view);
        approved= (Button) findViewById(R.id.approved);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewMemo.class);
                intent.putExtra("ubranch", ubranch);
                startActivity(intent);
            }
        });

        approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ApprovedMemo.class);
                intent.putExtra("ubranch", ubranch);
                startActivity(intent);
            }
        });


    }
}
