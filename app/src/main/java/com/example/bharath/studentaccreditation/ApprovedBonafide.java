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

public class ApprovedBonafide extends ListActivity {

    ArrayList<String> result=new ArrayList<String>();
    private SQLiteDatabase newDB;
    int i=0;
    String cname,reason,sid,ubranch,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ubranch=getIntent().getStringExtra("ubranch");

        openAndQueryDatabase();
        displayResultList();

    }

    private void displayResultList() {

        TextView tView=new TextView(this);
        tView.setText("Bonafide");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
        final ListView lv=getListView();
        lv.setTextFilterEnabled(true);


    }


    private void openAndQueryDatabase() {


        DBconnector dbHelper=new DBconnector(this.getApplicationContext());
        newDB=dbHelper.getWritableDatabase();
        Cursor c=newDB.rawQuery(" select * from certificate where status='Approved' and branch='"+ubranch+"' and cname='Bonafide' ",null);
        if(c!=null){

            if(c.moveToFirst()){

                do{
                    sid=c.getString(c.getColumnIndex("sid"));
                    cname=c.getString(c.getColumnIndex("cname"));
                    reason=c.getString(c.getColumnIndex("reason"));

                    content="Student ID: "+sid+"\nName: "+cname+"\nReason:"+reason;
                    result.add(content);

                }while (c.moveToNext());

            }

        }

    }


}
