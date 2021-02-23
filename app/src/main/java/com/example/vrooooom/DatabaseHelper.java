package com.example.vrooooom;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.sql.Time;
import java.util.Date;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="car.db";
    public static final String TABLE_NAME="car_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="DATE";
    public static final String COL_4="TIME";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,DATE TEXT, TIME TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String Name, String Date, String Time){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2,Name);
        contentValues.put(COL_3,Date );
        contentValues.put(COL_4, Time);
        long result =db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }

    }
}
