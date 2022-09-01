package com.example.viewdemostration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText playerName,score;
    Button clickButton,clearButton;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerName = findViewById(R.id.playerName);
        score = findViewById(R.id.score);
        clickButton = findViewById(R.id.clickButton);
        resultView = findViewById(R.id.resultView);
        clearButton = findViewById(R.id.clearButton);


        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pName = playerName.getText().toString();
                String sc = score.getText().toString();


                resultView.setText("player Name : "+pName+"\nScore : "+sc);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("pName",pName);
                intent.putExtra("score",sc);

                startActivity(intent);


            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerName.setText("");
                score.setText("");
                resultView.setText("");
            }
        });

    }
}