package com.example.chen.housecommittee_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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


    }
}
