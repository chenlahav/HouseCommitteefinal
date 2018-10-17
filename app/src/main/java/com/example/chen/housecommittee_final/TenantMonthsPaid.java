//package com.example.chen.housecommittee_final;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ListView;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import model.Resident;
//import model.eRole;
//
//public class TenantMonthsPaid extends AppCompatActivity {
//
//    Resident resident;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tenant_months_paid);
//
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        String id;
//        if(getIntent().getExtras() != null)
//            id = getIntent().getExtras().getString("id");
//
//        DatabaseReference users = database.getReference("users").child(id);
//
//        users.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                        resident = dataSnapshot.getValue(Resident.class);
//                    }
//                }
//
//                final TenantMonthPaymentsAdapter tenantMonthPaymentsAdapter =
//                        new TenantMonthPaymentsAdapter(listOfTenants, AllPyamentsInTheBuilding.this);
//                ListView listViewAllPayments = findViewById(R.id.listView_all_payments);
//                listViewAllPayments.setAdapter(tenantMonthPaymentsAdapter);
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
//}
