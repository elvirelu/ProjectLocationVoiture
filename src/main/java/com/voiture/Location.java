package com.voiture;

import java.time.LocalDate;

public class Location {
    private String numeroLocation;
    private String matricule;
    private String idVoiture;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double coutTotal;
    private String nom;
    private String marque;
    private String modele;

    public Location(Client client, Voitures voiture, LocalDate dateDebut, LocalDate dateFin) {
        this.numeroLocation = numeroLocation;
        this.matricule = matricule;
        this.idVoiture = idVoiture;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.coutTotal = calculerCoutTotal();
        this.matricule = nom;
        this.idVoiture = idVoiture;
        this.marque = marque;
        this.modele = modele;
    }

    
    public String getNumeroLocation() {
        return numeroLocation;
    }


    public void setNumeroLocation(String numeroLocation) {
        this.numeroLocation = numeroLocation;
    }


    public String getMatricule() {
        return matricule;
    }


    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public String getIdVoiture() {
        return idVoiture;
    }


    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }


    public LocalDate getDateDebut() {
        return dateDebut;
    }


    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }


    public LocalDate getDateFin() {
        return dateFin;
    }


    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }


    public double getCoutTotal() {
        return coutTotal;
    }


    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
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


    private double calculerCoutTotal() {
        // Calculez le coût total de la location en fonction du tarif de location de la voiture,
        // des dates de début et de fin et des éventuels rabais pour le client.
        // Cette implémentation dépendra de vos exigences spécifiques.
        // Vous voudrez peut-être également inclure des frais ou surcharges supplémentaires dans le coût total.
    }


    public void setPermis(String permis) {
    }
}




