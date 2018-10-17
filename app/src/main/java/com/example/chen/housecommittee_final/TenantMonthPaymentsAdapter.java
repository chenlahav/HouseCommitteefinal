package com.example.chen.housecommittee_final;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import model.Payment;
import model.Resident;

public class TenantMonthPaymentsAdapter extends ArrayAdapter<Resident> {
    List<Resident> residents;
    Activity context;


    public TenantMonthPaymentsAdapter(List<Resident> residents, Activity context) {
        super(context, 0, residents);
        this.residents = residents;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.tenant_months_of_payments, parent, false);
        Resident resident =(Resident)residents.get(position);

        TextView apartmentNumberTextView = (TextView) view.findViewById(R.id.textView_apartment_number);
        apartmentNumberTextView.setText("Apartment Number " + Integer.toString(resident.GetApartmentNumber()));

        TextView monthPaymentTextView = (TextView) view.findViewById(R.id.textView_month_of_payments);
        ArrayList<Payment> residentPayments = resident.GetPayments();
        String monthOfPaymentString = "Months paid: ";
        for(Payment payment: residentPayments){
            if(payment.getM_Amount()  > 0){
                monthOfPaymentString += Integer.toString(payment.getM_Month()) + "  ";
            }
        }
        monthPaymentTextView.setText(monthOfPaymentString);

        return view;
    }
}
