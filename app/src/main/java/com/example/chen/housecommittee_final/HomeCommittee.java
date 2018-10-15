package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeCommittee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_committee);

        Button update_tenant_payment = (Button) findViewById(R.id.button_update_tenant_payment);
        update_tenant_payment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent updateTenantPaymentIntent = new Intent(getApplicationContext(), ListOfTenant.class);
                startActivity(updateTenantPaymentIntent);
            }
        });
    }
}
