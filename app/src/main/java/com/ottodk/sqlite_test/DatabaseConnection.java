package com.ottodk.sqlite_test;


import android.content.ContentValues;
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
    private static final String COL_4_MARKS = "MARKS";

    //when constructor is called = DB is created
    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    //creates table when onCreate is called
    @Override
    public void onCreate(SQLiteDatabase db) {
        //executes query and creates table
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT," +
                "MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }


    // returns boolean when update is done
    public boolean updateData(String id, String name, String surname, int mark) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1_ID,id);
        contentValues.put(COL_2_NAME,name);
        contentValues.put(COL_3_SURNANAME,surname);
        contentValues.put(COL_4_MARKS,mark);

        long result = db.update(TABLE_NAME,contentValues,"id = ?",new String[]{ id });
        return true;
    }

}


