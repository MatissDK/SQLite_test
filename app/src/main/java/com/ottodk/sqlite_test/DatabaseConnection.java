package com.ottodk.sqlite_test;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnection extends SQLiteOpenHelper {


    private static final String DB_NAME = "student.db";
    private static final String TABLE_NAME = "student_table";

    private static final String COL_1_ID = "ID";
    private static final String COL_2_NAME = "NAME";
    private static final String COL_3_SURNANAME = "SURNAME";
    private static final String COL_2_MARKS = "MARKS";

    public DatabaseConnection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


