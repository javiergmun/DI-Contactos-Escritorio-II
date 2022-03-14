package com.javiergm.ejerciciojavier;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private boolean desplegado;
    private TranslateTransition animationTabla;

    @FXML
    private Label labelProductos,labelTablaProductos;
    @FXML
    private HBox hbox1;
    @FXML
    private Button btnRefrescar,btnNuevo,btnEliminar,btnGrafico;
    @FXML
    private TableView tabla1;
    @FXML
    private TableColumn<Producto,String> columnaNombre, columnaCategoria;
    @FXML
    private AnchorPane appVistaDetalle, appVistaGrafico;
    @FXML
    private AppVistaDetalleController appVistaDetalleController;
    @FXML
    private AppVistaGraficoController appVistaGraficoController;
    @FXML
    private ObservableList<Producto> datosProductos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appVistaDetalle.setVisible(true);
        appVistaDetalle.setTranslateX(250);
        appVistaDetalle.setTranslateY(50);

        appVistaGrafico.setVisible(false);
        appVistaGrafico.setTranslateX(250);
        appVistaGrafico.setTranslateY(50);


        rellenarLista();


        cargarTabla(datosProductos);
        tabla1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tabla1.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if(newValue !=null){
                appVistaDetalleController.cargarContactoDetalle((Producto) newValue);
                //cargarVistaDetalle(); //PARA VER SI ME MANDA DIRECTO O SOLO AL SELECCIONAR DIGO SI QUIERO VER
            }
        });

    }

    @FXML
    private void mostrarGrafico(){
        appVistaGraficoController.cargarDatosPieChart(datosProductos);
        appVistaGrafico.setVisible(true);
        animationTabla = new TranslateTransition(Duration.millis(700), appVistaGrafico);

        if(!desplegado){
            animationTabla.setFromX(600);//se desplaza en x lo que mida
            animationTabla.setToX(250);
            desplegado=true;
        }else{
            animationTabla.setFromX(250);
            animationTabla.setToX(600);//se desplaza en x lo que mida
            desplegado=false;
        }
        animationTabla.play();
    }
    private void rellenarLista() {
        datosProductos = FXCollections.observableArrayList(
                new Producto("iPhone","Phone","Son caros, bonitos y simples."),
                new Producto("Samsung Galaxy","Phone","Son caros, no tanto como apple"),
                new Producto("LG","Phone","Son un poco malos"),
                new Producto("Lenovo Yoga","Desktop","Relajante porque dice YOGA"),
                new Producto("Samsung Galaxy Tablet","Tablet","Es grande, muy grande")
        );
    }
    public void cargarTabla(ObservableList<Producto> datosProductos){
        tabla1.setEditable(true);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        columnaCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        //modificar campo de tabla
        columnaCategoria.setCellFactory(TextFieldTableCell.forTableColumn());
        columnaCategoria.setOnEditCommit(data ->{
            if(data != null){
                data.getRowValue().setCategoria(data.getNewValue());
            }
        });
        tabla1.setItems(datosProductos);
    }
    @FXML
    private void refrescarDatos(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Informacion del programa");
        alert.setTitle("ATENCION");
        alert.setContentText("");
        alert.showAndWait();
    }
    @FXML
    private void nuevoDatos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Informacion del programa");
        alert.setTitle("ATENCION");
        alert.setContentText("Vas a insertar un nuevo producto");
        alert.showAndWait();
        Producto productoNuevo = new Producto("NuevoProducto","Phone","No sabemos nada, es nuevo");
        datosProductos.add(productoNuevo);
    }
    @FXML
    private void eliminarDatos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Informacion del programa");
        alert.setTitle("ATENCION");
        alert.setContentText("Vas a eliminar el/los productos seleccionados");
        alert.showAndWait();
        datosProductos.remove(1);//no es el selecionado pero...
    }
}