package com.voiture;

public class Voitures {
    private String idVoiture;
    private String marque;
    private String modele;
    private String couleur;
    private String immatriculation;
    private int kilometrage;
    private Float prix;
    private String statut;

    public Voitures(){}

    public Voitures(String idVoiture, String marque, String modele, String couleur, String immatriculation, int kilometrage, Float prix, String statut) {
        this.idVoiture = idVoiture;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.statut = statut;
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override

    public String toString() {
        return "Voitures [idVoiture=" + idVoiture + ", marque=" + marque + ", modele=" + modele + ", couleur=" + couleur
                + ", immatriculation=" + immatriculation + ", kilometrage=" + kilometrage + ", prix=" + prix + ", statut="
                + statut + "]";
    }
}
