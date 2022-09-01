package com.example.sendmail2;

import androidx.appcompat.app.AppCompatActivity;

import javax.mail.*;
import java.util.Properties;

import android.os.Bundle;

import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        send_email();

    }

    void send_email()
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("17amolgode@gmail.com","AmolGode@2000");
            }
        });


        try {
            MimeMessage mMsg = new MimeMessage(session);
            String to = "17amolgode@gmail.com";
            mMsg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            mMsg.setText("Email app 2...!");
            mMsg.setSubject("This is email ap 2 sub");
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Transport.send(mMsg);
                    } catch (MessagingException e) {
                        System.out.println("Exception in herre1111111111");
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Exception in herre 2222");
        } catch (MessagingException e) {
            e.printStackTrace();

            System.out.println("Exception in her33333");
        }catch(Exception e)
        {
            System.out.println("Exception in herr44444");
            e.printStackTrace();
        }
    }
}