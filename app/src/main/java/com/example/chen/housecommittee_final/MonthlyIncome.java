package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import model.Payment;
import model.Resident;
import model.eRole;

public class MonthlyIncome extends AppCompatActivity {

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_income);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference("users");
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Resident resident = snapshot.getValue(Resident.class);
                        if (resident.GetRole() == eRole.Resident) {
                            for(Payment payment :resident.GetPayments()){
                                //sum += (resident.GetMounhtlyPayment());
                                sum += payment.getM_Amount();
                            }

                        }
                    }
                }
                ((EditText)findViewById(R.id.TotalSumEditText)).setText(Integer.toString(sum));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
