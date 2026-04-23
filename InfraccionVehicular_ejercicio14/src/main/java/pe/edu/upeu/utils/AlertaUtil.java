package pe.edu.upeu.utils;

import javafx.scene.control.Alert;

public class AlertaUtil {

    public static void mostrarInfo(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        alert.setTitle("Sistema de Infracciones");
        alert.setHeaderText("Operación exitosa");
    }

    public static void mostrarError(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}