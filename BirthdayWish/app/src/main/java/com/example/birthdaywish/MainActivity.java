package com.example.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button create_btn;
    EditText name_text_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_btn = findViewById(R.id.create_btn);
        name_text_box = findViewById(R.id.name_text_box);


//        create_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = name_text_box.getText().toString();
//                Toast.makeText(MainActivity.this, "Hello "+name, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void go_to_greeting_activity(View view) {
        String name = name_text_box.getText().toString();
        Toast.makeText(this, "The name is : "+name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,BirthdayGreetActivity.class);
        intent.putExtra("person_name",name);
        startActivity(intent);
    }
}