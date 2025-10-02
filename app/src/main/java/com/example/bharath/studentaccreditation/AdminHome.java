package com.example.bharath.studentaccreditation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdminHome extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {

    Spinner branch;
    Button submit;
    String ubranch;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        submit= (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminView.class);
                intent.putExtra("ubranch", ubranch);
                startActivity(intent);
            }
        });

        logout= (TextView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
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
