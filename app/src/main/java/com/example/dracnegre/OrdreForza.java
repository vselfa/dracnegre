package com.example.dracnegre;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class OrdreForza extends MainMenu {

    ListView OrdreView;
    String[] jugadors, ELO, ordre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordre_forza);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.content_ordre_forza);
        //ArrayList<llistaJugadors>Mylist=new ArrayList<>();
        jugadorsAdapter adapter = new jugadorsAdapter(this, repositoriJugadors.getInstance().getLeads());

        OrdreView=findViewById(R.id.ordreForza);
        OrdreView.setAdapter(adapter);
        }
    }

