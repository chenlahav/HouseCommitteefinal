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

        Button view_all_payments = (Button) findViewById(R.id.button_all_payment);
        view_all_payments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewAllPaymentsIntent = new Intent(getApplicationContext(), AllPyamentsInTheBuilding.class);
                startActivity(viewAllPaymentsIntent);
            }
        });

        Button update_tenant_payment = (Button) findViewById(R.id.button_update_tenant_payment);
        update_tenant_payment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent updateTenantPaymentIntent = new Intent(getApplicationContext(), ListOfTenantToUpdate.class);
                startActivity(updateTenantPaymentIntent);
            }
        });

        Button updateProviderDetails = (Button)findViewById(R.id.button_update_provider_details);
        updateProviderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createProvider = new Intent(getApplicationContext(), CreateProvider.class);
                startActivity(createProvider);
            }
        });
    }
}
