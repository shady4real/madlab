package com.varshith.haiihdhdhd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button sign;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText uname = (EditText)findViewById(R.id.username);
        EditText pass = (EditText)findViewById(R.id.password);
        sign = (Button) findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < 2) {
                    String username = uname.getText().toString();
                    String password = pass.getText().toString();


                    Intent intent = getIntent();
                    Bundle extras = intent.getExtras();
                    String username_string = extras.getString("EXTRA_USERNAME");
                    String password_string = extras.getString("EXTRA_PASSWORD");

                    if (username.equals(username_string) == true && password.equals(password_string) == true) {
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        count++;
                    }


                }
                else{
                    Toast.makeText(getApplicationContext(), "Too Many Login Attempt please try again later", Toast.LENGTH_SHORT).show();
                    sign.setEnabled(false);
                }
            }
        });
    }
}

//  uname = (TextView) findViewById(R.id.textView2);
//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();
//        String username_string = extras.getString("EXTRA_USERNAME");
//        String password_string = extras.getString("EXTRA_PASSWORD");
//        uname.setText(username_string);

