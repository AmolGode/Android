package com.example.numberarmstrogperfect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    RadioGroup radioGroup;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        radioGroup = findViewById(R.id.radioGroup);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                int num = Integer.parseInt(editTextNumber.getText().toString());

                if(selectedId == R.id.radioButtonArmstrong)
                {
                    int res = 0;
                    int tempNum = num;
                    while(tempNum != 0)
                    {
                        int rem = tempNum % 10;
                        res += Math.pow(rem,3);
                        tempNum = tempNum /10;
                    }
                    if(res == num)
                    {
                        resultTextView.setText(num+" is Armsttrong number..!");
                    }else
                    {
                        resultTextView.setText(num+" is NOT Armsttrong number..!");
                    }

                }else
                {
                    int sumOfProperDivisor = 1;

                    for(int i = 2; i  < num ; i++)
                    {
                        if(num % i == 0)
                        {
                            sumOfProperDivisor += i;
                        }
                    }

                    if(sumOfProperDivisor == num)
                    {
                        resultTextView.setText(num+" is Perfect number..!");
                    }else
                    {
                        resultTextView.setText(num+" is NOT Perfect number..!");
                    }
                }
            }
        });
    }
}