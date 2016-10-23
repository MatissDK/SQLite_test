package com.ottodk.sqlite_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseConnection mDatabaseConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseConnection = new DatabaseConnection(getApplicationContext());

        boolean resultBoolean = mDatabaseConnection.insertData("Otto", "Kalns", 10);
        if (resultBoolean == true) {
            createToast("DONE");
        } else {
            createToast("FAIL");
        }
    }

    private void createToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
