module com.voiture {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.voiture to javafx.fxml;
    exports com.voiture;
}
