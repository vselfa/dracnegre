package com.example.dracnegre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.List;

public class jugadorsAdapter extends ArrayAdapter{

    public jugadorsAdapter(@NonNull Context context, List objects) {

        super(context, 0, objects);
    }

    /*
     la receta a seguir sería:

Obtener referencia del componente LayoutInflater.
Inflar el layout del ítem si el view no existe
Obtén las instancias de los views a modificar
Obtén la instancia actual de la fuente de datos, extrae sus valores y haz el setup en los views.
     */


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtener inflater
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Get the data item for this position

// Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_jugadors, parent, false);
        }
        // Referencias UI.
        ImageView idPhoto = convertView.findViewById(R.id.iv_avatar);
        TextView nomCognom = convertView.findViewById(R.id.name);
        TextView ordre =  convertView.findViewById(R.id.ordre);
        TextView elo = convertView.findViewById(R.id.elo);

        llistaJugadors jugadors = (llistaJugadors) getItem(position);

        // Setup.
        Glide.with(getContext()).load(jugadors.getIdPhoto()).into(idPhoto);
        nomCognom.setText(jugadors.getNomCognoms());
        ordre.setText(jugadors.getOrdre());
        elo.setText(jugadors.getElo());




// Return the completed view to render on screen
        return convertView;
    }

}
