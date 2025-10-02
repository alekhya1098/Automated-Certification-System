package com.example.bharath.studentaccreditation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentApply extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {

    EditText reason;
    Button submit;
    Spinner cname;
    String ucname,ureason,sid,branch,status="Waiting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_apply);

        sid=getIntent().getStringExtra("sid");
        branch=getIntent().getStringExtra("branch");

        reason= (EditText) findViewById(R.id.reason);
        submit= (Button) findViewById(R.id.submit);
        cname= (Spinner) findViewById(R.id.cname);

        ureason=reason.getText().toString();

        cname.setOnItemSelectedListener(this);
        List<String> rname=new ArrayList<String>();
        rname.add("Bonafide");
        rname.add("Bus Pass");
        rname.add("ID Card");
        rname.add("Memo");
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,rname);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cname.setAdapter(adp);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reason.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter all fields",Toast.LENGTH_LONG).show();
                }else{
                    DBconnector dbc=new DBconnector(getApplicationContext());

                    HashMap<String,String> map=new HashMap<String , String >();
                    map.put("sid",sid);
                    map.put("branch", branch);
                    map.put("cname", ucname);
                    map.put("reason", reason.getText().toString());
                    map.put("status", status);

                    dbc.insert_certificate(map);

                    Toast.makeText(getApplicationContext(),"Successfully Applied",Toast.LENGTH_LONG).show();

                    Intent i=new Intent(getApplicationContext(),StudentHome.class);
                    i.putExtra("sid",sid);
                    i.putExtra("branch",branch);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ucname=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
