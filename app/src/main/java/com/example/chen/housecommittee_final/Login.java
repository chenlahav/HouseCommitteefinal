package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView forgetPassword = (TextView) findViewById(R.id.textView_forgot_password);
        forgetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(loginIntent);
            }
        });

        TextView createAccount = (TextView) findViewById(R.id.textView_create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), CreateAccount.class);
                startActivity(loginIntent);
            }
        });
    }
}
