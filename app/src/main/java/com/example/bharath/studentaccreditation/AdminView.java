package com.example.bharath.studentaccreditation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class AdminView extends AppCompatActivity {

    TextView stu,bonafide,memo,buspass,idcard;
    String ubranch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

        ubranch=getIntent().getStringExtra("ubranch");

        stu= (TextView) findViewById(R.id.stu);
        bonafide= (TextView) findViewById(R.id.bonafide);
        memo= (TextView) findViewById(R.id.memo);
        buspass= (TextView) findViewById(R.id.buspass);
        idcard= (TextView) findViewById(R.id.idcard);

        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminStudent.class);
                intent.putExtra("ubranch",ubranch);
                startActivity(intent);
            }
        });

        bonafide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminBonafide.class);
                intent.putExtra("ubranch",ubranch);
                startActivity(intent);
            }
        });

        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminMemo.class);
                intent.putExtra("ubranch",ubranch);
                startActivity(intent);
            }
        });

        buspass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminBusPass.class);
                intent.putExtra("ubranch",ubranch);
                startActivity(intent);
            }
        });

        idcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminIdCard.class);
                intent.putExtra("ubranch",ubranch);
                startActivity(intent);
            }
        });

    }
}
