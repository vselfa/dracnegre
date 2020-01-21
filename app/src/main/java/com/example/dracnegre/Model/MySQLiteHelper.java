package com.example.dracnegre.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dracnegre.llistalocals;

public class MySQLiteHelper extends SQLiteOpenHelper {


    private static String DATABASE_NAME = "DracNegre";
    private static int DATABASE_VERSION = 1; // Telèfono en un camp a part + camp Adresa

    //SQL sentence to create a table Poblacions. Pròxima versió: Canviar poblacio per nom!!!
    String sqlDeletePobalcions =  "DROP TABLE Poblacions;";
    String sqlCreatePoblacions =  "CREATE TABLE Poblacions (ordre TEXT PRIMARY KEY, nomCiutat TEXT NOT NULL, nomClub TEXT, direccio TEXT, numTelf TEXT, latitut REAL, longitut REAL) ";

    String sqlInsertPoblacio1 = "INSERT INTO Poblacions (ordre, nomCiutat, nomClub, direccio, numTelf, latitut, longitut) " +
            "VALUES ('1','Alaquas','C.A. Alaquàs' ,'Plaça de la Constitució, 1 46970 ALAQUÀS','686009679',39.3970134,-0.4138396)";
    String sqlInsertPoblacio2 = "INSERT INTO Poblacions (ordre, nomCiutat, nomClub, direccio, numTelf, latitut, longitut) " +
            "VALUES ('2','Alborache','C.A. Alborache Piccadilly', 'Pz España nº4 (Escuelas Antiguas) 46369 ALBORACHE','626516426',39.3929035,-0.7743851)";


    // The constructor: Create the database
    public MySQLiteHelper(Context context) {
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called if the DB is accessed but not yet created
    @Override
    public void onCreate(SQLiteDatabase db) {
        createSentences(db);
    }

    // Called, if the database version is increased in your application code.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlDeletePobalcions);
        db.execSQL(sqlCreatePoblacions);
        db.execSQL(sqlInsertPoblacio1);
        db.execSQL(sqlInsertPoblacio2);
    }

    protected void createSentences (SQLiteDatabase db) {
        db.execSQL(sqlCreatePoblacions);
        db.execSQL(sqlInsertPoblacio1);
        db.execSQL(sqlInsertPoblacio2);
    }

}
