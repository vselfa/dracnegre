package com.example.dracnegre;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (id == R.id.competicio) {
            Intent intent = new Intent (this, Competicio.class);
            startActivity(intent);
        }
        if (id == R.id.DracA) {
            return true;
        }

        if (id == R.id.ResDracA) {
            Intent intent = new Intent (this, ResDracAActivity.class);
            startActivity(intent);
        }

        if (id == R.id.ClassDracA) {
            Intent intent = new Intent (this, ClasDracAActivity.class);
            startActivity(intent);
        }



        if (id == R.id.DracB) {
            return true;
        }

        if (id == R.id.ResDracB) {
            Intent intent = new Intent (this, ResDracBActivity.class);
            startActivity(intent);
        }

        if (id == R.id.ClassDracB) {
            Intent intent = new Intent (this, ClasDracBActivity.class);
            startActivity(intent);
        }

        if (id == R.id.DracC) {
            return true;
        }

        if (id == R.id.ResDracC) {
            Intent intent = new Intent (this, ResDracCActivity.class);
            startActivity(intent);
        }

        if (id == R.id.ClassDracC) {
            Intent intent = new Intent (this, ClasDracCActivity.class);
            startActivity(intent);
        }

        if (id == R.id.LocalsJoc) {
            Intent intent = new Intent (this, LocalsJoc.class);
            startActivity(intent);
        }

        if (id == R.id.mapaLocalsJoc) {
            Intent intent = new Intent (this, MapsPoblacionsActivity.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }

}
