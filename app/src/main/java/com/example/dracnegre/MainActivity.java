package com.example.dracnegre;
import android.os.Bundle;
import com.example.dracnegre.Model.Punts;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainActivity extends MainMenu {

    FirebaseDatabase database;     DatabaseReference myRef ;
    String classificacio;
    Punts punts;
    // Per ordenar el HashMap
    // 1.- La classe per ordenar
    private MySort sort = new MySort();
    // 2.- El hashmap ordenat
    // Canviem l'ordre del camp en el hashmap per ordenar
    HashMap<Punts, String> hashMapEquips;
    private TreeMap<Punts, String> treeMap = new TreeMap<>(sort);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // The connexion to the RTDB
        database = FirebaseDatabase.getInstance();
        classificacio = "DracNegre/Interclubs2020/Classificació/1ProvincialCentro";
        myRef = database.getReference(classificacio);
        Log.d("equips", "onCreate -----------MainActivity:" + classificacio );

        hashMapEquips = new HashMap<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot clubsRef) {
                //Log.d("equips", "Tots els clubs: "  + clubsRef);
                // Llegim els clubs
                Long numClubs = clubsRef.getChildrenCount();
                int aux = 1;
                for (DataSnapshot clubRef : clubsRef.getChildren()) {
                    Log.d("equips", "Els punts de cada club : " +  clubRef.getKey() + " -- " + clubRef.getValue());
                    // Llegim els punts de cada club
                    punts = clubRef.getValue(Punts.class);
                    // Els afegim al HashMap amb els camps canviats
                    hashMapEquips.put(punts, clubRef.getKey());
                    // Els mostrem durant l'última passada del for per a que aparega en cada canvi
                    // de forma immediata
                    aux++;
                    if (aux > numClubs) {
                        // Mostrem  valors (Nom club) ordenats
                        treeMap.clear();
                        treeMap.putAll(hashMapEquips);
                        Log.d("equips", " Clubs ordenats ------------------");
                        // Les claus = punts
                        Set<Punts> keys = treeMap.keySet();
                        for(Punts punts: keys){
                            Log.d("equips", "Club: " + treeMap.get(punts) + ". Punts equip: "
                                    + punts.getPuntsEquip() + ". Punts jugadors: " + punts.getPuntsJugadors());
                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {            }
        });
    }

    static class MySort implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            return ((Punts) o2).getPuntsEquip() - ((Punts) o1).getPuntsEquip() ;
        }
    }

    public void GetCompetition(View view) {
        /*Intent intent = new Intent (this, OrdreForza.class);
        startActivity(intent);*/
    }

}

