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
import android.widget.Toast;

import java.util.ArrayList;

public class ViewBonafide extends ListActivity {

    ArrayList<String> result=new ArrayList<String>();
    private SQLiteDatabase newDB;
    String cname,reason,sid,ubranch,content,cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ubranch=getIntent().getStringExtra("ubranch");

        openAndQueryDatabase();
        displayResultList();

    }

    private void displayResultList() {

        TextView tView=new TextView(this);
        tView.setText("Approve Bonafides");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
        final ListView lv=getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, final long id) {
                /*Intent intent=new Intent(UserViewEvents.this,AdminComplaint1.class);
                String uid=(String)(lv.getItemAtPosition(position));
                intent.putExtra("uid",uid);
                i++;
                startActivity(intent);*/


                AlertDialog.Builder dialog = new AlertDialog.Builder(ViewBonafide.this);
                dialog.setCancelable(false);
                dialog.setTitle(getResources().getString(R.string.app_name));
                dialog.setMessage("Do you want to approve");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent anotherActivityIntent = new Intent(getApplicationContext(), BonafideYes.class);
                        anotherActivityIntent.putExtra("cid", cid);
                        startActivity(anotherActivityIntent);

                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent anotherActivityIntent = new Intent(getApplicationContext(), ViewBonafide.class);
                        anotherActivityIntent.putExtra("ubranch", ubranch);
                        startActivity(anotherActivityIntent);

                    }
                });
                dialog.show();


            }
        });
    }


    private void openAndQueryDatabase() {


        DBconnector dbHelper=new DBconnector(this.getApplicationContext());
        newDB=dbHelper.getWritableDatabase();
        Cursor c=newDB.rawQuery(" select * from certificate where status='Waiting' and branch='"+ubranch+"' and cname='Bonafide' ",null);
        if(c!=null){

            if(c.moveToFirst()){

                do{
                    cid=c.getString(c.getColumnIndex("id"));
                    sid=c.getString(c.getColumnIndex("sid"));
                    cname=c.getString(c.getColumnIndex("cname"));
                    reason=c.getString(c.getColumnIndex("reason"));

                    content="ID: "+cid+"\nStudent ID: "+sid+"\nName: "+cname+"\nReason:"+reason;
                    result.add(content);

                }while (c.moveToNext());

            }

        }

    }


}
