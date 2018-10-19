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

import model.Resident;
import model.eRole;

public class HomeTenant extends AppCompatActivity {
    Resident residentLoggedIn;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tenant);

        if (getIntent().getExtras() != null)
            email = getIntent().getExtras().getString("email");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference("users");
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Resident resident = snapshot.getValue(Resident.class);
                        if (resident.getM_Email().equals(email)) {
                            residentLoggedIn = resident;
                        }
                    }
                }

                TextView nameTextView = (TextView) findViewById(R.id.textview_my_name);
                nameTextView.setText("Hi " + residentLoggedIn.GetName());

                final HomeTenantAdapter MonthlyPaymentAdapter =
                        new HomeTenantAdapter(residentLoggedIn.GetPayments(), HomeTenant.this);
                ListView paymentsListView = (ListView) findViewById(R.id.listView_my_payments);
                paymentsListView.setAdapter(MonthlyPaymentAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
