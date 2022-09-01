package com.example.stringformatusingcheckboxandradio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextName,editTextMessage;
    CheckBox checkBoxBold,checkBoxItalic,checkBoxUnderline;
    RadioGroup radioGroupColor;
    Button buttonDisplayMessage,buttonClear, buttonExit;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName1);
        editTextMessage = findViewById(R.id.editTextMessage1);
        checkBoxBold = findViewById(R.id.checkBoxBold);
        checkBoxItalic = findViewById(R.id.checkBoxItalic);
        checkBoxUnderline = findViewById(R.id.checkBoxUnderline);
        radioGroupColor = findViewById(R.id.radioGroupColor);
        buttonDisplayMessage = findViewById(R.id.buttonDisplayMessage);
        buttonClear = findViewById(R.id.buttonClear);
        buttonExit = findViewById(R.id.buttonExit);
        textViewResult = findViewById(R.id.textViewResult);

        buttonDisplayMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String message = editTextMessage.getText().toString();
                String finalMessage = message+" "+name;

                textViewResult.setTypeface(null);

                if(checkBoxUnderline.isChecked())
                {
                    textViewResult.setText(Html.fromHtml("<u>"+finalMessage+"</u>"));
                }else
                {
                    textViewResult.setText(finalMessage);
                }

                if(checkBoxBold.isChecked())
                {
                    textViewResult.setTypeface(null, Typeface.BOLD);
                }
                if(checkBoxItalic.isChecked())
                {
                    if(checkBoxBold.isChecked())
                    {
                        textViewResult.setTypeface(null,Typeface.BOLD_ITALIC);
                    }else
                    {
                        textViewResult.setTypeface(null, Typeface.ITALIC);
                    }
                }

                int selectedRadio = radioGroupColor.getCheckedRadioButtonId();
                if(selectedRadio == R.id.radioButtonBlue)
                {
                    textViewResult.setTextColor(Color.BLUE);
                }else if(selectedRadio == R.id.radioButtonGreen)
                {
                    textViewResult.setTextColor(Color.GREEN);
                }if(selectedRadio == R.id.radioButtonRed)
                {
                    textViewResult.setTextColor(Color.RED);
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResult.setTypeface(null);
                textViewResult.setText("");
                textViewResult.setTextColor(Color.BLACK);

                radioGroupColor.clearCheck();
                checkBoxItalic.setChecked(false);
                checkBoxBold.setChecked(false);
                checkBoxUnderline.setChecked(false);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}