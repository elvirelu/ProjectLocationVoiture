package com.voiture.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.voiture.Client;

public class ModelLocation {
    private static Connection conn = null;
    private static ModelLocation instanceModel = null;
    private static final String URL_BD = "jdbc:mysql://localhost/bdLocationVoiture";
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String ENREGISTRER = "INSERT INTO clients VALUES(?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM clients";
    private static final String MODIFIER = "UPDATE clients SET nom=?, permis=?, adresse=?, telephone=? WHERE matricule=?";
    private static final String CHERCHER = "SELECT * FROM clients WHERE matricule=? or nom=? or permis=?";
    private static final String CHERCHERID = "SELECT * FROM clients WHERE matricule=?";
    private static final String SUPPRIMER = "DELETE FROM clients WHERE matricule=?";

    private ModelLocation(){}

    public static synchronized ModelLocation getLocationModel(){
        try{
            if(instanceModel == null){
                instanceModel = new ModelLocation();
                // conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            }
            return instanceModel;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String MdlC_Enregistrer(Location location){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(ENREGISTRER);
            stmt.setString(1,location.getNumeroLocation());
            stmt.setString(2,location.getMatricule());
            stmt.setString(3,location.getIdVoiture());
            stmt.setString(4,location.getDateDebut());
            stmt.setString(5,location.getDateFin());
            stmt.setString(6,location.getCoutTotal());
            stmt.setString(7,location.getNom());
            stmt.setString(8,location.getMarque());
            stmt.setString(9,location.getModele());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Location bien enregistré";
    }

    public List<Location> MdlC_GetAll(){
        PreparedStatement stmt = null;
        List<Client> listeLocation = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Location location = new Location();
                location.setNumeroLocation(rs.getString(1));
                location.setMatricule(rs.getString(2));
                location.setIdVoiture(rs.getString(3));
                location.setDateDebut(rs.getString(4));
                location.setDateFin(rs.getString(5));
                location.setCoutTotal(rs.getString(6));
                location.setNom(rs.getString(7));
                location.setIdMarque(rs.getString(8));
                location.setgetModele(rs.getString(9));
                location.add(location);
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeLocation;
    }

    public String MdlC_Modifier(Location location){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setString(1,location.getNumeroLocation());
            stmt.setString(2,location.getMatricule());
            stmt.setString(3,location.getIdVoiture());
            stmt.setString(4,location.getDateDebut());
            stmt.setString(5,location.getDateFin());
            stmt.setString(6,location.getCoutTotal());
            stmt.setString(7,location.getNom());
            stmt.setString(8,location.getMarque());
            stmt.setString(9,location.getModele());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Location bien modifié";
    }

    public boolean MdlC_ChercherID(Location location){
        PreparedStatement stmt = null;
        boolean trouve;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(CHERCHERID);
            stmt.setString(1, location.getMatricule());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                trouve = true;
            }
            else{
                trouve = false;
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return trouve;
    }

    public List<Location> MdlC_Chercher(Location location){
        PreparedStatement stmt = null;
        List<Location> listeLocation = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(CHERCHER);
            stmt.setString(1,location.getNumeroLocation());
            stmt.setString(2,location.getMatricule());
            stmt.setString(3,location.getIdVoiture());
            stmt.setString(4,location.getDateDebut());
            stmt.setString(5,location.getDateFin());
            stmt.setString(6,location.getCoutTotal());
            stmt.setString(7,location.getNom());
            stmt.setString(8,location.getMarque());
            stmt.setString(9,location.getModele());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()==false){
                listeLocation = null;
            }else{
                do{
                Client uneLocation = new Location();
                location.setNumeroLocation(rs.getString(1));
                location.setMatricule(rs.getString(2));
                location.setIdVoiture(rs.getString(3));
                location.setDateDebut(rs.getString(4));
                location.setDateFin(rs.getString(5));
                location.setCoutTotal(rs.getString(6));
                location.setNom(rs.getString(7));
                location.setIdMarque(rs.getString(8));
                location.setgetModele(rs.getString(9));
                listeLocation.add(uneLocation);
                }while(rs.next());
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeLocation;
    }

    public String MdlC_Supprimer(Location location){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setString(1,Location.getNumeroLocation());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Location bien supprimé";
    }

}
