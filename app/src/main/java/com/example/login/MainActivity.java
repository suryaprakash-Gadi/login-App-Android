package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
;


import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    TextView login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        final String TAG="MainActivity";

        // Correct Firebase Database reference
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("your path");


        login =(TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=(EditText) findViewById(R.id.username);
                password=(EditText) findViewById(R.id.password);
                if(!check())
                {
                    Toast.makeText(MainActivity.this, "enter chesii dengichu ko firsxt erripukaa ", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onClick: enter chesii dengichu ko firsxt erripukaa  ");
                    return;
                }

                reference.child("userDetails").child("userName").setValue(username.getText().toString());
                reference.child("userDetails").child("password").setValue(password.getText().toString());
                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private boolean check() {
        if(username.getText().toString().equals(""))
        {
            return  false;
        }
        if(password.getText().toString().equals(""))
        {
            return  false;
        }
        return true;
    }

}