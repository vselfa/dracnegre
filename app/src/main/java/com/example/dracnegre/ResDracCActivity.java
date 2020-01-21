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

public class ResDracCActivity extends MainMenu {

    TextView resr1dcl, resr1dcv,resr2dcl, resr2dcv,resr3dcl, resr3dcv,resr4dcl, resr4dcv,resr5dcl, resr5dcv,resr6dcl, resr6dcv,resr7dcl, resr7dcv,resr8dcl, resr8dcv,resr9dcl, resr9dcv,resr10dcl, resr10dcv,resr11dcl, resr11dcv;
    FirebaseDatabase database;
    DatabaseReference myRef, myRef1v, myRef2l, myRef2v, myRef3l, myRef3v, myRef4l, myRef4v, myRef5l, myRef5v, myRef6l, myRef6v, myRef7l, myRef7v, myRef8l, myRef8v, myRef9l, myRef9v, myRef10v, myRef10l, myRef11v, myRef11l;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_drac_c);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database =FirebaseDatabase.getInstance();


        //Instancia a la base de datos
        resr1dcl = (TextView) findViewById(R.id.r1cl);
        resr1dcv = (TextView) findViewById(R.id.r1cv);
        resr2dcl = (TextView) findViewById(R.id.r2cl);
        resr2dcv = (TextView) findViewById(R.id.r2cv);
        resr3dcl = (TextView) findViewById(R.id.r3cl);
        resr3dcv = (TextView) findViewById(R.id.r3cv);
        resr4dcl = (TextView) findViewById(R.id.r4cl);
        resr4dcv = (TextView) findViewById(R.id.r4cv);
        resr5dcl = (TextView) findViewById(R.id.r5cl);
        resr5dcv = (TextView) findViewById(R.id.r5cv);
        resr6dcl = (TextView) findViewById(R.id.r6cl);
        resr6dcv = (TextView) findViewById(R.id.r6cv);
        resr7dcl = (TextView) findViewById(R.id.r7cl);
        resr7dcv = (TextView) findViewById(R.id.r7cv);
        resr8dcl = (TextView) findViewById(R.id.r8cl);
        resr8dcv = (TextView) findViewById(R.id.r8cv);
        resr9dcl = (TextView) findViewById(R.id.r9cl);
        resr9dcv = (TextView) findViewById(R.id.r9cv);
        resr10dcl = (TextView) findViewById(R.id.r10cl);
        resr10dcv = (TextView) findViewById(R.id.r10cv);


        //apuntamos al nodo que queremos leer
        myRef = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/1/Drac C");
        myRef1v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/1/Basilio J");
        myRef2l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/2/Quart Chess Rankings com E");
        myRef2v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/2/Drac C");
        myRef3l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/3/Drac C");
        myRef3v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/3/Buñol");
        myRef4l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/4/Torrefiel C");
        myRef4v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/4/Drac C");
        myRef5l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/5/Ciutat Vella");
        myRef5v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/5/Drac C");
        myRef6l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/6/Basilio J");
        myRef6v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/6/Drac C");
        myRef7l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/7/Drac C");
        myRef7v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/7/Quart Chess Rankings com E");
        myRef8l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/8/Buñol");
        myRef8v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/8/Drac C");
        myRef9l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/9/Drac C");
        myRef9v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/9/Torrefiel C");
        myRef10l = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/10/Drac C");
        myRef10v = database.getReference("DracNegre/Interclubs2020/2ªPromoción Centro/Ronda/10/Ciutat Vella");

        //myRef.setValue(resr1dal.getText().toString());

        //Agregamos un ValueEventListener para que los cambios que se hagan en la base de datos
        //se reflejen en la aplicacion
        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                resr1dcl.setText(value);}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr1dcl.setText("NN"); }});

        myRef1v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                resr1dcv.setText(value2);}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr1dcv.setText("NN");}});

        myRef2l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value3 = dataSnapshot.getValue(String.class);
                resr2dcl.setText(value3); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr2dcl.setText("NN"); }});

        myRef2v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value4 = dataSnapshot.getValue(String.class);
                resr2dcv.setText(value4); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr2dcv.setText("NN"); }});

        myRef3l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value5 = dataSnapshot.getValue(String.class);
                resr3dcl.setText(value5); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr3dcl.setText("NN"); }});

        myRef3v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value6 = dataSnapshot.getValue(String.class);
                resr3dcv.setText(value6); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr3dcv.setText("NN"); }});

        myRef4l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value7 = dataSnapshot.getValue(String.class);
                resr4dcl.setText(value7); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr4dcl.setText("NN"); }});

        myRef4v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value8 = dataSnapshot.getValue(String.class);
                resr4dcv.setText(value8); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr4dcv.setText("NN"); }});

        myRef5l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value9 = dataSnapshot.getValue(String.class);
                resr5dcl.setText(value9); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr5dcl.setText("NN"); }});

        myRef5v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value10 = dataSnapshot.getValue(String.class);
                resr5dcv.setText(value10); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr5dcv.setText("NN"); }});

        myRef6l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valu11 = dataSnapshot.getValue(String.class);
                resr6dcl.setText(valu11); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr6dcl.setText("NN"); }});

        myRef6v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value12 = dataSnapshot.getValue(String.class);
                resr6dcv.setText(value12); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr6dcv.setText("NN"); }});

        myRef7l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value13 = dataSnapshot.getValue(String.class);
                resr7dcl.setText(value13); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr7dcl.setText("NN"); }});

        myRef7v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value14 = dataSnapshot.getValue(String.class);
                resr7dcv.setText(value14); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr7dcv.setText("NN"); }});

        myRef8l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value15 = dataSnapshot.getValue(String.class);
                resr8dcl.setText(value15); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr8dcl.setText("NN"); }});

        myRef8v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value16 = dataSnapshot.getValue(String.class);
                resr8dcv.setText(value16); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr8dcv.setText("NN"); }});

        myRef9l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value17 = dataSnapshot.getValue(String.class);
                resr9dcl.setText(value17); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr9dcl.setText("NN"); }});

        myRef9v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value18 = dataSnapshot.getValue(String.class);
                resr9dcv.setText(value18); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr9dcv.setText("NN"); }});

        myRef10l.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value19 = dataSnapshot.getValue(String.class);
                resr10dcl.setText(value19); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr10dcl.setText("NN"); }});

        myRef10v.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value20 = dataSnapshot.getValue(String.class);
                resr10dcv.setText(value20); }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed", databaseError.toException());
                resr10dcv.setText("NN"); }});


    } //onCreate end
}