package com.example.cutomersqlitedata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextAddress,editTextID,editTextPersonName,editTextPhone;
    Button saveButton,loadAllButton;
    DbHelper DH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DH = new DbHelper(this);

        editTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextID = findViewById(R.id.editTextID);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        saveButton = findViewById(R.id.saveButton);
        loadAllButton = findViewById(R.id.loadAllButton);



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = editTextID.getText().toString();
                String personName = editTextPersonName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String address = editTextAddress.getText().toString();

                if(DH.insertCustomer(id,personName,address,phone))
                {
                    Toast.makeText(MainActivity.this, "Data inserted successfully..!", Toast.LENGTH_SHORT).show();
                    editTextID.setText("");
                    editTextPersonName.setText("");
                    editTextPhone.setText("");
                    editTextAddress.setText("");
                }else
                {
                    Toast.makeText(MainActivity.this, "Data Insertion failed...!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loadAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                Cursor cur = DH.getAllCustomer();
                try {
                    int count = cur.getCount();
                    if (count > 0) {
                        cur.moveToFirst();
                        do {
                            sb.append("Id = " + cur.getString(0) + "\n");
                            sb.append("Name = " + cur.getString(1) + "\n");
                            sb.append("Phone Number = " + cur.getString(2) + "\n");
                            sb.append("Address = " + cur.getString(3) + "\n");
                            sb.append("------------------------------------\n");
                        } while (cur.moveToNext());
                    }
                    }finally{
                        cur.close();
                    }


                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("Customer Details");
                builder.setMessage(sb);
                builder.show();
            }
        });



    }


}