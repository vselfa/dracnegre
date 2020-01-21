package com.example.dracnegre;

import com.example.dracnegre.Model.Punts;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EquipsDAO {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    String classificacio;
    ArrayList <Punts> arrayListEquips;

    public EquipsDAO() {
        database = FirebaseDatabase.getInstance();
        classificacio = "Classificacio/1ProvincialCentro";
        myRef= database.getReference("classificacio");
        arrayListEquips   = new ArrayList<>();
    }

    /*public void getEquipsOrdenats(final MyCallback myCallback) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot equips) {
                int i = 0;
                for (DataSnapshot equip : equips.getChildren()) {
                    // L'objecte Punts que llig la informació de la RTDB
                    // puntsEquip i puntsJugador
                    Punts equipAux = equip.getValue(Punts.class);
                    // Nom
                    equipAux.setNom(equip.getKey());
                    // L'afegim a la llista
                    arrayListEquips.add(equipAux);
                    System.out.println("Abans d'ordenar: -----------/n");
                    System.out.println((i+1) + " Nom:" + equips.get(i).getNom()
                            + " - - Punts equip: " + equips.get(i).getPuntsEquip()
                            + " Punts jugadors " + equips.get(i).getPuntsJugadors());
                }

                // Into onDataChange method!!
                myCallback.onCallback(arrayListEquips);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }*/
}

