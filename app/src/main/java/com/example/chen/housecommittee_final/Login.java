package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

                //email validation
                String email = ((TextView) findViewById(R.id.editText_email)).getText().toString();
                if(email.isEmpty())
                {
                    CharSequence text = "email is empty!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
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

                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(email, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
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
                        else{
                            CharSequence text = task.getException().getMessage();
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                            toast.show();
                        }
                    }
                });
            }
        });
    }
}
