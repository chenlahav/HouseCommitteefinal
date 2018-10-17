package com.example.chen.housecommittee_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TenantPayment extends AppCompatActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_payment);
        if(getIntent().getExtras() != null){
            id = getIntent().getExtras().getString("id");
            TextView nameTextView = findViewById(R.id.textView_tenant_payment);
            nameTextView.setText(id);

        }

        NumberPicker numberPicker = (NumberPicker)findViewById(R.id.monthNumberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(12);

        Button saveBtn =(Button)findViewById(R.id.SaveButton);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPicker numberPicker = (NumberPicker)findViewById(R.id.monthNumberPicker);
                EditText amountEditText = (EditText) findViewById(R.id.editText_amount);

                int month = numberPicker.getValue();
                int amountToPay = Integer.parseInt(amountEditText.getText().toString());

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference users = database.getReference("users");

                users.child(id).child("m_PaidPayments").child(Integer.toString(month-1)).child("m_Amount").
                        setValue(amountToPay);

            }
        });

    }
}
