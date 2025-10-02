package com.example.bharath.studentaccreditation;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentStatus extends ListActivity {

    ArrayList<String> result=new ArrayList<String>();
    private SQLiteDatabase newDB;
    int i=0;
    String sid,branch,cname,reason,status,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sid=getIntent().getStringExtra("sid");
        branch=getIntent().getStringExtra("branch");

        openAndQueryDatabase();
        displayResultList();

    }

    private void displayResultList() {

        TextView tView=new TextView(this);
        tView.setText("Certificate Status");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
        final ListView lv=getListView();
        lv.setTextFilterEnabled(true);

       /* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(AdminComplaint.this,AdminComplaint1.class);
                String uid=(String)(lv.getItemAtPosition(position));
                intent.putExtra("uid",uid);
                i++;
                startActivity(intent);
            }
        }); */

    }

    private void openAndQueryDatabase() {


        DBconnector dbHelper=new DBconnector(this.getApplicationContext());
        newDB=dbHelper.getWritableDatabase();
        Cursor c=newDB.rawQuery(" select * from certificate where sid='"+sid+"' ",null);
        if(c!=null){

            if(c.moveToFirst()){

                do{
                    cname=c.getString(c.getColumnIndex("cname"));
                    reason=c.getString(c.getColumnIndex("reason"));
                    status=c.getString(c.getColumnIndex("status"));

                    content="Name: "+cname+"\nReason:"+reason+"\nStatus:"+status;
                    result.add(content);

                }while (c.moveToNext());

            }

        }

    }


}
