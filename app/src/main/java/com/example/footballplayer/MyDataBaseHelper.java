package com.example.footballplayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context ctx;
    private static final String db_name="dbfootball";
    private static final int db_version=1;
    private static final String tb_name="tb_player";
    private static final String feild_id="id";
    private static final String feild_nama="nama";
    private static final String feild_nomor="nomor";
    private static final String feild_klub="klub";


    public MyDataBaseHelper(@Nullable Context context) {
        super(context,db_name,null,db_version);
        this.ctx=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="Create table "+tb_name+"("+feild_id+" INTERGER PRIMARY KEY AUTOINCREMENT,"+feild_nama +" VARCHAR(50), "+feild_nomor+" VARCHAR(2), "+ feild_klub +" VARCHAR(50) " +");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
