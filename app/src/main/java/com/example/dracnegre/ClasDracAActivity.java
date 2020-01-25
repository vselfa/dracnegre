package com.example.dracnegre;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.example.dracnegre.Model.Punts;
import com.example.dracnegre.Model.ResultatEquipAmbFoto;
import com.example.dracnegre.Vista.EquipListAmbFotosAdapter;
import com.example.dracnegre.Vista.MyCallbackWithPhoto;
import com.google.common.collect.HashMultimap;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Set;

//  Afegir implementation 'com.google.guava:guava:14.0.1'
// en el gradle del modul
import com.google.common.collect.Multimap;

public class ClasDracAActivity extends MainMenu {

    // La connexió a RTDB
    FirebaseDatabase database;     DatabaseReference myRef;
    // Referencia al node de RTDB
    String classificacio;
    // La classe Punts: de l'equip i dels jugadors
    Punts punts;
    private Set<Punts> keys;
    // Per poder ordenar claus repetides
    private Multimap<Punts, String> treeMultiMap = HashMultimap.create();

    ArrayList<ResultatEquipAmbFoto> equipList;
    // El adapter: EquipListAdapter adapter;
    EquipListAmbFotosAdapter adapter;

    public Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clas_drac_a);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // The connexion to the RTDB
        database = FirebaseDatabase.getInstance();
        classificacio = "DracNegre/Interclubs2020/Classificació/1ProvincialCentro";
        myRef = database.getReference(classificacio);

        // Layout amb un arrayadapter i un objecte ResultatEquip
        final ListView mListView =  findViewById(R.id.listView);
        equipList = new ArrayList<>();

        // Crida a l'interface per a executar quan RTDB retorne les dades
        getLlistaEquipsOrdenatsAmbFoto( new MyCallbackWithPhoto() {
            @Override
            public void onCallbackWithPhoto(ArrayList<ResultatEquipAmbFoto> equips) {
                adapter = new EquipListAmbFotosAdapter(getContext(),
                        R.layout.adapter_view_layout_with_picture, equipList);
                mListView.setAdapter(adapter);
            }
        });
    }

    public void getLlistaEquipsOrdenatsAmbFoto(final MyCallbackWithPhoto myCallbackWithPhoto) {
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot clubsRef) {
                // Llegim els clubs
                Long numClubs = clubsRef.getChildrenCount();
                treeMultiMap.clear(); // netejem les dades
                for (DataSnapshot clubRef : clubsRef.getChildren()) {
                    Log.d("equips", "Els punts de cada club : " +  clubRef.getKey()
                            + " -- " + clubRef.getValue());
                    // Llegim els punts de cada club
                    punts = clubRef.getValue(Punts.class);
                    // Els afegim al Multimap amb els camps canviats
                    treeMultiMap.put(punts, clubRef.getKey());
                    // Els mostrem durant l'última passada del for per a que aparega en cada canvi
                    // de forma immediata
                    if (numClubs > 0) {
                        // Mostrem  valors (Nom club) ordenats
                        Log.d("equips", " Clubs ordenats ------------------");
                        // Les claus = punts
                        Set<Punts> keys = treeMultiMap.keySet();
                        int i=1;
                        equipList.clear();
                        for(Punts punts: keys){
                            // Un adapter utilitzant un objecte ResultatEquipAmbFoto
                            // Creem un objecte per a cada resultat
                            ResultatEquipAmbFoto resultatEquipAmbFoto =
                                  new ResultatEquipAmbFoto("hombreanonimo",
                                          treeMultiMap.get(punts).toString(),
                                          punts.getPuntsEquip(),
                                          punts.getPuntsJugadors());
                            // L'afegim a la llista d'equips
                            Log.d("equips", "Resultat equip ------: "
                                    + resultatEquipAmbFoto.getNomEquip() + ". Punts equip:"
                                    + resultatEquipAmbFoto.getPuntsEquip() + ". Punts jugadors: "
                                    + resultatEquipAmbFoto.getPuntsJugadors());
                            equipList.add(resultatEquipAmbFoto);
                        }
                    }
                } // End for

                // I ara enviem les dades a l'adapter
                myCallbackWithPhoto.onCallbackWithPhoto(equipList);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {            }
        });
    }
}