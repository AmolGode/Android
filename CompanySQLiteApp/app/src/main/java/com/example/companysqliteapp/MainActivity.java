package com.example.companysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dh = new DbHelper(this);

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        dh.insert();
        dh.getData();
    }
}