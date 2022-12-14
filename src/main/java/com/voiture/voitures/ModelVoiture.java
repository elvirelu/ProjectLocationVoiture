package com.voiture.voitures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.voiture.Voitures;

public class ModelVoiture {
    private static Connection conn = null;
    private static ModelVoiture instanceModel = null;
    private static final String URL_BD = "jdbc:mysql://localhost/bdLocationVoiture";
    private static final String USAGER = "root";
    private static final String PASS = "";
    
    private static final String ENREGISTRER = "INSERT INTO voitures VALUES(?,?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM voitures";
    private static final String MODIFIER = "UPDATE voitures SET marque=?, modele=?, couleur=?, immatriculation=?, kilometrage=?, prix=?, statut=?  WHERE idVoiture=?";
    private static final String CHERCHER = "SELECT * FROM voitures WHERE idVoiture=? or marque=? or immatriculation=? or prix<=? or statut=?";
    private static final String CHERCHERID = "SELECT * FROM voitures WHERE idVoiture=?";
    private static final String SUPPRIMER = "DELETE FROM voitures WHERE idVoiture=?";

    private ModelVoiture(){}

    public static synchronized ModelVoiture getVoitureModel(){
        try{
            if(instanceModel == null){
                instanceModel = new ModelVoiture();
                // conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            }
            return instanceModel;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String MdlV_Enregistrer(Voitures voiture){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(ENREGISTRER);
            stmt.setString(1,voiture.getIdVoiture());
            stmt.setString(2,voiture.getMarque());
            stmt.setString(3,voiture.getModele());
            stmt.setString(4,voiture.getCouleur());
            stmt.setString(5,voiture.getImmatriculation());
            stmt.setInt(6,voiture.getKilometrage());
            stmt.setFloat(7,voiture.getPrix());
            stmt.setString(8,voiture.getStatut());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Voiture bien enregistrée";
    }

    public List<Voitures> MdlV_GetAll(){
        PreparedStatement stmt = null;
        List<Voitures> listeVoitures = new ArrayList<Voitures>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(GET_ALL);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Voitures voiture = new Voitures();
                voiture.setIdVoiture(rs.getString("idVoiture"));
                voiture.setMarque(rs.getString("marque"));
                voiture.setModele(rs.getString("modele"));
                voiture.setCouleur(rs.getString("couleur"));
                voiture.setImmatriculation(rs.getString("immatriculation"));
                voiture.setKilometrage(rs.getInt("kilometrage"));
                voiture.setPrix(rs.getFloat("prix"));
                voiture.setStatut(rs.getString("statut"));
                listeVoitures.add(voiture);
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeVoitures;
    }

    public String MdlV_Modifier(Voitures voiture){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setString(1,voiture.getMarque());
            stmt.setString(2,voiture.getModele());
            stmt.setString(3,voiture.getCouleur());
            stmt.setString(4,voiture.getImmatriculation());
            stmt.setInt(5,voiture.getKilometrage());
            stmt.setFloat(6,voiture.getPrix());
            stmt.setString(7,voiture.getStatut());
            stmt.setString(8,voiture.getIdVoiture());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Voiture bien modifiée";
    }

    public boolean MdlV_ChercherID(Voitures voiture){
        PreparedStatement stmt = null;
        boolean trouve;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(CHERCHERID);
            stmt.setString(1,voiture.getIdVoiture());
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

    public List<Voitures> MdlV_Chercher(Voitures voiture){
        PreparedStatement stmt = null;
        List<Voitures> listeVoitures = new ArrayList<Voitures>();
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(CHERCHER);
            stmt.setString(1,voiture.getIdVoiture());
            stmt.setString(2,voiture.getMarque());
            stmt.setString(3,voiture.getImmatriculation());
            stmt.setFloat(4,voiture.getPrix());
            stmt.setString(5,voiture.getStatut());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Voitures voiture1 = new Voitures();
                voiture1.setIdVoiture(rs.getString(1));
                voiture1.setMarque(rs.getString(2));
                voiture1.setModele(rs.getString(3));
                voiture1.setCouleur(rs.getString(4));
                voiture1.setImmatriculation(rs.getString(5));
                voiture1.setKilometrage(rs.getInt(6));
                voiture1.setPrix(rs.getFloat(7));
                voiture1.setStatut(rs.getString(8));
                listeVoitures.add(voiture1);
            }
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listeVoitures;
    }

    public String MdlV_Supprimer(Voitures voiture){
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setString(1,voiture.getIdVoiture());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return "Voiture bien supprimée";
    }


}
