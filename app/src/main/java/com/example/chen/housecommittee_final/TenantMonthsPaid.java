package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import model.Payment;
import model.Resident;
import model.eRole;

public class TenantMonthsPaid extends AppCompatActivity {
    String id;
    Resident residentToView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_months_paid);

        if(getIntent().getExtras() != null)
            id = getIntent().getExtras().getString("id");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userToView = database.getReference("users");

        userToView.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Resident resident = snapshot.getValue(Resident.class);
                        if (resident.GetID().equals(id)) {
                            residentToView = resident;
                        }
                    }
                }

                TextView apartmentNumberTextView = (TextView) findViewById(R.id.textView_apartment_number);
                apartmentNumberTextView.setText("Apartment Number " + Integer.toString(residentToView.GetApartmentNumber()));

                TextView monthPaymentTextView = (TextView) findViewById(R.id.textView_month_of_payments);
                ArrayList<Payment> residentPayments = residentToView.GetPayments();
                String monthOfPaymentString = "Months paid: ";
                for(Payment payment: residentPayments){
                    if(payment.getM_Amount()  > 0){
                        monthOfPaymentString += Integer.toString(payment.getM_Month()) + "  ";
                    }
                }
                monthPaymentTextView.setText(monthOfPaymentString);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
