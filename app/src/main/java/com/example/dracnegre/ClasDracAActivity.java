package com.example.dracnegre;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ClasDracAActivity extends MainMenu {

    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView resEquip, respEqpr, respJupr;

    public static class ResultatEquip {

        public String puntsEquips;
        public String puntsJugadors;

        public ResultatEquip(String puntsEquips, String puntsJugadors) {

            this.puntsEquips = puntsEquips;
            this.puntsJugadors = puntsJugadors;
        }

        public String getPuntsEquips() {
            return puntsEquips;
        }

        public void setPuntsEquips(String puntsEquips) {
            this.puntsEquips = puntsEquips;
        }

        public String getPuntsJugadors() {
            return puntsJugadors;
        }

        public void setPuntsJugadors(String puntsJugadors) {
            this.puntsJugadors = puntsJugadors;
        }

        @Override
        public String toString() {
            return "ResultatEquip{" +
                    "puntsEquips='" + puntsEquips + '\'' +
                    ", puntsJugadors='" + puntsJugadors + '\'' +
                    '}';
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clas_drac_a);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        database = FirebaseDatabase.getInstance();

        resEquip = (TextView) findViewById(R.id.equipPrim);
        respEqpr = (TextView) findViewById(R.id.rEqPrim);
        respJupr = (TextView) findViewById(R.id.rJugPrim);


        myRef = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Classificació/Alaquas B");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ResultatEquip>t=new GenericTypeIndicator<ResultatEquip>() {};
                ResultatEquip resultatEquip = dataSnapshot.getValue(t);
//                resEquip.setText(dataSnapshot.getKey());
//                respEqpr.setText(resultatEquip.puntsEquips);
//                respJupr.setText(resultatEquip.puntsJugadors);
                String resultado = ("Key: " + dataSnapshot.child("puntsEquip").getKey());
                resEquip.setText(resultado);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resEquip.setText("NN");
                respEqpr.setText("NN");
                respJupr.setText("NN");
            }
        });
    }
}