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

public class ResDracBActivity extends MainMenu {

    TextView resr1dbl, resr1dbv,resr2dbl, resr2dbv,resr3dbl, resr3dbv,resr4dbl, resr4dbv,resr5dbl, resr5dbv,resr6dbl, resr6dbv,resr7dbl, resr7dbv,resr8dbl, resr8dbv,resr9dbl, resr9dbv,resr10dbl, resr10dbv,resr11dbl, resr11dbv;
    FirebaseDatabase database;
    DatabaseReference myRef, myRef1v, myRef2l, myRef2v, myRef3l, myRef3v, myRef4l, myRef4v, myRef5l, myRef5v, myRef6l, myRef6v, myRef7l, myRef7v, myRef8l, myRef8v, myRef9l, myRef9v, myRef10v, myRef10l, myRef11v, myRef11l;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_drac_b);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database =FirebaseDatabase.getInstance();


        //Instancia a la base de datos
        resr1dbl = (TextView) findViewById(R.id.r1bl);
        resr1dbv = (TextView) findViewById(R.id.r1bv);
        resr2dbl = (TextView) findViewById(R.id.r2bl);
        resr2dbv = (TextView) findViewById(R.id.r2bv);
        resr3dbl = (TextView) findViewById(R.id.r3bl);
        resr3dbv = (TextView) findViewById(R.id.r3bv);
        resr4dbl = (TextView) findViewById(R.id.r4bl);
        resr4dbv = (TextView) findViewById(R.id.r4bv);
        resr5dbl = (TextView) findViewById(R.id.r5bl);
        resr5dbv = (TextView) findViewById(R.id.r5bv);
        resr6dbl = (TextView) findViewById(R.id.r6bl);
        resr6dbv = (TextView) findViewById(R.id.r6bv);
        resr7dbl = (TextView) findViewById(R.id.r7bl);
        resr7dbv = (TextView) findViewById(R.id.r7bv);
        resr8dbl = (TextView) findViewById(R.id.r8bl);
        resr8dbv = (TextView) findViewById(R.id.r8bv);
        resr9dbl = (TextView) findViewById(R.id.r9bl);
        resr9dbv = (TextView) findViewById(R.id.r9bv);
        resr10dbl = (TextView) findViewById(R.id.r10bl);
        resr10dbv = (TextView) findViewById(R.id.r10bv);
        resr11dbl = (TextView) findViewById(R.id.r11bl);
        resr11dbv = (TextView) findViewById(R.id.r11bv);

        //String ruta1=DracNegre/Interclubs2020/2AutonomicaCentro/Ronda/1/Alaquas B;
        //child("DracNegre").child("Interclubs2020").child("2AutonomicaCentro").child("Ronda").child("1").child("Alaquas B").getValue();
        //apuntamos al nodo que queremos leer
        //myRef = database.getReference().child("DracNegre").child("Interclubs2020").child("2AutonomicaCentro").child("Ronda").child("1").child("Alaquas B");
        myRef = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/1/Alaquas C");
        myRef1v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/1/Drac B");
        myRef2l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/2/Drac B");
        myRef2v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/2/Mislata Lanjaron Discema C");
        myRef3l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/3/Basilio C");
        myRef3v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/3/Drac B");
        myRef4l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/4/Drac B");
        myRef4v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/4/Xeraco D");
        myRef5l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/5/Drac B");
        myRef5v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/5/Gambito-Benimaclet E");
        myRef6l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/6/Quart ChessRankings com B");
        myRef6v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/6/Drac B");
        myRef7l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/7/Drac B");
        myRef7v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/7/Alborache Piccadilly");
        myRef8l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/8/Aldaia Educart");
        myRef8v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/8/Drac B");
        myRef9l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/9/Drac B");
        myRef9v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/9/Moncada FDM");
        myRef10l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/10/Dama Roja B");
        myRef10v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/10/Drac B");
        myRef11l = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/11/Drac B");
        myRef11v = database.getReference("DracNegre/Interclubs2020/1ªProvincial Centro/Ronda/11/Burjassot B");

        //myRef.setValue(resr1dal.getText().toString());

        //Agregamos un ValueEventListener para que los cambios que se hagan en la base de datos
        //se reflejen en la aplicacion
        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                resr1dbl.setText(value);}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr1dbl.setText("NN"); }});

        myRef1v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                resr1dbv.setText(value2);}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr1dbv.setText("NN");}});

        myRef2l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value3 = dataSnapshot.getValue(String.class);
                resr2dbl.setText(value3); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr2dbl.setText("NN"); }});

        myRef2v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value4 = dataSnapshot.getValue(String.class);
                resr2dbv.setText(value4); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr2dbv.setText("NN"); }});

        myRef3l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value5 = dataSnapshot.getValue(String.class);
                resr3dbl.setText(value5); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr3dbl.setText("NN"); }});

        myRef3v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value6 = dataSnapshot.getValue(String.class);
                resr3dbv.setText(value6); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr3dbv.setText("NN"); }});

        myRef4l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value7 = dataSnapshot.getValue(String.class);
                resr4dbl.setText(value7); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr4dbl.setText("NN"); }});

        myRef4v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value8 = dataSnapshot.getValue(String.class);
                resr4dbv.setText(value8); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr4dbv.setText("NN"); }});

        myRef5l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value9 = dataSnapshot.getValue(String.class);
                resr5dbl.setText(value9); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr5dbl.setText("NN"); }});

        myRef5v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value10 = dataSnapshot.getValue(String.class);
                resr5dbv.setText(value10); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr5dbv.setText("NN"); }});

        myRef6l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valu11 = dataSnapshot.getValue(String.class);
                resr6dbl.setText(valu11); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr6dbl.setText("NN"); }});

        myRef6v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value12 = dataSnapshot.getValue(String.class);
                resr6dbv.setText(value12); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr6dbv.setText("NN"); }});

        myRef7l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value13 = dataSnapshot.getValue(String.class);
                resr7dbl.setText(value13); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr7dbl.setText("NN"); }});

        myRef7v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value14 = dataSnapshot.getValue(String.class);
                resr7dbv.setText(value14); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr7dbv.setText("NN"); }});

        myRef8l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value15 = dataSnapshot.getValue(String.class);
                resr8dbl.setText(value15); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr8dbl.setText("NN"); }});

        myRef8v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value16 = dataSnapshot.getValue(String.class);
                resr8dbv.setText(value16); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr8dbv.setText("NN"); }});

        myRef9l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value17 = dataSnapshot.getValue(String.class);
                resr9dbl.setText(value17); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr9dbl.setText("NN"); }});

        myRef9v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value18 = dataSnapshot.getValue(String.class);
                resr9dbv.setText(value18); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr9dbv.setText("NN"); }});

        myRef10l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value19 = dataSnapshot.getValue(String.class);
                resr10dbl.setText(value19); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr10dbl.setText("NN"); }});

        myRef10v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value20 = dataSnapshot.getValue(String.class);
                resr10dbv.setText(value20); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr10dbv.setText("NN"); }});

        myRef11l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value21 = dataSnapshot.getValue(String.class);
                resr11dbl.setText(value21); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr11dbl.setText("NN"); }});

        myRef11v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value22 = dataSnapshot.getValue(String.class);
                resr11dbv.setText(value22); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr11dbv.setText("NN"); }});

    } //onCreate end
}