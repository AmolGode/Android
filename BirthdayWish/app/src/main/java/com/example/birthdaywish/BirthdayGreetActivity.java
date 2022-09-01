package com.example.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BirthdayGreetActivity extends AppCompatActivity {

    TextView birthdayGreetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_greet);

        birthdayGreetTextView = findViewById(R.id.birthdayGreetTextView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("person_name");

        birthdayGreetTextView.setText("Many many happy returns of the day "+name+" Bro...!");
    }
}
