package com.example.dracnegre;

import com.example.dracnegre.Model.Punts;
import com.example.dracnegre.Model.ResultatEquip;

import java.util.ArrayList;

public interface MyCallback {
        void onCallback(ArrayList<ResultatEquip> equips);
        //int totalEquips(ArrayList<Punts> equips);
}