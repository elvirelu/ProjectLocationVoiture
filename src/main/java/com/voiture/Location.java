package com.voiture;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.voiture.voitures.ControllerVoiture;

public class Location {

    ControllerVoiture CtrV = ControllerVoiture.getControllerVoiture();
    private String idl;
    private String client;
    private String voiture;
    private Date dated;
    private Date datef;

    public Location(){}
    public Location(String idl, String client, String voiture, Date dated, Date datef) {
        this.idl = idl;
        this.client = client;
        this.voiture = voiture;
        this.dated = dated;
        this.datef = datef;
    }
    public String getIdl() {
        return idl;
    }
    public void setIdl(String idl) {
        this.idl = idl;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public String getVoiture() {
        return voiture;
    }
    public void setVoiture(String voiture) {
        this.voiture = voiture;
    }
    public Date getDated() {
        return dated;
    }
    public void setDated(Date dated) {
        this.dated = dated;
    }
    public Date getDatef() {
        return datef;
    }
    public void setDatef(Date datef) {
        this.datef = datef;
    }

    public int getDays(){

            int days = (int) ChronoUnit.DAYS.between(this.dated.toLocalDate(), this.datef.toLocalDate());

        return days;
    }

    public Float getCout(){
        Voitures v = new Voitures();
        v.setIdVoiture(voiture);
        List<Voitures> listeVoiture = CtrV.CtrV_Chercher(v);
        return listeVoiture.get(0).getPrix() * getDays();
    }


    @Override
    public String toString() {
        return "Location [idl=" + idl + ", client=" + client + ", voiture=" + voiture + ", dated=" + dated + ", datef="
                + datef + ", days=" + getDays() + ", cout=" + getCout() + "]";
    }

    // public final IntegerProperty daysProperty() { return new SimpleIntegerProperty(getDays()); }
   
}




