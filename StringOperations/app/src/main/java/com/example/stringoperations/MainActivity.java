package com.example.stringoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButtonToUpper,radioButtonToLower,radioButtonRight5,radioButtonLeft5;
    Button clickButton;
    EditText editTextString,editTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        editTextString = findViewById(R.id.editTextString);
        editTextResult = findViewById(R.id.editTextResult);
//        radioButtonToUpper = findViewById(R.id.radioButtonToUpper);
//        radioButtonToLower = findViewById(R.id.radioButtonToLower);
//        radioButtonLeft5 = findViewById(R.id.radioButtonLeft5);
//        radioButtonRight5 = findViewById(R.id.radioButtonRight5);

        clickButton = findViewById(R.id.clickButton);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedButtonId = radioGroup.getCheckedRadioButtonId();
                String str = editTextString.getText().toString();
                String res = "";
                int len = str.length();
                if(checkedButtonId == R.id.radioButtonToUpper)
                {
                    res = str.toUpperCase();
                }else if(checkedButtonId == R.id.radioButtonToLower)
                {
                    res = str.toLowerCase();
                }else if(checkedButtonId == R.id.radioButtonLeft5)
                {
                    if(len >= 5)
                    {
                        res = str.substring(0, 5);
                    }else
                    {
                        res = str;
                    }
                }else if(checkedButtonId == R.id.radioButtonRight5)
                {
                    if(len >= 5) {
                        res = str.substring(len - 5);
                    }else
                    {
                        res = str;
                    }
                }
                editTextResult.setText(res);
            }
        });
    }
}