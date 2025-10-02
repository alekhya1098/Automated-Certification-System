package com.example.bharath.studentaccreditation;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;

public class DBconnector extends SQLiteOpenHelper {

    public DBconnector(Context context) {
        super(context, "stuacc", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="create table if not exists student (id integer primary key autoincrement,name text,email text,pwd text,sid text," +
                "phn text,dob text,branch text,status text)";
        db.execSQL(sql);
        String sql1="create table if not exists certificate (id integer primary key autoincrement,sid text,branch text,cname text,reason text,status text)";
        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table student if exits");
        db.execSQL("drop table certificate if exits");
        onCreate(db);

    }

    public void insert_student(HashMap<String,String> map){
        SQLiteDatabase sb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",map.get("name"));
        cv.put("email",map.get("email"));
        cv.put("pwd",map.get("pwd"));
        cv.put("sid",map.get("sid"));
        cv.put("phn",map.get("phn"));
        cv.put("dob",map.get("dob"));
        cv.put("branch", map.get("branch"));
        cv.put("status", map.get("status"));
        sb.insert("student", null, cv);
    }

    public void insert_certificate(HashMap<String,String> map){
        SQLiteDatabase sb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("sid",map.get("sid"));
        cv.put("branch",map.get("branch"));
        cv.put("cname",map.get("cname"));
        cv.put("reason",map.get("reason"));
        cv.put("status",map.get("status"));
        sb.insert("certificate",null,cv);
    }

}
