package com.example.dracnegre;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class equipsOrdenatsAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    // No funciona  ... per ara!!

   /* // Nova versió del layout: HashMap [Equip,  HashMap [PuntsE, PuntsJ]] i adapter
    HashMap<Integer ,Integer> hashMapPuntsClassificacio;  = new HashMap<>();
    HashMap<String, Object> hashMapEquipsClassificats = new HashMap<>() ;

    // Constructor to get different lists
    equipsOrdenatsAdapter (HashMap<String, Object> equips) {
        hashMapEquipsClassificats = equips;
        hashMapPuntsClassificacio  = new HashMap<>();
    }
    @Override
    public int getCount() {
        return hashMapEquipsClassificats.size();
    }
    @Override
    public Object getItem(Object punts) {
        hashMapPuntsClassificacio = (HashMap<Integer, Integer>) hashMapEquipsClassificats.get(punts);
        return hashMapPuntsClassificacio;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(HashMap<String, Object> punts, View view, ViewGroup viewGroup) {
        // The view doesn't exist yet
        if (view == null) {
            Context context = viewGroup.getContext();
            // Creating a linear layout to show CheckBoxes and courses
            LinearLayout myLinearLayoutView = new LinearLayout(context);
            myLinearLayoutView.setOrientation(LinearLayout.HORIZONTAL);
            // Afegint el nom de l'equip
            TextView nomEquip = new TextView(context);
            myLinearLayoutView.addView(nomEquip);
            // Els punts de l'equip
            TextView puntsEquip = new TextView(context);
            puntsEquip.setText(hashMapEquipsClassificats.get(punts).toString());
            puntsEquip.setPadding(0, 0, 10, 0);
            // Els punts dels jugadors
            TextView puntsJugadors = new TextView(context);
            puntsJugadors.setText(punts.get(getItemId(i)));
            puntsEquip.setPadding(0, 0, 10, 0);

            // Adding the name of the course
            myLinearLayoutView.addView(nameTextView);
            // Returning the created view
            return myLinearLayoutView;
        }
        // The view already exist
        return view;
    }*/
}

