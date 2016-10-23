package com.ottodk.sqlite_test;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseConnection mDatabaseConnection;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseConnection = new DatabaseConnection(getApplicationContext());
        mTextView = (TextView) findViewById(R.id.textBox);

        Cursor data = mDatabaseConnection.getAllData();
        if (data.getCount() == 0) {
            createToast("NO DATA AVAILABLE");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while (data.moveToNext()) {
                stringBuffer.append("ID :" + data.getString(0) + "\n");
                stringBuffer.append("NAME :" + data.getString(1) + "\n");
                stringBuffer.append("SURNAME :" + data.getString(2) + "\n");
                stringBuffer.append("MARK :" + data.getString(3) + "\n");
            }
            showMessage(stringBuffer.toString());
        }

    }

    private void createToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    private void showMessage(String message) {
        mTextView.setText( message);
    }
}
