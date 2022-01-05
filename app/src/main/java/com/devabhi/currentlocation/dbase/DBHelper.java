package com.devabhi.currentlocation.dbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "CurrentLocation.sql", null, DATABASE_VERSION);
    }

    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_LEDGER_TABLE = "create table tbl_location("
            + "lid integer primary key autoincrement, " +
            "latt text," +
            "longi text);";

    private static final String DROP_LED_TABLE = "drop table if exists tbl_location";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_LEDGER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_LED_TABLE);
        onCreate(sqLiteDatabase);
    }

    // Transaction entries
    public void saveToLocalDb(String latti, String longi, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("latt", latti);
        contentValues.put("longi", longi);
        database.insert("tbl_location", null, contentValues);
    }


}
