package com.example.chen.housecommittee_final;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

import model.Supplier;

public class CreateProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_provider);

        Button saveButton = (Button)findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameEditText = (EditText)findViewById(R.id.NameEditText);
                String name = nameEditText.getText().toString();

                EditText serialEditText = (EditText)findViewById(R.id.SerialNumberEditText);
                int id = Integer.parseInt(serialEditText.getText().toString());

                EditText QualityEditText = (EditText)findViewById(R.id.QualityEditBox);
                int quality= Integer.parseInt(QualityEditText.getText().toString());

                EditText AvailabilityEditText = (EditText)findViewById(R.id.AvailabilityEditText);
                int availability = Integer.parseInt(QualityEditText.getText().toString());

                Supplier supplier = new Supplier();
                supplier.SetName(name);
                supplier.SetID(id);
                supplier.SetAvailability(availability);
                supplier.SetQuality(quality);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference supplierDB = database.getReference("supplier");
                supplierDB.child(name).setValue(supplier);


            }
        });
    }
}
