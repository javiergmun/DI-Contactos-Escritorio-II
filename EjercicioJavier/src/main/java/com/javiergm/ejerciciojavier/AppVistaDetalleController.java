package com.javiergm.ejerciciojavier;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class AppVistaDetalleController {
    @FXML
    private AnchorPane appVistaDetalle;
    @FXML
    private VBox vbox2;
    @FXML
    private Label labelCategoria, labelNombre, labelDescripcion;
    @FXML
    private TextField textCategoria,textNombre, textDescripcion;
    @FXML
    private Button btnGuardar;

    public void cargarContactoDetalle(Producto producto){
        textNombre.setText(producto.getNombre());
        textCategoria.setText(producto.getCategoria());
        textDescripcion.setText(producto.getDescripcion());
    }
}