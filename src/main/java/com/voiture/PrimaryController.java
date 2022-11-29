package com.voiture;

import java.util.List;
import com.voiture.clients.ControllerClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController{
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
        setColumn();
    }

    public void setColumn(){
        colMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPermis.setCellValueFactory(new PropertyValueFactory<>("permis"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colTele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
    }

    @FXML
    public void getRow(){
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
    void reset(ActionEvent event){
        matriculeField.clear();
        nomField.clear();
        permisField.clear();
        adresseField.clear();
        teleField.clear();
    }

}

