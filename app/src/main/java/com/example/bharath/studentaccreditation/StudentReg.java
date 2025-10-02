package com.example.bharath.studentaccreditation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentReg extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    Button reg;
    Spinner branch;
    EditText name,email,pwd,sid,phn,dob;
    String ubranch,uname,uemail,upwd,usid,uphn,udob;
    String status="no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);

        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        pwd= (EditText) findViewById(R.id.pwd);
        sid= (EditText) findViewById(R.id.sid);
        phn= (EditText) findViewById(R.id.phn);
        dob= (EditText) findViewById(R.id.dob);

        uname=name.getText().toString();
        uemail=email.getText().toString();
        upwd=pwd.getText().toString();
        usid=sid.getText().toString();
        uphn=phn.getText().toString();
        udob=dob.getText().toString();

        reg= (Button) findViewById(R.id.reg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("") || email.getText().toString().equals("") || pwd.getText().toString().equals("")
                        || sid.getText().toString().equals("") || phn.getText().toString().equals("") || dob.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_LONG).show();
                }else{


                    DBconnector dbc=new DBconnector(getApplicationContext());

                    HashMap<String,String> map=new HashMap<String , String >();
                    map.put("name",name.getText().toString());
                    map.put("email", email.getText().toString());
                    map.put("pwd", pwd.getText().toString());
                    map.put("sid", sid.getText().toString());
                    map.put("phn", phn.getText().toString());
                    map.put("dob", dob.getText().toString());
                    map.put("branch", ubranch);
                    map.put("status", status);

                    dbc.insert_student(map);

                    Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_LONG).show();

                    Intent i=new Intent(getApplicationContext(),StudentLogin.class);
                    startActivity(i);
                }
            }
        });

        branch= (Spinner) findViewById(R.id.branch);

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
