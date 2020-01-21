package com.example.dracnegre.Model;

public  class ResultatEquip {
    String nomEquip;
    Integer puntsEquip;
    Integer puntsJugadors;

    public ResultatEquip(String nom, Integer pE, Integer pJ) {
        this.nomEquip = nom;
        this.puntsEquip = pE;
        this.puntsJugadors = pJ;
    }
    public String getNomEquip() {
        return nomEquip;
    }
    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }
    public Integer getPuntsEquip() {
        return puntsEquip;
    }
    public void setPuntsEquip(Integer puntsEquip) {
        this.puntsEquip = puntsEquip;
    }
    public Integer getPuntsJugadors() {
        return puntsJugadors;
    }
    public void setPuntsJugadors(Integer puntsJugadors) {
        this.puntsJugadors = puntsJugadors;
    }
}
