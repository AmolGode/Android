package com.example.loginvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmailAddress,editTextPassword;
    TextView textView;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pattern PASSWORD_PATTERN = Pattern.compile("^" + //endicate start of regx
                        "(?=.*[0-9])" + // atleast one digit
                        "(?=.*[a-z])" + // atleast one lowercase
                        "(?=.*[A-Z])" +  // atleast one uppercase
                        "(?=.*[!@#$&%^+=])" + // // atleast one special character
                        "(?=\\S+$)" + // No whilte spaces
                        ".{8,}" + // atleast 8 length
                        "$");  //endicate end of regx
                String emailAddress = editTextEmailAddress.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                boolean flag = true;

                if(emailAddress.length() == 0)
                {
                    flag = false;
                    editTextEmailAddress.setError("Empty Email is not valid..!");
                }else if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches())
                {
                    flag = false;
                    editTextEmailAddress.setError("Invalid email address pattern..!");
                }else if(emailAddress.lastIndexOf(".com") == -1)
                {
                    flag = false;
                    editTextEmailAddress.setError("Invalid email address...!");
                }else if(emailAddress.indexOf(".") == -1)
                {
                    flag = false;
                    editTextEmailAddress.setError("Invalid email address...!");
                }

                if(password.length() == 0)
                {
                    flag = false;
                    editTextPassword.setError("Password should not be empty...!");
                }else if(!PASSWORD_PATTERN.matcher(password).matches())
                {
                    flag = false;
                    editTextPassword.setError("Invalid Password...!");
                }

                if(flag)
                {
                    Toast.makeText(MainActivity.this, "Valid Input...!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}