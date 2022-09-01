package com.example.sendemail;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MainActivity extends AppCompatActivity {

    EditText editTextTo,editTextSubject,editTextMessage;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo = findViewById(R.id.editTextTo);
        editTextSubject = findViewById(R.id.editTextSubject);
        editTextMessage = findViewById(R.id.editTextMessage);

        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View view) {

                sendButton.setText("Sending...!");
                sendButton.setBackgroundColor(Color.GRAY);



                String fromEmail = "17amolgode@gmail.com";
                String password = "AmolGode@2000";

                String to = editTextTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = editTextMessage.getText().toString();

                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.ssl.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","465");

                javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail,password);
                    }
                });

                try {
                    MimeMessage mMsg = new MimeMessage(session);
//                    mMsg.setFrom(new InternetAddress("17amolgode@gmail.com"));
                    mMsg.setRecipient(Message.RecipientType.TO,new InternetAddress(fromEmail));
                    mMsg.setSubject(subject);
                    mMsg.setText(message);

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Transport.send(mMsg);

                                sendButton.setText("Send");
                                sendButton.setBackgroundColor(Color.GREEN);

                            } catch (MessagingException e) {
                                Toast.makeText(MainActivity.this, "Exception : ", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();

                }catch(MessagingException me)
                {
                    Toast.makeText(MainActivity.this, "Exception : ", Toast.LENGTH_SHORT).show();
                    me.printStackTrace();
                }catch(Exception e)
                {
                    System.out.println("Exception ================ > ");
                    Toast.makeText(MainActivity.this, "Exception : "+e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        });
    }
}