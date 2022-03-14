package com.javiergm.ejerciciojavier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

public class AppVistaGraficoController {
    @FXML
    private AnchorPane appVistaGrafico;
    @FXML
    private PieChart pieChart;

    public void cargarDatosPieChart(ObservableList<Producto> datosProductos){
        int contadorDesktop=0;
        for(Producto c1: datosProductos){
            if(c1.getCategoria().equals("Desktop")){
                contadorDesktop++;
            }
        }
        int contadorTablet=0;
        for(Producto c1: datosProductos){
            if(c1.getCategoria().equals("Tablet")){
                contadorTablet++;
            }
        }
        int contadorPhone = datosProductos.size() - contadorDesktop - contadorTablet;

        ObservableList<PieChart.Data> datosGraficaCircular= FXCollections.observableArrayList(
                new PieChart.Data("Phone",contadorPhone),
                new PieChart.Data("Desktop",contadorDesktop),
                new PieChart.Data("Tablet",contadorTablet));
        pieChart.setData(datosGraficaCircular);
    }
}