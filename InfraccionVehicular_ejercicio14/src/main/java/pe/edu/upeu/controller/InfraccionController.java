package pe.edu.upeu.controller;

import javafx.beans.property.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.model.Infraccion;
import pe.edu.upeu.repository.InfraccionRepository;

import static pe.edu.upeu.utils.AlertaUtil.mostrarError;
import static pe.edu.upeu.utils.AlertaUtil.mostrarInfo;

public class InfraccionController {

    @FXML private TextField txtPlaca, txtNombre, txtFecha, txtTipo, txtMonto;
    @FXML private ComboBox<String> cbEstado, cbFiltroEstado, cbNuevoEstado;
    @FXML private TableView<Infraccion> tabla;

    @FXML private TableColumn<Infraccion, Number> colIndex;
    @FXML private TableColumn<Infraccion, String> colPlaca, colNombre, colFecha, colTipo, colEstado;
    @FXML private TableColumn<Infraccion, Double> colMonto;

    @FXML private Label lblTotal;

    private InfraccionRepository repo = new InfraccionRepository();
    private ObservableList<Infraccion> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        cbEstado.getItems().addAll("Pendiente", "Pagada");
        cbFiltroEstado.getItems().addAll("Todos", "Pendiente", "Pagada");
        cbNuevoEstado.getItems().addAll("Pendiente", "Pagada");

        colPlaca.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPlaca()));
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getInfractor()));
        colFecha.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getFecha()));
        colTipo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTipo()));
        colMonto.setCellValueFactory(d -> new SimpleObjectProperty<>(d.getValue().getMonto()));
        colEstado.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEstado()));

        // columna #
        colIndex.setCellValueFactory(d ->
                new SimpleIntegerProperty(tabla.getItems().indexOf(d.getValue()) + 1)
        );

        tabla.setItems(lista);

        actualizarTotal();

        Infraccion i1 = new Infraccion("ABC-123","Juan Perez","20/05/2025","Exceso de velocidad",250.0,"Pendiente");
        Infraccion i2 = new Infraccion("DEF-456","Maria Lopez","18/05/2025","No usar cinturón",150.0,"Pagada");

        repo.guardar(i1);
        repo.guardar(i2);

        lista.addAll(i1, i2);
    }

    @FXML
    public void agregar() {

        double monto;
        if (txtMonto.getText().isEmpty()) {
            mostrarError("Ingrese el monto");
            return;
        }

            try {
                monto = Double.parseDouble(txtMonto.getText());

                Infraccion i = new Infraccion(
                        txtPlaca.getText(),
                        txtNombre.getText(),
                        txtFecha.getText(),
                        txtTipo.getText(),
                        monto,
                        cbEstado.getValue()
                );

                repo.guardar(i);
                lista.add(i);

                mostrarInfo("Infracción agregada correctamente");

                limpiar();

            } catch (NumberFormatException e) {
                mostrarError("El monto debe ser numérico");
            }
        }

    public void eliminar() {

        int index = tabla.getSelectionModel().getSelectedIndex();

        if(index >= 0){
            repo.eliminar(index);
            lista.remove(index);
            actualizarTotal();
        }
    }

    public void filtrar() {

        String estado = cbFiltroEstado.getValue();

        if(estado.equals("Todos")){
            lista.setAll(repo.listar());
        } else {
            lista.setAll(repo.filtrarPorEstado(estado));
        }
    }

    public void actualizarEstado() {

        Infraccion i = tabla.getSelectionModel().getSelectedItem();

        if(i != null){
            i.setEstado(cbNuevoEstado.getValue());
            tabla.refresh();
        }
    }

    public void limpiar() {

        txtPlaca.clear();
        txtNombre.clear();
        txtFecha.clear();
        txtTipo.clear();
        txtMonto.clear();
        cbEstado.setValue(null);
    }

    @FXML
    public void editar(){
        Infraccion i = tabla.getSelectionModel().getSelectedItem();

        if(i != null){
            txtPlaca.setText(i.getPlaca());
            txtNombre.setText(i.getInfractor());
            txtFecha.setText(i.getFecha());
            txtTipo.setText(i.getTipo());
            txtMonto.setText(String.valueOf(i.getMonto()));
            cbEstado.setValue(i.getEstado());
        }
    }
    public void actualizarTotal() {
        lblTotal.setText("Total de Infracciones: " + lista.size());
    }
}