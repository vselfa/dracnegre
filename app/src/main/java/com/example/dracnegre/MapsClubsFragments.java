package com.example.dracnegre;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MapsClubsFragments extends MainMenu
        //implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener
{

    // Veure MapsPoblacionsActivity

        /*private GoogleMap mMap;
        static final LatLng CARCAIXENT  = new LatLng(39.119223, -0.453422);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.mapPoblacions);
            mapFragment.getMapAsync(this);

            myPoblacionsDAO = new poblacionsDAO(this);
            poblacions = myPoblacionsDAO.getPoblacions();
            Log.d ("pobles", "Pobles onCreate: ");
        }

        @Override
        protected void onResume() {
            super.onResume();
            // To update poblacions after update the table
            poblacions = myPoblacionsDAO.getPoblacions();
            Log.d ("pobles", "Pobles onResume: ");

        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            mMap.setOnMarkerClickListener(this);

            // Showing Poblacions
            for (int i=0; i < poblacions.size(); i++) {
                Log.d ("pobles", "Poble: " + poblacions.get(i).getPoblacio());
                latLng = new LatLng(poblacions.get(i).getLat(), poblacions.get(i).getLon());
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(poblacions.get(i).getPoblacio())
                );
            }
            Log.d ("pobles", "Pobles fora del for " );
            // Move the camera instantly to CARCAIXENT with a zoom of 10.
            // Center position of the map: the last poblacioLatLon
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CARCAIXENT, 10));
            // Zoom in, animating the camera.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
            Log.d ("pobles", "Pobles final  onMapReady " );

        }

        @Override
        public boolean onMarkerClick(Marker marker) {
            // Intent for calling  MapsFarmaciesActivity
            Intent intent = new Intent(this, FarmaciesActivity.class);
            //Getting the information to send to the other activity
            Bundle b = new Bundle();
            b.putString("Poblacio", marker.getId());
            intent.putExtras(b); //Adding the information to the intent
            startActivity(intent); //Starting the new activity
            return false;
        }

    }



    public void showClients(View view) {

        // Managing the DB.
        // Opt 1: The last db. Opt 2: the new one with restrictions: primary key + not null values
        connexion = new MySQLiteHelper(this, MainActivity.DATABASE_NAME, MainActivity.DATABASE_VERSION, MainActivity.dbNumber);
        db = connexion.getWritableDatabase();

        Log.d("db", "Name:" + MainActivity.DATABASE_NAME + " Number: " + MainActivity.dbNumber);

        // A Cursor to get the result of the query
        Cursor c = db.rawQuery("SELECT codi, nom, lat, lon  FROM Clients", null);
        list.setText("List of clients: \n");
        // Moving across all the rows
        if (c.moveToFirst()) {
            do {
                String cod = c.getString(0); String nom = c.getString(1);
                String lat = c.getString(2); String lon = c.getString(3);
                list.append(" " + cod + " " + nom + " " + lat + " " + lon + "\n");
                Log.i("sql", "Clients: " + nom);
            } while(c.moveToNext());
        }
    }*/
}
