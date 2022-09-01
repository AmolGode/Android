package com.example.companysqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    Context c;

    public DbHelper(@Nullable Context context) {
        super(context, "customerDB.db", null, 1);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table customer(id TEXT,name TEXT)");
//        DB.execSQL("drop table if exists customer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists customer");
    }

    void insert()
    {
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id","121");
        cv.put("name","Amol");

        DB.insert("customer",null,cv);
    }

    void getData()
    {
        SQLiteDatabase DB = getReadableDatabase();
        String col[] = {"id","name"};
        Cursor cur = DB.query("customer",col,null,null,null,null,null);
        try {
            StringBuilder sb = new StringBuilder();
            cur.moveToFirst();
            do {
                sb.append(cur.getString(0) + " ");
                sb.append(cur.getString(1) + " ");
                System.out.println("\n\n\n"+sb+"\n\n\n");
            } while (cur.moveToNext());

            Toast.makeText(c, sb, Toast.LENGTH_SHORT).show();
            System.out.println("\n\nData === \n\n");
            System.out.println("\n\n\n"+sb+"\n\n\n");
        }
        catch(Exception ex)
            {

                System.out.println("\n\n Exception == "+ex);
                Toast.makeText(c, "Exceptio "+ex, Toast.LENGTH_SHORT).show();
            }

    }
}
