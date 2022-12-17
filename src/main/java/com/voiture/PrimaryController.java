package com.voiture;

import java.sql.Date;
import java.time.ZoneOffset;
import java.util.List;
import com.voiture.clients.ControllerClient;
import com.voiture.locations.ControllerLocation;
import com.voiture.voitures.ControllerVoiture;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController{

    //controllerClient
    ControllerClient CtrC = ControllerClient.getControllerClient();
    @FXML
    private TableView<Client> tableviewClient;

    @FXML
    private TableColumn<?, ?> colAdresse;

    @FXML
    private TableColumn<?, ?> colMatricule;

    @FXML
    private TableColumn<?, ?> colNom;

    @FXML
    private TableColumn<?, ?> colPermis;

    @FXML
    private TableColumn<?, ?> colTele;

    @FXML
    private TextField matriculeField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField permisField;

    @FXML
    private TextField adresseField;

    @FXML
    private TextField teleField;

    @FXML
    public void initialize() {
        setColumnClient();
        setColumnVoiture();
        setColumnLocation();
        rempliClientCombo();
        rempliVoitureCombo();
    }

    public void setColumnClient(){
        colMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPermis.setCellValueFactory(new PropertyValueFactory<>("permis"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colTele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
    }

    @FXML
    public void getRowClient(){
        Client client = tableviewClient.getSelectionModel().getSelectedItem();
        if(client != null){   
            matriculeField.setText(client.getMatricule());
            nomField.setText(client.getNom());
            permisField.setText(client.getPermis());
            adresseField.setText(client.getAdresse());
            teleField.setText(client.getTelephone());
        }
    }

    @FXML
    void chercherClient(ActionEvent event) {
        String matricule = matriculeField.getText();
        String nom = nomField.getText();
        String permis = permisField.getText();
        Client client = new Client();
        client.setMatricule(matricule);
        client.setNom(nom);
        client.setPermis(permis);
        List<Client> listeClient = CtrC.CtrC_Chercher(client);
        if(listeClient == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Client n'exist pas");
            alert.show();
        }
        else{
            tableviewClient.getItems().clear();
            for(Client unClient: listeClient){
                tableviewClient.getItems().add(unClient);
            } 
        }
    }

    @FXML
    void enregClient(ActionEvent event) {
        String matricule = matriculeField.getText();
        String nom = nomField.getText();
        String permis = permisField.getText();
        String adresse = adresseField.getText();
        String telephone = teleField.getText();
        Client client = new Client(matricule, nom, permis, adresse, telephone);
        if(CtrC.CtrC_ChercherID(client)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Client exist");
            alert.show();
        }
        else{
            String message = CtrC.CtrC_Enregistrer(client);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void listerClient(ActionEvent event) {
        tableviewClient.getItems().clear();
        List<Client> listeClient = CtrC.CtrC_GetAll();
        for(Client client: listeClient){
            tableviewClient.getItems().add(client);
        } 
    }

    @FXML
    void modifierClient(ActionEvent event) {
        String matricule = matriculeField.getText();
        String nom = nomField.getText();
        String permis = permisField.getText();
        String adresse = adresseField.getText();
        String telephone = teleField.getText();
        Client client = new Client(matricule, nom, permis, adresse, telephone);
        if(!CtrC.CtrC_ChercherID(client)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Client n'exist pas");
            alert.show();
        }
        else{
            String message = CtrC.CtrC_Modifier(client);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void supClient(ActionEvent event) {
        String message = "";
        Client client = new Client();
        client.setMatricule(matriculeField.getText());
        if(!CtrC.CtrC_ChercherID(client)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Client n'exist pas");
            alert.show();
        }
        else{
            message = CtrC.CtrC_Supprimer(client);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void resetClient(ActionEvent event){
        matriculeField.clear();
        nomField.clear();
        permisField.clear();
        adresseField.clear();
        teleField.clear();
    }

//controllerVoiture
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

    public void setColumnVoiture(){
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
    public void getRowVoiture(){
        Voitures v = tableviewVoiture.getSelectionModel().getSelectedItem();
        if(v != null){   
            idVoitureField.setText(String.valueOf(v.getIdVoiture()));
            marqueField.setText(v.getMarque());
            modeleField.setText(v.getModele());
            couleurField.setText(v.getCouleur());
            prixField.setText(String.valueOf(v.getPrix()));
            immatriculationField.setText(v.getImmatriculation());
            kilometrageField.setText(String.valueOf(v.getKilometrage()));
            statutField.setText(v.getStatut());
        }
    }

    @FXML
    void chercherVoiture(ActionEvent event) {
        String idVoiture = idVoitureField.getText();
        String marque = marqueField.getText();
        String immatriculation = immatriculationField.getText();
        String statut = statutField.getText();
        Voitures v = new Voitures();
        v.setIdVoiture(idVoiture);
        v.setMarque(marque);
        v.setImmatriculation(immatriculation);
        if(prixField.getText()!=""){
            v.setPrix(Float.parseFloat(prixField.getText()));
        }
        // else{
        //     v.setPrix((float) 0);
        // }
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
    void resetVoiture(ActionEvent event){
        idVoitureField.clear();
        marqueField.clear();
        modeleField.clear();
        couleurField.clear();
        prixField.clear();
        immatriculationField.clear();
        kilometrageField.clear();
        statutField.clear();
    }

    //controllerLocation
    ControllerLocation CtrL = ControllerLocation.getControllerLocation();
    @FXML
    private TableView<Location> tableviewLocation;

    @FXML
    private TableColumn<?, ?> colIdl;

    @FXML
    private TableColumn<?, ?> colClient;

    @FXML
    private TableColumn<?, ?> colVoiture;

    @FXML
    private TableColumn<?, ?> colDated;

    @FXML
    private TableColumn<?, ?> colDatef;

    @FXML
    private TableColumn<?, ?> colDays;

    @FXML
    private TableColumn<?, ?> colCout;

    @FXML
    private Label labelClient;

    @FXML
    private Label labelVoiture;

    @FXML
    private TextField idlField;

    @FXML
    private ComboBox<String> voitureCombo;
    
    @FXML
    private ComboBox<String> clientCombo;

    @FXML
    private DatePicker datedPicker;

    @FXML
    private DatePicker datefPicker;

    public void setColumnLocation(){
        colIdl.setCellValueFactory(new PropertyValueFactory<>("idl"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("client"));
        colVoiture.setCellValueFactory(new PropertyValueFactory<>("voiture"));
        colDated.setCellValueFactory(new PropertyValueFactory<>("dated"));
        colDatef.setCellValueFactory(new PropertyValueFactory<>("datef"));
        colDays.setCellValueFactory(new PropertyValueFactory<>("days"));
        colCout.setCellValueFactory(new PropertyValueFactory<>("cout"));
    }

    
    void rempliClientCombo(){
        List<String> listeIdClient = CtrL.CtrL_GetIdClient();
        for(String idClient: listeIdClient){
            clientCombo.getItems().add(idClient);
        }
    }

    @FXML
    void comboClientInfo(){
        String clientSelected = clientCombo.getSelectionModel().getSelectedItem();
        Client client = new Client();
        client.setMatricule(clientSelected);
        List<Client> listeClient = CtrC.CtrC_Chercher(client);
        if(clientCombo.getValue() != null) {
            labelClient.setText(listeClient.get(0).getNom());
        }
    }

    void rempliVoitureCombo(){
        List<String> listeIdVoiture = CtrL.CtrL_GetIdVoiture();
        for(String idVoiture: listeIdVoiture){
            voitureCombo.getItems().add(idVoiture);
        }
    }

    @FXML
    void comboVoitureInfo(){
        String voitureSelected = voitureCombo.getSelectionModel().getSelectedItem();
        Voitures voiture = new Voitures();
        voiture.setIdVoiture(voitureSelected);
        List<Voitures> listeVoiture = CtrV.CtrV_Chercher(voiture);
        if(voitureCombo.getValue() != null){
            Voitures v = listeVoiture.get(0);
            labelVoiture.setText(v.getMarque() + " " + v.getModele() + " " + v.getCouleur());
        }
    }

    @FXML
    void chercherLocation(ActionEvent event) {
        String idl = idlField.getText();
        String client = clientCombo.getSelectionModel().getSelectedItem();
        String voiture = voitureCombo.getSelectionModel().getSelectedItem();
        Location location = new Location();
        location.setIdl(idl);
        location.setClient(client);
        location.setVoiture(voiture);
        List<Location> listeLocation = CtrL.CtrL_Chercher(location);
        if(listeLocation == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Location n'exist pas");
            alert.show();
        }
        else{
            tableviewLocation.getItems().clear();
            for(Location unelocation: listeLocation){
                // System.out.println(unelocation);
                tableviewLocation.getItems().add(unelocation);
            } 
        }
    }

    @FXML
    void enregLocation(ActionEvent event) {
        String idl = idlField.getText();
        String client = clientCombo.getSelectionModel().getSelectedItem();
        String voiture = voitureCombo.getSelectionModel().getSelectedItem();
        Date dated = new Date(Date.from(datedPicker.getValue().atStartOfDay(ZoneOffset.UTC).toInstant()).getTime());
        Date datef = new Date(Date.from(datefPicker.getValue().atStartOfDay(ZoneOffset.UTC).toInstant()).getTime());

        Location location = new Location(idl, client, voiture, dated, datef);
        if(CtrL.CtrL_ChercherID(location)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Location exist");
            alert.show();
        }
        else{      
            String message = CtrL.CtrL_Enregistrer(location);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void listerLocation(ActionEvent event) {
        tableviewLocation.getItems().clear();
        List<Location> listeLocation = CtrL.CtrL_GetAll();
        for(Location location: listeLocation){
            tableviewLocation.getItems().add(location);
        } 
    }

    @FXML
    void modifierLocation(ActionEvent event) {
        String idl = idlField.getText();
        String client = clientCombo.getSelectionModel().getSelectedItem();
        String voiture = voitureCombo.getSelectionModel().getSelectedItem();
        Date dated = (Date) Date.from(datedPicker.getValue().atStartOfDay(ZoneOffset.UTC).toInstant());
        Date datef = (Date) Date.from(datefPicker.getValue().atStartOfDay(ZoneOffset.UTC).toInstant());
        Location location = new Location(idl, client, voiture, dated, datef);
        if(!CtrL.CtrL_ChercherID(location)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Location n'exist pas");
            alert.show();
        }
        else{
            String message = CtrL.CtrL_Modifier(location);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void supLocation(ActionEvent event) {
        String message = "";
        Location location = new Location();
        location.setIdl(idlField.getText());
        if(!CtrL.CtrL_ChercherID(location)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Location n'exist pas");
            alert.show();
        }
        else{
            message = CtrL.CtrL_Supprimer(location);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.show();
        }
    }

    @FXML
    void resetLocation(ActionEvent event){
        Platform.runLater(() -> {
            idlField.clear();
            clientCombo.getSelectionModel().clearSelection();
            voitureCombo.getSelectionModel().clearSelection();
            labelClient.setText("");
            labelVoiture.setText("");
            datedPicker.getEditor().clear();
            datefPicker.getEditor().clear();
        });
        
    }

}


    


