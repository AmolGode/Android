package com.example.cutomersqlitedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

        public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "customer.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table customer(id TEXT,name TEXT,phone TEXT,address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists customer");
        onCreate(DB);
    }

    public boolean insertCustomer(String id,String name,String address,String number)
    {

        SQLiteDatabase DB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("address",address);
        contentValues.put("phone",number);


        int res = (int) DB.insert("customer",null,contentValues);

        if(res != -1)
        {
            System.out.println("data inserted of"+name);
            return true;
        }else
        {
            return false;
        }
    }

    public Cursor getAllCustomer()
    {
        SQLiteDatabase DB = getReadableDatabase();
        String col[] = {"id","name","phone","address"};
        Cursor cursor = DB.query("customer",col,null,null,null,null,null);
        return cursor;
    }
}
