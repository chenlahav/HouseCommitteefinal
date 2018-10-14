package com.example.chen.housecommittee_final;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import model.Resident;

public class ListOfTenants extends ArrayAdapter<Resident> {

    List<Resident> residents;
    Activity context;

    public ListOfTenants(List<Resident> residents, Activity context) {
        super(context, 0, residents);
        this.residents = residents;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.tenant_details, parent, false);
        Resident resident = residents.get(position);
        //TextView emailTv = (TextView) convertView.findViewById(R.id.editText_email);

        TextView name = (TextView)view.findViewById(R.id.textView_name);
        name.setText(resident.GetName());

        TextView id = (TextView)view.findViewById(R.id.textView_id);
        id.setText(resident.GetID());

        TextView aptNum = (TextView)view.findViewById(R.id.textView_apt_num);
        aptNum.setText(String.valueOf(resident.GetApartmentNumber()));

        TextView payment = (TextView)view.findViewById(R.id.textView_payment);
        payment.setText(String.valueOf(resident.GetMounhtlyPayment()));

        return view;
    }
}
