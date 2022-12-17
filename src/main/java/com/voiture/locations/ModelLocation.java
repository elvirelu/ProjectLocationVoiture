package com.voiture.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.voiture.Location;

public class ModelLocation {
    private static Connection conn = null;
    private static ModelLocation instanceModel = null;
    private static final String URL_BD = "jdbc:mysql://localhost/bdLocationVoiture";
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String ENREGISTRER = "INSERT INTO locations VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM locations";
    private static final String MODIFIER = "UPDATE locations SET client=?, voiture=?, dated=?, datef=? WHERE idl=?";
    private static final String CHERCHER = "SELECT * FROM locations WHERE idl=? or client=? or voiture=?";
    private static final String CHERCHERID = "SELECT * FROM locations WHERE idl=?";
    private static final String SUPPRIMER = "DELETE FROM locations WHERE idl=?";
    private static final String GET_IDCLIENT = "SELECT matricule FROM clients";
    private static final String GET_IDVOITURE = "SELECT idVoiture FROM voitures";
    // private static final String GET_PRIX = "SELECT prix FROM voitures WHERE idVoiture=?";

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

    public List<String> MdlL_GetIdClient(){
        PreparedStatement stmt = null;
        List<String> listeIdClient = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(GET_IDCLIENT);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                listeIdClient.add(rs.getString(1));
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeIdClient;
    }

    public List<String> MdlL_GetIdVoiture(){
        PreparedStatement stmt = null;
        List<String> listeIdVoiture = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(GET_IDVOITURE);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                listeIdVoiture.add(rs.getString(1));
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeIdVoiture;
    }

    // public float MdlL_GetPrix(Location location){
    //     PreparedStatement stmt = null;
    //     float prix = 0;
    //     try{
    //         conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
    //         stmt = conn.prepareStatement(GET_PRIX);
    //         stmt.setString(1,location.getVoiture());
    //         ResultSet rs = stmt.executeQuery();
    //         if(rs.next()){
    //             prix = rs.getFloat(1);
    //         }
    //         stmt.close();
    //     }catch(SQLException e){
    //         throw new RuntimeException(e);
    //     }
    //     return prix;
    // }

    public String MdlL_Enregistrer(Location location){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(ENREGISTRER);
            stmt.setString(1,location.getIdl());
            stmt.setString(2,location.getClient());
            stmt.setString(3,location.getVoiture());
            stmt.setDate(4,location.getDated());
            stmt.setDate(5,location.getDatef());
            stmt.setInt(6,location.getDays());
            stmt.setFloat(7,location.getCout());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Location bien enregistré";
    }

    public List<Location> MdlL_GetAll(){
        PreparedStatement stmt = null;
        List<Location> listeLocation = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Location location = new Location();
                location.setIdl(rs.getString(1));
                location.setClient(rs.getString(2));
                location.setVoiture(rs.getString(3));
                location.setDated(rs.getDate(4));
                location.setDatef(rs.getDate(5));
                listeLocation.add(location);
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeLocation;
    }

    public String MdlL_Modifier(Location location){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setString(1,location.getClient());
            stmt.setString(2,location.getVoiture());
            stmt.setDate(3,location.getDated());
            stmt.setDate(4,location.getDatef());
            stmt.setString(5,location.getIdl());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Location bien modifié";
    }

    public boolean MdlL_ChercherID(Location location){
        PreparedStatement stmt = null;
        boolean trouve;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(CHERCHERID);
            stmt.setString(1, location.getIdl());
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

    public List<Location> MdlL_Chercher(Location location){
        PreparedStatement stmt = null;
        List<Location> listeLocation = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(CHERCHER);
            stmt.setString(1,location.getIdl());
            stmt.setString(2,location.getClient());
            stmt.setString(3,location.getVoiture());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Location uneLocation = new Location();
                uneLocation.setIdl(rs.getString(1));
                uneLocation.setClient(rs.getString(2));
                uneLocation.setVoiture(rs.getString(3));
                uneLocation.setDated(rs.getDate(4));
                uneLocation.setDatef(rs.getDate(5));
                listeLocation.add(uneLocation);
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeLocation;
    }

    public String MdlL_Supprimer(Location location){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setString(1,location.getIdl());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Location bien supprimé";
    }

}
