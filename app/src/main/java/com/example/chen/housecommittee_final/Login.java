package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // onClick forget password
        TextView forgetPassword = (TextView) findViewById(R.id.textView_forgot_password);
        forgetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent forgetPasswordIntent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(forgetPasswordIntent);
            }
        });

        // onClick sign up
        TextView createAccount = (TextView) findViewById(R.id.textView_create_account);
        createAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent CreateAccountIntent = new Intent(getApplicationContext(), CreateAccount.class);
                Boolean isCommittee = false;
                if(getIntent().getExtras() != null)
                    isCommittee = getIntent().getExtras().getBoolean("isCommittee");
                CreateAccountIntent.putExtra("isCommittee", isCommittee);
                startActivity(CreateAccountIntent);
            }
        });

        //onClick Login button
        Button loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //$validation$

                //apartement validation
                try {
                    int apartmentNumber = Integer.parseInt(((TextView) findViewById(R.id.editText_aprt_num)).getText().toString());
                    if ((!((1 <= apartmentNumber) && (apartmentNumber <= 100)))) {
                        CharSequence text = "Invalid apartment!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                        toast.show();
                        return;
                    }
                }
                catch(Exception exception){
                    return;
                }

                //password validation
                String passwordText= ((TextView)findViewById(R.id.editText_password)).getText().toString();
                if(passwordText.length()<=0){
                    CharSequence text = "Invalid password!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                    return;
                }

                Boolean isCommittee = false;
                if(getIntent().getExtras() != null)
                    isCommittee = getIntent().getExtras().getBoolean("isCommittee");

                if(isCommittee) {
                    Intent homeCommitteeIntent = new Intent(getApplicationContext(), HomeCommittee.class);
                    startActivity(homeCommitteeIntent);
                }
                else{
                    Intent homeTenantIntent = new Intent(getApplicationContext(), HomeTenant.class);
                    startActivity(homeTenantIntent);
                }
            }
        });
    }
}
