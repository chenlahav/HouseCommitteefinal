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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ConcurrentModificationException;

import model.Committee;
import model.Resident;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Boolean isCommittee = false;
        if(getIntent().getExtras() != null)
            isCommittee = getIntent().getExtras().getBoolean("isCommittee");
        if(isCommittee){
            EditText aptNum = (EditText) findViewById(R.id.editText_apt_num);
            aptNum.setVisibility(View.GONE);
            EditText payment = (EditText) findViewById(R.id.editText_paymant);
            payment.setVisibility(View.GONE);
        }
        else{
            EditText seniority = (EditText) findViewById(R.id.editText_seniority);
            seniority.setVisibility(View.GONE);
        }

        // onClick Create Account
        Button createAccount = (Button) findViewById(R.id.createAccaountBtn);
        createAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Boolean isCommittee = false;
                if(getIntent().getExtras() != null)
                    isCommittee = getIntent().getExtras().getBoolean("isCommittee");

                EditText nameEditText = (EditText) findViewById(R.id.editText_name);
                String name = nameEditText.getText().toString();

                EditText lastNameEditText = (EditText) findViewById(R.id.editText_last_name);
                String lastName = lastNameEditText.getText().toString();

                EditText idEditText = (EditText) findViewById(R.id.editText_id);
                String id = idEditText.getText().toString();

                EditText passwordEditText = (EditText) findViewById(R.id.editText_password);
                String password = passwordEditText.getText().toString();

                EditText EmailEditText = (EditText) findViewById(R.id.editText_email);
                String email = EmailEditText.getText().toString();

                if(isCommittee){

                    EditText seniorityEditText = (EditText) findViewById(R.id.editText_seniority);
                    int seniority  = Integer.parseInt(seniorityEditText.getText().toString());

                    Committee newCommittee = new Committee(name,lastName,id,seniority);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference users = database.getReference("users");
                    users.child(id).setValue(newCommittee);

                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.createUserWithEmailAndPassword(email,password);
                }
                else{
                    EditText aptNumEditText = (EditText) findViewById(R.id.editText_apt_num);
                    int aptNum = Integer.parseInt(aptNumEditText.getText().toString());

                    EditText paymentEditText = (EditText) findViewById(R.id.editText_paymant);
                    int payment = Integer.parseInt(paymentEditText.getText().toString());

                    Resident newResident = new Resident(name, lastName, id, aptNum, payment);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference users = database.getReference("users");
                    users.child(id).setValue(newResident);

                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent createAccountIntent = new Intent(getApplicationContext(), Login.class);
                                startActivity(createAccountIntent);
                            }
                            else
                            {
                                CharSequence text = task.getException().getMessage();
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                                toast.show();
                            }
                        }
                    });
                }

            }
        });
    }
}
