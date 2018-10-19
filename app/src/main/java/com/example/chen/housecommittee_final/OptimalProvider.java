package com.example.chen.housecommittee_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import model.Payment;
import model.Resident;
import model.Supplier;
import model.eRole;

public class OptimalProvider extends AppCompatActivity {

    String optimalProvider = "";
    int currentQuality = 0;
    int currentAvailability = 0;
    int maxQuality = 0;
    int maxAvailability=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimal_provider);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference users = database.getReference("supplier");
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Supplier supplier = snapshot.getValue(Supplier.class);

                        currentAvailability = supplier.GetAvailability();
                        currentQuality = supplier.GetQuality();

                        if (currentQuality > maxQuality) {
                            maxQuality = currentQuality;
                            if (currentAvailability > maxAvailability) {
                                maxAvailability = currentAvailability;
                                optimalProvider = supplier.GetName();
                            }
                        }
                    }
                }
                TextView optimalsupplierTextView = (TextView)findViewById(R.id.textView_name_of_optimal_provider);
                optimalsupplierTextView.setText(optimalProvider);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
