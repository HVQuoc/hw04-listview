package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<RandomDataMachine> {
    Activity context;
    int Idlayout;
    ArrayList<RandomDataMachine> listArray;

    //Create Constructor


    public CustomAdapter(Activity context, int idlayout, ArrayList<RandomDataMachine> listArray) {
        super(context, idlayout,listArray);
        this.context = context;
        Idlayout = idlayout;
        this.listArray = listArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myflater=context.getLayoutInflater();
        // Set IdLayout to Inflater
        convertView=myflater.inflate(Idlayout,null);
        //Get 1 element in Array
        RandomDataMachine randomdata= listArray.get(position);

        ImageView img_random=convertView.findViewById(R.id.icon);
        img_random.setImageResource(randomdata.getImage());
        TextView txtName= convertView.findViewById(R.id.name);
        txtName.setText(randomdata.getName());
        TextView txtNumberPhone= convertView.findViewById(R.id.phone);
        return convertView;
    }
}
