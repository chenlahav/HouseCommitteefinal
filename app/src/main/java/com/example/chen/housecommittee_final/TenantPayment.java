package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TenantPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_payment);

        Intent currentIntent = getIntent();
        long id  = currentIntent.getIntExtra("id",-1);
        TextView nameTextView = findViewById(R.id.TenantNametextView);
        nameTextView.setText("hello world");

    }
}
