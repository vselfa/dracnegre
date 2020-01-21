package com.example.dracnegre;

public class llistalocals {

        private String ordre;
        private String nomCiutat;
        private String nomClub;
        private String direccio;
        private String numTelf;
        private String latitut;
        private String longitut;


    public llistalocals(String ordre, String nomCiutat, String nomClub, String direccio, String numTelf, String latitut, String longitut) {
        this.ordre = ordre;
        this.nomCiutat = nomCiutat;
        this.nomClub = nomClub;
        this.direccio = direccio;
        this.numTelf = numTelf;
        this.latitut = latitut;
        this.longitut = longitut;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getNomCiutat() {
        return nomCiutat;
    }

    public void setNomCiutat(String nomCiutat) {
        this.nomCiutat = nomCiutat;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }

    public String getLatitut() {
        return latitut;
    }

    public void setLatitut(String latitut) {
        this.latitut = latitut;
    }

    public String getLongitut() {
        return longitut;
    }

    public void setLongitut(String longitut) {
        this.longitut = longitut;
    }

    @Override
    public String toString() {
        return "llistalocals{" +
                "ordre='" + ordre + '\'' +
                ", nomCiutat='" + nomCiutat + '\'' +
                ", nomClub='" + nomClub + '\'' +
                ", direccio='" + direccio + '\'' +
                ", numTelf='" + numTelf + '\'' +
                ", latitut='" + latitut + '\'' +
                ", longitut='" + longitut + '\'' +
                '}';
    }
}
