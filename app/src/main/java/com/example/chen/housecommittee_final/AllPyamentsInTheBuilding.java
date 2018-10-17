package com.example.chen.housecommittee_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import model.Resident;
import model.eRole;

public class AllPyamentsInTheBuilding extends AppCompatActivity {
    public List<Resident> listOfTenants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pyaments_in_the_building);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference("users");
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Resident resident = snapshot.getValue(Resident.class);
                        if (resident.GetRole() == eRole.Resident) {
                            listOfTenants.add(resident);
                        }
                    }
                }

                final TenantMonthPaymentsAdapter tenantMonthPaymentsAdapter =
                        new TenantMonthPaymentsAdapter(listOfTenants, AllPyamentsInTheBuilding.this);
                ListView listViewAllPayments = findViewById(R.id.listView_all_payments);
                listViewAllPayments.setAdapter(tenantMonthPaymentsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
