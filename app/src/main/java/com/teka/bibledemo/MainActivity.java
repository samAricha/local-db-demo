package com.teka.bibledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    DBHelper dbhelper;
    String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.pwdTxtView);
        //involves setting up the db i.e creating and opening the db
        setup();

        txtView.setText(pwd);
    }

    private void setup() {
        dbhelper = new DBHelper(getApplicationContext());

        //we first of all create the database if not yet created.
        try {
            dbhelper.createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //we then open the db.
        try {
            dbhelper.openDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        pwd = dbhelper.getPwd("samson");
    }
}