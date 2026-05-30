package pe.edu.upeu.controller;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.model.Infraccion;
import pe.edu.upeu.service.InfraccionService;


@Singleton
public class InfraccionController {
    @Inject
    InfraccionService cs;

    @FXML
    TableView<Infraccion> tabla;

    ObservableList<Infraccion> infraccion;
    private TableColumn<Infraccion, String> colPlaca, colNombre, colFecha, colTipo, colMonto, colEstado;

    @FXML private TextField txtPlaca, txtNombre, txtFecha, txtTipo, txtMonto;
    @FXML private Button btnAgregar, btnEditar, btnEliminar, btnLimpiar;
    int index=-1;
    String placa="";

    FilteredList<Infraccion> filteredData;
    @FXML
    public void initialize(){
        definirColumnas();
        listar();
        botonDesactivar(true);
        agregarEventoSeleccion();
        btnEditar.setOnAction(event->{
            agregar();
            index=-1;
            limpiar();
            listar();
            botonDesactivar(true);
            btnAgregar.setDisable(false);
        });
        btnAgregar.setOnAction(e->{
            agregar();
            index=-1;
            limpiar();
            listar();
        });
        btnEliminar.setOnAction(e->{
            limpiar();
            index=-1;
            botonDesactivar(true);
            btnAgregar.setDisable(false);
        });
        filtrarDatos();
    }

    void filtrarDatos(){
        filteredData=filteredData = new FilteredList<>(infraccion, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        txtMonto.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getPlaca().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });
// en filtrarDatos():
        SortedList<Infraccion> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tabla.comparatorProperty());
        tabla.setItems(sortedData);

// en agregarEventoSeleccion():
        tabla.getSelectionModel().selectedItemProperty();

// en listar():
        infraccion = FXCollections.observableArrayList(cs.findAll());
        tabla.setItems(infraccion);
    }

    void botonDesactivar(boolean estado){
        btnEditar.setDisable(estado);
        btnEliminar.setDisable(estado);
    }

    @FXML
    void eliminar(ActionEvent e){
        if(!placa.isEmpty()){
            cs.delete(placa);
            index=-1;
            limpiar();
            listar();
            botonDesactivar(true);
            btnAgregar.setDisable(false);
        }
    }

    void limpiar(){
        txtPlaca.setText("");
        txtNombre.setText("");
        txtFecha.setText("");
        txtTipo.setText("");
        txtMonto.setText("");
        tabla.getSelectionModel().clearSelection();
    }

    void agregar(){
        Infraccion c=new Infraccion();
        c.setPlaca(txtPlaca.getText());
        c.setNombre(txtNombre.getText());
        c.setFecha(txtFecha.getText());
        c.setTipo(txtTipo.getText());
        c.setMonto(Double.valueOf(txtMonto.getText()));

        if(index==-1 && !c.getPlaca().isEmpty()){
            cs.save(c);
        }else{
            if(index==-1){
                System.out.println("sdsdsd");
                Alert a=new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.show();
            }else{
                c.setPlaca(c.getPlaca());
                cs.update(c);
            }


        }
    }
    public void agregarEventoSeleccion(){
        tabla.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue)->{
                    if(newValue!=null){
                        index=tabla.getItems().indexOf(newValue);
                        placa=newValue.getPlaca();
                        txtPlaca.setText(newValue.getPlaca());
                        txtNombre.setText(newValue.getNombre());
                        txtFecha.setText(newValue.getFecha());
                        txtTipo.setText(newValue.getTipo());
                        txtMonto.setText(String.valueOf(newValue.getMonto()));
                        botonDesactivar(false);
                        btnAgregar.setDisable(true);
                    }
                });
    }

    public void definirColumnas(){
        colPlaca=new TableColumn<>("Placa");
        colNombre=new TableColumn<>("Nombre");
        colFecha=new TableColumn<>("Fecha");
        colTipo=new TableColumn<>("Tipo");
        colMonto=new TableColumn<>("Monto");
        colEstado=new TableColumn<>("Estado");
        tabla.getColumns().addAll(colPlaca, colNombre, colFecha, colTipo, colMonto, colEstado);
    }

    public void listar(){
        colPlaca.setCellValueFactory(cetCell->new SimpleStringProperty(cetCell.getValue().getPlaca()));

        colNombre.setCellValueFactory(cetCell->new SimpleStringProperty(cetCell.getValue().getNombre()));
        colFecha.setCellValueFactory(cetCell->new SimpleStringProperty(cetCell.getValue().getFecha()));
        colTipo.setCellValueFactory(cetCell->new SimpleStringProperty(cetCell.getValue().getTipo()));
        colMonto.setCellValueFactory(cetCell ->
                new SimpleStringProperty(String.valueOf(cetCell.getValue().getMonto())));
        colEstado.setCellValueFactory(cetCell->new SimpleStringProperty(cetCell.getValue().getEstado()));
        infraccion= FXCollections.observableArrayList(cs.findAll());
        tabla.setItems(infraccion);
    }



}
