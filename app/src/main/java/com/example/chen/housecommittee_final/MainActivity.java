package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        radiogroup.check(R.id.radioButton_tenant);

        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), Login.class);
                RadioButton isCommittee = (RadioButton) findViewById(R.id.radioButton_committee);
                loginIntent.putExtra("isCommittee", isCommittee.isChecked());
                startActivity(loginIntent);
            }
        });
    }
}
