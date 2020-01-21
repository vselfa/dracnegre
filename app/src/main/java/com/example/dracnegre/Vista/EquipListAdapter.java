package com.example.dracnegre.Vista;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.dracnegre.Model.ResultatEquip;
import com.example.dracnegre.R;

import java.util.ArrayList;

public class EquipListAdapter extends ArrayAdapter<ResultatEquip> {

    private static final String TAG = "PersonListAdapter";
    private Context mContext;
    private int mResource;

    public EquipListAdapter(Context context, int resource, ArrayList<ResultatEquip> objects) {
        super(context, resource, objects);
        mContext =  context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String nomE = getItem(position).getNomEquip();
        Integer puntsE = getItem(position).getPuntsEquip();
        Integer puntsJ = getItem(position).getPuntsJugadors();

        //Create the person object with the information
        ResultatEquip equip = new ResultatEquip(nomE, puntsE, puntsJ);

        Log.d("equips", "getView ------: " + equip.getNomEquip() + ". Punts equip:"
                + equip.getPuntsEquip() + ". Punts jugadors: "
                + equip.getPuntsJugadors());

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView nomEquip = convertView.findViewById(R.id.nomEquip);
        TextView puntsEquip =  convertView.findViewById(R.id.puntsEquip);
        TextView puntsJugadors =  convertView.findViewById(R.id.puntsJugadors);

        nomEquip.setText(equip.getNomEquip());
        puntsEquip.setText(String.valueOf(equip.getPuntsEquip()));
        puntsJugadors.setText(String.valueOf(equip.getPuntsJugadors()));

        return convertView;
    }
}

