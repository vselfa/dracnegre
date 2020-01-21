package com.example.dracnegre;

public class llistaJugadors {
    private String ordre;
    private String nomCognoms;
    private String elo;
    private int idPhoto;

    public llistaJugadors(String ordre, String nomCognoms, String elo, int idPhoto) {
        this.ordre = ordre;
        this.nomCognoms = nomCognoms;
        this.elo = elo;
        this.idPhoto = idPhoto;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getNomCognoms() {
        return nomCognoms;
    }

    public void setNomCognoms(String nomCognoms) {
        this.nomCognoms = nomCognoms;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    @Override
    public String toString() {
        return "llistaJugadors{" +
                "ordre='" + ordre + '\'' +
                ", nomCognoms='" + nomCognoms + '\'' +
                ", elo='" + elo + '\'' +
                ", idPhoto=" + idPhoto +
                '}';
    }
}

