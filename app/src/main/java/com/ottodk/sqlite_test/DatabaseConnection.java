package com.ottodk.sqlite_test;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnection extends SQLiteOpenHelper {


    //not case sensitive DB
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_table";

    private static final String COL_1_ID = "ID";
    private static final String COL_2_NAME = "NAME";
    private static final String COL_3_SURNANAME = "SURNAME";
    private static final String COL_2_MARKS = "MARKS";

    //when constructor is called = DB is created
    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    //creates table when onCreate is called
    @Override
    public void onCreate(SQLiteDatabase db) {
        //executes query and creates table
        db.execSQL("CREATE TABLE " +  TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT," +
                "MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }


}


