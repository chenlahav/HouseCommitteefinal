package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class ListOfTenant extends AppCompatActivity {

    ListView tenantsListView;
    public List<Resident> listOfTenants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_tenant);

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

                final TanentListToUpdateAdapter listOfTenantsAdapter =
                        new TanentListToUpdateAdapter(listOfTenants, ListOfTenant.this);
                ListView listViewListOfTenant = findViewById(R.id.listView_list_of_tenant);
                listViewListOfTenant.setAdapter(listOfTenantsAdapter);

                listViewListOfTenant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent tenantPaymentIntent = new Intent(getApplicationContext(), TenantPayment.class);
                        Resident resident = (Resident) listOfTenants.get(position);
                        tenantPaymentIntent.putExtra("id", resident.GetID() );
                        startActivity(tenantPaymentIntent);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
