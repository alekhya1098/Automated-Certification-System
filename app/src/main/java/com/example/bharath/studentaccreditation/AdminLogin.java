package com.example.bharath.studentaccreditation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class AdminLogin extends AppCompatActivity {

    EditText name,pwd;
    String uname,upwd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        name= (EditText) findViewById(R.id.uname);
        pwd= (EditText) findViewById(R.id.pwd);
        login= (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname = name.getText().toString();
                upwd = pwd.getText().toString();

                if (name.getText().toString().equalsIgnoreCase("") || pwd.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_LONG).show();
                } else if (name.getText().toString().equalsIgnoreCase("admin") && pwd.getText().toString().equalsIgnoreCase("admin")) {
                    Intent intent = new Intent(getApplicationContext(), AdminHome.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
