package com.example.dracnegre;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class repositoriJugadors {

    private static repositoriJugadors repo_jug = new repositoriJugadors();
    private TreeMap<String, llistaJugadors> lltajug = new TreeMap<>();

    public static repositoriJugadors getInstance() {
        return repo_jug;
    }

    private repositoriJugadors() {
        saveLead(new llistaJugadors("01", "Carlos Martínez Piqueras", "2198", R.drawable.carlosmartinez));
        saveLead(new llistaJugadors("02", "Luis Sánchez Moreno", "2067", R.drawable.luis2));
        saveLead(new llistaJugadors("03", "Manolo García Cervera", "1834", R.drawable.manolo2));
        saveLead(new llistaJugadors("04", "Llucià Valles i Calvo", "1831", R.drawable.llucia2));
        saveLead(new llistaJugadors("05", "Angel Mir Latorre", "1745", R.drawable.angelmir));
        saveLead(new llistaJugadors("06", "Eduardo Carbonell Forment", "1693", R.drawable.hombreanonimo));
        saveLead(new llistaJugadors("07", "Efren Gil Munera", "1675", R.drawable.efren));
        saveLead(new llistaJugadors("08", "Fco Cuevas Povedano", "1616", R.drawable.pacocuevas));
        saveLead(new llistaJugadors("09", "Vicente Arnal Legua", "1541", R.drawable.vicentearnal));
        saveLead(new llistaJugadors("10", "Juan Jose Rivas Cabanes", "1187", R.drawable.hombreanonimo));
        saveLead(new llistaJugadors("11", "Antonio Bugueda Bielsa", "1333", R.drawable.antoniobugeda));
        saveLead(new llistaJugadors("12", "Bernat Guerola Trull", "1579", R.drawable.bernat));
        saveLead(new llistaJugadors("13", "Javier Roy Serrano", "___", R.drawable.javierroy));
        saveLead(new llistaJugadors("14", "Jose Moyano Gala", "1445", R.drawable.moyano));
        saveLead(new llistaJugadors("15", "Marta Longas Gonzalez", "1423", R.drawable.martalongas));
        saveLead(new llistaJugadors("16", "Vicente Vivo Gimeno", "1397", R.drawable.hombreanonimo));
        saveLead(new llistaJugadors("17", "Ricardo Bermell Bosch", "1508", R.drawable.ricardo));
        saveLead(new llistaJugadors("18", "Jorge Girón Bravo", "1322", R.drawable.hombreanonimo));
        saveLead(new llistaJugadors("19", "Miguel Angel Longas", "1213", R.drawable.malongas));
        saveLead(new llistaJugadors("20", "Francisco Puchades","1335", R.drawable.puchades ));
        saveLead(new llistaJugadors("21","Adrian Bugueda Jorges", "1319", R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("22","Adrian Arevalo Tiburcio", "___", R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("23","Javier Gadea Guerrero", "___", R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("24","Antonio Ventura Almagro", "___", R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("25","Angel López Palao", "___", R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("26","Mar Felix Blanquer", "___", R.drawable.mujeranonimo));
        saveLead(new llistaJugadors("27","Ruben Gadea Guerrero", "___", R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("28","Arnau Ferrer Barón","___" , R.drawable.hombreanonimo ));
        saveLead(new llistaJugadors("29","Maria Dolores Gimeno", "___", R.drawable.lola));

    }

    private void saveLead(llistaJugadors lead) {
        lltajug.put(lead.getOrdre(), lead);
    }

    public List<llistaJugadors> getLeads() {

        return new ArrayList<>(lltajug.values());
    }
}
