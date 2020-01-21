package com.example.dracnegre.Model;

public  class ResultatEquipAmbFoto {
    String fotoEquip;  // El nom de la foto sense extensió
    String nomEquip;
    Integer puntsEquip;
    Integer puntsJugadors;

    public ResultatEquipAmbFoto(String foto, String nom, Integer pE, Integer pJ) {
        this.fotoEquip = foto;
        this.nomEquip = nom;
        this.puntsEquip = pE;
        this.puntsJugadors = pJ;
    }
    public String getFotoEquip() {
        return fotoEquip;
    }
    public void setFotoEquip(String fotoEquip) {
        this.fotoEquip = fotoEquip;
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
