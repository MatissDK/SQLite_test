package com.ottodk.sqlite_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseConnection mDatabaseConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseConnection = new DatabaseConnection(getApplicationContext());
    }
}
