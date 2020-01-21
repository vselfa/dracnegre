package com.example.dracnegre;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.widget.TextView;

public class ResDracAActivity extends MainMenu {

    TextView resr1dal, resr1dav,resr2dal, resr2dav,resr3dal, resr3dav,resr4dal, resr4dav,resr5dal, resr5dav,resr6dal, resr6dav,resr7dal, resr7dav,resr8dal, resr8dav,resr9dal, resr9dav,resr10dal, resr10dav,resr11dal, resr11dav;
    FirebaseDatabase database;
    DatabaseReference myRef, myRef1v, myRef2l, myRef2v, myRef3l, myRef3v, myRef4l, myRef4v, myRef5l, myRef5v, myRef6l, myRef6v, myRef7l, myRef7v, myRef8l, myRef8v, myRef9l, myRef9v, myRef10v, myRef10l, myRef11v, myRef11l;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_drac_a);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database =FirebaseDatabase.getInstance();


    //Instancia a la base de datos
        resr1dal = (TextView) findViewById(R.id.r1dal);
        resr1dav = (TextView) findViewById(R.id.r1dav);
        resr2dal = (TextView) findViewById(R.id.r2dal);
        resr2dav = (TextView) findViewById(R.id.r2dav);
        resr3dal = (TextView) findViewById(R.id.r3dal);
        resr3dav = (TextView) findViewById(R.id.r3dav);
        resr4dal = (TextView) findViewById(R.id.r4dal);
        resr4dav = (TextView) findViewById(R.id.r4dav);
        resr5dal = (TextView) findViewById(R.id.r5dal);
        resr5dav = (TextView) findViewById(R.id.r5dav);
        resr6dal = (TextView) findViewById(R.id.r6dal);
        resr6dav = (TextView) findViewById(R.id.r6dav);
        resr7dal = (TextView) findViewById(R.id.r7dal);
        resr7dav = (TextView) findViewById(R.id.r7dav);
        resr8dal = (TextView) findViewById(R.id.r8dal);
        resr8dav = (TextView) findViewById(R.id.r8dav);
        resr9dal = (TextView) findViewById(R.id.r9dal);
        resr9dav = (TextView) findViewById(R.id.r9dav);
        resr10dal = (TextView) findViewById(R.id.r10dal);
        resr10dav = (TextView) findViewById(R.id.r10dav);
        resr11dal = (TextView) findViewById(R.id.r11dal);
        resr11dav = (TextView) findViewById(R.id.r11dav);

        //String ruta1=DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/1/Alaquas B;
        //child("DracNegre").child("Interclubs2020").child("2AutonomicaCentro").child("Ronda").child("1").child("Alaquas B").getValue();
            //apuntamos al nodo que queremos leer
        //myRef = database.getReference().child("DracNegre").child("Interclubs2020").child("2AutonomicaCentro").child("Ronda").child("1").child("Alaquas B");
        myRef = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/1/Alaquas B");
        myRef1v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/1/Drac A");
        myRef2l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/2/Drac A");
        myRef2v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/2/Alzira B");
        myRef3v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/3/Drac A");
        myRef3l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/3/Montserrat");
        myRef4l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/4/Drac A");
        myRef4v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/4/Xeraco B");
        myRef5l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/5/Drac A");
        myRef5v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/5/Gambito-Benimaclet C");
        myRef6l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/6/Camp de Morvedre C");
        myRef6v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/6/Drac A");
        myRef7l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/7/Drac A");
        myRef7v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/7/Sport megias Xativa");
        myRef8l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/8/Castell de Riba-Roja");
        myRef8v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/8/Drac A");
        myRef9l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/9/Drac A");
        myRef9v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/9/Fomento Gandia B");
        myRef10l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/10/Basilio B");
        myRef10v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/10/Drac A");
        myRef11l = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/11/Drac A");
        myRef11v = database.getReference("DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/11/Massanassa");

        //myRef.setValue(resr1dal.getText().toString());

            //Agregamos un ValueEventListener para que los cambios que se hagan en la base de datos
            //se reflejen en la aplicacion
            myRef.addValueEventListener(new ValueEventListener(){
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Long value = dataSnapshot.getValue(Long.class);
                    resr1dal.setText(String.valueOf(value));}
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w("Failed", databaseError.toException());
                    resr1dal.setText("NN"); }});

            myRef1v.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Long value2 = dataSnapshot.getValue(Long.class);
                    resr1dav.setText(String.valueOf(value2));
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w("Failed", databaseError.toException());
                    resr1dav.setText("NN");}});

            myRef2l.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Long value3 = dataSnapshot.getValue(Long.class);
                    resr2dal.setText(String.valueOf(value3));
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w("Failed", databaseError.toException());
                    resr2dal.setText("NN"); }});

            myRef2v.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Long value4 = dataSnapshot.getValue(Long.class);
                    resr2dav.setText(String.valueOf(value4));
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w("Failed", databaseError.toException());
                    resr2dav.setText("NN"); }});

            myRef3l.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Long value5 = dataSnapshot.getValue(Long.class);
                    resr3dal.setText(String.valueOf(value5));
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w("Failed", databaseError.toException());
                    resr3dal.setText("NN"); }});

        myRef3v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value6 = dataSnapshot.getValue(Long.class);
                resr3dav.setText(String.valueOf(value6));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr3dav.setText("NN"); }});

        myRef4l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value7 = dataSnapshot.getValue(Long.class);
                resr4dal.setText(String.valueOf(value7));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr4dal.setText("NN"); }});

        myRef4v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value8 = dataSnapshot.getValue(Long.class);
                resr4dav.setText(String.valueOf(value8));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr4dav.setText("NN"); }});

        myRef5l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value9 = dataSnapshot.getValue(Long.class);
                resr5dal.setText(String.valueOf(value9));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr5dal.setText("NN"); }});

        myRef5v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value10 = dataSnapshot.getValue(Long.class);
                resr5dav.setText(String.valueOf(value10));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr5dav.setText("NN"); }});

        myRef6l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long valu11 = dataSnapshot.getValue(Long.class);
                resr6dal.setText(String.valueOf(valu11));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr6dal.setText("NN"); }});

        myRef6v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value12 = dataSnapshot.getValue(Long.class);
                resr6dav.setText(String.valueOf(value12));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr6dav.setText("NN"); }});

        myRef7l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value13 = dataSnapshot.getValue(Long.class);
                resr7dal.setText(String.valueOf(value13));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr7dal.setText("NN"); }});

        myRef7v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value14 = dataSnapshot.getValue(Long.class);
                resr7dav.setText(String.valueOf(value14)); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr7dav.setText("NN"); }});

        myRef8l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value15 = dataSnapshot.getValue(Long.class);
                resr8dal.setText(String.valueOf(value15)); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr8dal.setText("NN"); }});

        myRef8v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value16 = dataSnapshot.getValue(Long.class);
                resr8dav.setText(String.valueOf(value16));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr8dav.setText("NN"); }});

        myRef9l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value17 = dataSnapshot.getValue(Long.class);
                resr9dal.setText(String.valueOf(value17)); 
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr9dal.setText("NN"); }});

        myRef9v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value18 = dataSnapshot.getValue(Long.class);
                resr9dav.setText(String.valueOf(value18));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr9dav.setText("NN"); }});

        myRef10l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value19 = dataSnapshot.getValue(Long.class);
                resr10dal.setText(String.valueOf(value19));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr10dal.setText("NN"); }});

        myRef10v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value20 = dataSnapshot.getValue(Long.class);
                resr10dav.setText(String.valueOf(value20));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr10dav.setText("NN"); }});

        myRef11l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value21 = dataSnapshot.getValue(Long.class);
                resr11dal.setText(String.valueOf(value21));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr11dal.setText("NN"); }});

        myRef11v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Long value22 = dataSnapshot.getValue(Long.class);
                resr11dav.setText(String.valueOf(value22));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr11dav.setText("NN"); }});

} //onCreate end
}