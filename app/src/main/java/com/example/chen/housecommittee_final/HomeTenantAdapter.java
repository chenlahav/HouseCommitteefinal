package com.example.chen.housecommittee_final;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import model.Payment;
import model.Resident;

public class HomeTenantAdapter extends ArrayAdapter<Payment> {
    ArrayList<Payment> allPayments;
    Activity context;

    public HomeTenantAdapter(ArrayList<Payment> payments, Activity context) {
        super(context, 0, payments);
        this.allPayments = payments;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.payment, parent, false);
        Payment payment = allPayments.get(position);

        TextView monthTextView = (TextView)view.findViewById(R.id.textView_month);
        monthTextView.setText("Month: " + Integer.toString(payment.getM_Month()));

        TextView amountTextView = (TextView)view.findViewById(R.id.textView_amount);
        amountTextView.setText("Amount: " + Integer.toString(payment.getM_Amount()) + " nis");

        return view;
    }
}
