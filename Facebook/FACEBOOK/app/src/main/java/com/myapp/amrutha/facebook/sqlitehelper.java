package com.myapp.amrutha.facebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by amrutha on 19-03-2017.
 */
public class sqlitehelper  extends SQLiteOpenHelper{

    private SQLiteDatabase db;
    String  password;

    public sqlitehelper(MainActivity mainActivity, Object o, Context context, int i) {
        super(context,"facebook", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table tbl_facebook(email text ,pass text)");
        }
        catch(SQLException e)
        {
            Log.d("error in creating table", e.getLocalizedMessage().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tbl_facebook");
        onCreate(db);

    }
    public boolean insertdetails(String emailid,String password )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long result=-1;
        ContentValues mycontent=new ContentValues();
        mycontent.put("email",emailid);
        mycontent.put("pass", password);
        try
        {
            result=db.insert("tbl_facebook",null,mycontent);
        }
        catch(SQLException e)
        {
            Log.d("message",e.getLocalizedMessage().toString());
        }
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public String authenticationUser(String emailid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from tbl_facebook where email='" + emailid + "'", null);
        System.out.println(res.getCount());
        if(res.getCount()==0)
        {
           res.close();
            return "not exists";
        }
        if( res != null && res.moveToFirst() ){
            password= res.getString(res.getColumnIndex("pass"));
        }
        return password;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from tbl_facebook",null);
        return res;
    }
}
