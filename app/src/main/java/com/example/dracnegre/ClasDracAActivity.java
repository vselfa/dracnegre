package com.example.dracnegre;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.example.dracnegre.Model.Punts;
import com.example.dracnegre.Model.ResultatEquip;
import com.example.dracnegre.Model.ResultatEquipAmbFoto;
import com.example.dracnegre.Vista.EquipListAdapter;
import com.example.dracnegre.Vista.EquipListAmbFotosAdapter;
import com.example.dracnegre.Vista.MyCallbackWithPhoto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class ClasDracAActivity extends MainMenu {

    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView resEquip, respEqpr, respJupr;
    // Referencia al node de RTDB
    String classificacio;
    Punts punts;
    // 1.- La classe per ordenar
    static MainActivity.MySort sort = new MainActivity.MySort();
    // 2.- El hashmap ordenat
    // Canviem l'ordre del camp en el hashmap per ordenar
    HashMap<Punts, String> hashMapEquips;
    private TreeMap<Punts, String> treeMap = new TreeMap<>(sort);
    private Set<Punts> keys;
    TextView equipsClassificats;

    ArrayList<ResultatEquipAmbFoto> equipList;
    // El adapter
    // EquipListAdapter adapter;
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

        database = FirebaseDatabase.getInstance();

        // Using ScrollView  to show the classified list
        // equipsClassificats = findViewById(R.id.elsEquipsClassficats);

        // The connexion to the RTDB
        database = FirebaseDatabase.getInstance();
        classificacio = "DracNegre/Interclubs2020/Classificació/1ProvincialCentro";
        myRef = database.getReference(classificacio);
        Log.d("equips", "onCreate ----------- ClasDracAActivity" + classificacio);

        // Nova versió del layout: HashMap [Equip,  HashMap [PuntsE, PuntsJ]] i adapter
        final HashMap<Integer ,Integer> hashMapPuntsClassificacio = new HashMap<>();
        final HashMap<String, Object> hashMapEquipsClassificats = new HashMap<>() ;

        // Tercera versió del layout amb un arrayadapter i un objecte ResultatEquip
        final ListView mListView =  findViewById(R.id.listView);
        equipList = new ArrayList<>();
        hashMapEquips = new HashMap<>();

        getLlistaEquipsOrdenatsAmbFoto( new MyCallbackWithPhoto() {
            @Override
            public void onCallbackWithPhoto(ArrayList<ResultatEquipAmbFoto> equips) {
                adapter = new EquipListAmbFotosAdapter(getContext(), R.layout.adapter_view_layout_with_picture, equipList);
                mListView.setAdapter(adapter);
            }
        });
    }

    public void getLlistaEquipsOrdenatsAmbFoto(final MyCallbackWithPhoto myCallbackWithPhoto) {
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot clubsRef) {
                //Log.d("equips", "Tots els clubs: "  + clubsRef);
                // Llegim els clubs
                Long numClubs = clubsRef.getChildrenCount();
                int aux = 1;
                hashMapEquips.clear();
                equipList.clear();
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
                        treeMap.clear(); // netejem les dades
                        // equipsClassificats.setText(""); // Netejem la llista mostrada
                        treeMap.putAll(hashMapEquips);
                        Log.d("equips", " Clubs ordenats ------------------");
                        // Les claus = punts
                        Set<Punts> keys = treeMap.keySet();
                        int i=1;
                        for(Punts punts: keys){
                            Log.d("equips", "Club: " + treeMap.get(punts)+". Punts equip:"
                                    + punts.getPuntsEquip() + ". Punts jugadors: "
                                    + punts.getPuntsJugadors());

                            /*// Utilitzem un scrollView per mostrar la llista d'equips classificats
                            equipsClassificats.setText(equipsClassificats.getText()+ "\n " + i++
                                    + "   " + treeMap.get(punts) + " ----- "
                                    + punts.getPuntsEquip() + " "
                                    + punts.getPuntsJugadors()+ "\n" );*/

                            // Un altre tipus d'adapter: utilitzant un objecte ResultatEquipAmbFoto
                            // Creem un objecte per a cada resultat
                            ResultatEquipAmbFoto resultatEquipAmbFoto =
                                  new ResultatEquipAmbFoto("hombreanonimo",
                                          treeMap.get(punts),
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

                // Into onDataChange method!!
                myCallbackWithPhoto.onCallbackWithPhoto(equipList);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {            }
        });
    }
}