package com.example.dracnegre.Vista;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dracnegre.Model.ResultatEquip;
import com.example.dracnegre.Model.ResultatEquipAmbFoto;
import com.example.dracnegre.R;

import java.util.ArrayList;

public class EquipListAmbFotosAdapter extends ArrayAdapter<ResultatEquipAmbFoto> {

    private static final String TAG = "PersonListWithPhotoAdapter";
    private Context mContext;
    private int mResource;

    public EquipListAmbFotosAdapter(Context context, int resource, ArrayList<ResultatEquipAmbFoto> objects) {
        super(context, resource, objects);
        mContext =  context;  // Important per accedir a getResources, entre altres coses
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //  Get the team inforamtion
        String fotoE = getItem(position).getFotoEquip();
        String nomE = getItem(position).getNomEquip();
        Integer puntsE = getItem(position).getPuntsEquip();
        Integer puntsJ = getItem(position).getPuntsJugadors();

        //Create the person object with the information
        ResultatEquipAmbFoto equip = new ResultatEquipAmbFoto(fotoE, nomE, puntsE, puntsJ);

        /*Log.d("equips", "getView ------: " + equip.getNomEquip() + ". Punts equip:"
                + equip.getPuntsEquip() + ". Punts jugadors: "
                + equip.getPuntsJugadors());
*/
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView fotoEquip = convertView.findViewById(R.id.fotoEquip);
        TextView nomEquip = convertView.findViewById(R.id.nomEquip);
        TextView puntsEquip =  convertView.findViewById(R.id.puntsEquip);
        TextView puntsJugadors =  convertView.findViewById(R.id.puntsJugadors);

        // Transformar el nom de la foto en R.drawable.nom_foto
        // Eliminar corxets del nom de la foto
        String nomFoto = fotoE.substring(1, fotoE.length()-1);
        Log.d ("equips", "Foto retallada: " + nomFoto);

        int foto = mContext.getResources().getIdentifier( nomFoto, "drawable", mContext.getPackageName());
        Log.d("equips", "EquipListAmbFotosAdapter ------: Nom foto: " + nomFoto + " int " + foto );
        fotoEquip.setImageResource(foto);
        nomEquip.setText(equip.getNomEquip());
        puntsEquip.setText(String.valueOf(equip.getPuntsEquip()));
        puntsJugadors.setText(String.valueOf(equip.getPuntsJugadors()));

        return convertView;
    }
}

