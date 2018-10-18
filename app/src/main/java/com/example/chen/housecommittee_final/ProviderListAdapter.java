package com.example.chen.housecommittee_final;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.security.Provider;
import java.util.List;

import model.Resident;
import model.Supplier;

public class ProviderListAdapter extends ArrayAdapter<Supplier> {

    List<Supplier> suppliers;
    Activity context;

    public ProviderListAdapter(List<Supplier> suppliers, Activity context){
        super(context, 0, suppliers);
        this.suppliers =suppliers;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.provider_details, parent, false);
        Supplier supplier = suppliers.get(position);
        //TextView emailTv = (TextView) convertView.findViewById(R.id.editText_email);

        TextView name = (TextView)view.findViewById(R.id.textView_name_of_provider);
        name.setText(supplier.GetName());

        TextView telephone = (TextView)view.findViewById(R.id.textView_telephone_of_provider);
        telephone.setText((supplier.GetPhone()));

//            TextView id = (TextView)view.findViewById(R.id.textView_id);
//            id.setText(resident.GetID());
//
//            TextView aptNum = (TextView)view.findViewById(R.id.textView_apt_num);
//            aptNum.setText(String.valueOf(resident.GetApartmentNumber()));
//
//            TextView payment = (TextView)view.findViewById(R.id.textView_payment);
//            payment.setText(String.valueOf(resident.GetMounhtlyPayment()));

        return view;
    }

}
