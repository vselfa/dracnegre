package com.example.dracnegre;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Competicio extends MainMenu {

    ListView rondaview;
    String[] ronda, rdrac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competicio);
        //setContentView(R.layout.content_locals_joc);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ronda = new String[]{
                "Ronda 1.           Data: 11/01/2020",
                "Ronda 2.           Data: 18/01/2020",
                "Ronda 3.           Data: 25/01/2020",
                "Ronda 4.           Data: 01/02/2020",
                "Ronda 5.           Data: 08/02/2020",
                "Ronda 6.           Data: 15/02/2020",
                "Ronda 7.           Data: 22/02/2020",
                "Ronda 8.           Data: 29/02/2020",
                "Ronda 9.           Data: 07/03/2020",
                "Ronda 10.          Data: 21/03/2020",
                "Ronda 11.          Data: 28/03/2020"};
        rdrac =new String[]{
                "\nAlaquas B - Drac Negre A\n\nAlaquas C - Drac Negre B\n\nDrac Negre C - Basilio J",
                "\nDrac Negre A - Alzira B\n\nDrac Negre B - Mislata Lanjaron C\n\nQuart Chess Rankink E - Drac Negre C",
                "\nMonserrat - Drac Negre A\n\nBasilio C - Drac Negre B\n\nDrac Negre C - Buñol",
                "\nDrac Negre A - Xeraco B\n\nDrac Negre B - Xeraco D\n\nTorrefiel C - Drac Negre C",
                "\nDrac Negre A - Gambito Benimaclet C\n\nDrac Negre B - Gambito Benimaclet E\n\nCiutat Vella - Drac Negre C",
                "\nCamp de Morvedre - Drac Negre A\n\nQuart Chess Rankink B - Drac Negre B\n\nBasilio J - Drac Negre C",
                "\nDrac Negre A - Sport Megias Xativa\n\nDrac Negre B - Alborache Picadilly\n\nDrac Negre C - Quart Chess Rankink E ",
                "\nCastell de Ribarroja - Drac Negre A\n\nAldaia Educart - Drac Negre B\n\nBuñol - Drac Negre C",
                "\nDrac Negre A - Fomento Gandia B\n\nDrac Negre B - Moncada FM\n\nDrac Negre C - Torrefiel C",
                "\nBasilio B - Drac Negre A\n\nDama Roja B - Drac Negre B\n\nDrac Negre C - Ciutat Vella",
                "\nDrac Negre A - Massanassa\n\nDrac Negre B - Burjassot B"
        };

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ronda);
        rondaview = findViewById(R.id.listlocals);
        rondaview.setAdapter(adapter);
        rondaview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                buildDialog(ronda[position],rdrac[position], position);
            }
        });
    }

    public void buildDialog (String title, String message, int position){
        final ImageView image = new ImageView(this);
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.setView(image);
        builder.create();
        builder.show();
    }

}
