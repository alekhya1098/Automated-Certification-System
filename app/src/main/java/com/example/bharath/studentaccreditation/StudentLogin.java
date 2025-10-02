package com.example.bharath.studentaccreditation;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentLogin extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    ImageButton reg,login;
    Spinner branch;
    EditText sid,pwd;
    String ubranch,usid,upwd;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        reg= (ImageButton) findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentReg.class);
                startActivity(intent);
            }
        });

        login= (ImageButton) findViewById(R.id.login);
        branch= (Spinner) findViewById(R.id.branch);
        sid= (EditText) findViewById(R.id.sid);
        pwd= (EditText) findViewById(R.id.pwd);

        usid=sid.getText().toString();
        upwd=pwd.getText().toString();

        branch.setOnItemSelectedListener(this);

        List<String> rname=new ArrayList<String>();

        rname.add("CSE");
        rname.add("ECE");
        rname.add("EEE");
        rname.add("CE");
        rname.add("ME");
        rname.add("IT");

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,rname);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(adp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sid.getText().toString().equals("") || pwd.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Invalid ID or password",Toast.LENGTH_LONG).show();
                }else{
                    db=openOrCreateDatabase("stuacc", SQLiteDatabase.CREATE_IF_NECESSARY,null);

                    Cursor c=db.rawQuery("select * from student where sid='"+sid.getText().toString()+"' and pwd='"+pwd.getText().toString()+"' and status='yes' ",null);
                    c.moveToFirst();
                    if(c!=null){
                        if(c.getCount()>0){
                            Intent i=new Intent(getApplicationContext(),StudentHome.class);
                            i.putExtra("sid",sid.getText().toString());
                            i.putExtra("branch",ubranch);
                            startActivity(i);

                        }else{
                            Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ubranch=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
