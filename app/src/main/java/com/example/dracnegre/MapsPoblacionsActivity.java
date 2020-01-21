package com.example.dracnegre;

import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.dracnegre.Model.MySQLiteHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPoblacionsActivity extends MainMenu implements  OnMapReadyCallback, GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;

    // Creating and opening the database Empresa, table Clients
    MySQLiteHelper connexion;
    SQLiteDatabase db ;
    private LatLng latLng, lastLatLong;
    String lastCiutat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_poblacions);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Managing the DB.
        connexion = new MySQLiteHelper(this );
        db = connexion.getWritableDatabase();

        // A Cursor to get the result of the query
        Cursor c = db.rawQuery("SELECT ordre, nomCiutat, latitut, longitut  FROM Poblacions", null);
        // Moving across all the rows
        if (c.moveToFirst()) {
            do {
                String ciutat = c.getString(1);
                latLng = new LatLng(c.getDouble(2), c.getDouble(3));
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(ciutat)
                );
                lastLatLong = latLng;
                lastCiutat = ciutat;
            } while(c.moveToNext());
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(lastLatLong));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
