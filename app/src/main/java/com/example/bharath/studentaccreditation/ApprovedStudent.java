package com.example.bharath.studentaccreditation;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ApprovedStudent extends ListActivity {

    ArrayList<String> result=new ArrayList<String>();
    private SQLiteDatabase newDB;
    int i=0;
    String name,email,sid,ubranch,content,phn,dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ubranch=getIntent().getStringExtra("ubranch");

        openAndQueryDatabase();
        displayResultList();


    }

    private void displayResultList() {

        TextView tView=new TextView(this);
        tView.setText("Students");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
        final ListView lv=getListView();
        lv.setTextFilterEnabled(true);

            }


            private void openAndQueryDatabase() {


                DBconnector dbHelper = new DBconnector(this.getApplicationContext());
                newDB = dbHelper.getWritableDatabase();
                Cursor c = newDB.rawQuery(" select * from student where status='yes' and branch='" + ubranch + "' ", null);
                if (c != null) {

                    if (c.moveToFirst()) {

                        do {
                            name = c.getString(c.getColumnIndex("name"));
                            email = c.getString(c.getColumnIndex("email"));
                            sid = c.getString(c.getColumnIndex("sid"));
                            phn = c.getString(c.getColumnIndex("phn"));
                            dob = c.getString(c.getColumnIndex("dob"));

                            content = "Name: " + name + "\nEmail ID:" + email + "\nID No:" + sid + "\nPhone:" + phn + "\nDOB:" + dob;
                            result.add(content);

                        } while (c.moveToNext());

                    }

                }

            }


        }
