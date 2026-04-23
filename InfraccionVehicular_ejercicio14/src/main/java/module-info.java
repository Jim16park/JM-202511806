module InfraccionVehicular {

    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens pe.edu.upeu to javafx.fxml;
    opens pe.edu.upeu.controller to javafx.fxml;

    exports pe.edu.upeu;
}