package com.voiture;

import java.util.List;
import com.voiture.voitures.ControllerVoiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController {
    ControllerVoiture CtrV = ControllerVoiture.getControllerVoiture();
    @FXML
    private TableView<Voitures> tableviewVoiture;

    @FXML
    private TableColumn<?, ?> colIdVoiture;

    @FXML
    private TableColumn<?, ?> colMarque;

    @FXML
    private TableColumn<?, ?> colModele;

    @FXML
    private TableColumn<?, ?> colCouleur;

    @FXML
    private TableColumn<?, ?> colPrix;

    @FXML
    private TableColumn<?, ?> colImmatriculation;

    @FXML
    private TableColumn<?, ?> colKilometrage;

    @FXML
    private TableColumn<?, ?> colStatut;

    @FXML
    private TextField idVoitureField;

    @FXML
    private TextField marqueField;

    @FXML
    private TextField modeleField;

    @FXML
    private TextField couleurField;

    @FXML
    private TextField prixField;

    @FXML
    private TextField immatriculationField;

    @FXML
    private TextField kilometrageField;

    @FXML
    private TextField statutField;

    @FXML
    public void initialize() {
        setColumn();
    }

    public void setColumn(){
        colIdVoiture.setCellValueFactory(new PropertyValueFactory<>("idVoiture"));
        colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        colModele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        colCouleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colImmatriculation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        colKilometrage.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
    }

    @FXML
    public void getRow(){
        Voitures v = tableviewVoiture.getSelectionModel().getSelectedItem();
        idVoitureField.setText(String.valueOf(v.getIdVoiture()));
        marqueField.setText(v.getMarque());
        modeleField.setText(v.getModele());
        couleurField.setText(v.getCouleur());
        prixField.setText(String.valueOf(v.getPrix()));
        immatriculationField.setText(v.getImmatriculation());
        kilometrageField.setText(String.valueOf(v.getKilometrage()));
        statutField.setText(v.getStatut());
    }

    @FXML
    void chercherVoiture(ActionEvent event) {
        String idVoiture = idVoitureField.getText();
        String marque = marqueField.getText();
        String immatriculation = immatriculationField.getText();
        Float prix = Float.parseFloat(prixField.getText());
        String statut = statutField.getText();
        Voitures v = new Voitures();
        v.setIdVoiture(idVoiture);
        v.setMarque(marque);
        v.setImmatriculation(immatriculation);
        v.setPrix(prix);
        v.setStatut(statut);
        List<Voitures> listeVoiture = CtrV.CtrV_Chercher(v);
        if (listeVoiture == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Erreur lors de la recherche");
            alert.show();
        }
        else{
            tableviewVoiture.getItems().clear();
            for(Voitures uneVoiture : listeVoiture){
                tableviewVoiture.getItems().add(uneVoiture);
            }
        }
    }

    @FXML
    void enregVoiture(ActionEvent event) {
        String idVoiture = idVoitureField.getText();
        String marque = marqueField.getText();
        String modele = modeleField.getText();
        String couleur = couleurField.getText();
        Float prix = Float.parseFloat(prixField.getText());
        String immatriculation = immatriculationField.getText();
        int kilometrage = Integer.parseInt(kilometrageField.getText());
        String statut = statutField.getText();
        Voitures v = new Voitures(idVoiture, marque, modele, couleur, immatriculation, kilometrage, prix, statut);
        if(CtrV.CtrV_ChercherID(v)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Le client existe déjà");
            alert.show();
        }
        else{
            String message = CtrV.CtrV_Enregistrer(v);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void listerVoiture(ActionEvent event) {
            tableviewVoiture.getItems().clear();
            List<Voitures> listeVoiture = CtrV.CtrV_GetAll();
            for(Voitures uneVoiture : listeVoiture){
                tableviewVoiture.getItems().add(uneVoiture);
            }
    }

    @FXML
    void modifierVoiture(ActionEvent event) {
        String idVoiture = idVoitureField.getText();
        String marque = marqueField.getText();
        String modele = modeleField.getText();
        String couleur = couleurField.getText();
        Float prix = Float.parseFloat(prixField.getText());
        String immatriculation = immatriculationField.getText();
        int kilometrage = Integer.parseInt(kilometrageField.getText());
        String statut = statutField.getText();
        Voitures v = new Voitures(idVoiture, marque, modele, couleur, immatriculation, kilometrage, prix, statut);
        if(!CtrV.CtrV_ChercherID(v)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Le client n'existe pas");
            alert.show();
        }
        else{
            String message = CtrV.CtrV_Modifier(v);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void supVoiture(ActionEvent event) {
        String message = "";
        Voitures v = new Voitures();
        v.setIdVoiture(idVoitureField.getText());
        if(!CtrV.CtrV_ChercherID(v)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Le client n'existe pas");
            alert.show();
        }
        else{
            message = CtrV.CtrV_Supprimer(v);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void reset(ActionEvent event){
        idVoitureField.clear();
        marqueField.clear();
        modeleField.clear();
        couleurField.clear();
        prixField.clear();
        immatriculationField.clear();
        kilometrageField.clear();
        statutField.clear();
    }
}

