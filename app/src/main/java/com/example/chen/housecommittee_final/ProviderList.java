package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import model.Resident;
import model.Supplier;
import model.eRole;

public class ProviderList extends AppCompatActivity {

    public List<Supplier> listOfProvider = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_list);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference("supplier");
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Supplier supplier = snapshot.getValue(Supplier.class);
                        listOfProvider.add(supplier);
                    }
                }

                final ProviderListAdapter providerListAdapter =
                        new ProviderListAdapter(listOfProvider, ProviderList.this);
                ListView listViewListOfproviders = findViewById(R.id.list_view_providers);
                listViewListOfproviders .setAdapter(providerListAdapter);

//                listViewListOfproviders .setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent tenantPaymentIntent = new Intent(getApplicationContext(), TenantPayment.class);
//                        Supplier supplier = (Supplier) listOfProvider.get(position);
//                        tenantPaymentIntent.putExtra("id", supplier.GetID());
//                        startActivity(tenantPaymentIntent);
//                    }
//                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
