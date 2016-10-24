package com.ottodk.sqlite_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseConnection mDatabaseConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseConnection = new DatabaseConnection(getApplicationContext());
        delete();
    }

    private void delete() {
        int isDeleted = mDatabaseConnection.deleteData("10");
        if (isDeleted > 0) {
            createToast("DONE");
        } else {
            createToast("PROBLEM");
        }
    }

    private void createToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }


}
