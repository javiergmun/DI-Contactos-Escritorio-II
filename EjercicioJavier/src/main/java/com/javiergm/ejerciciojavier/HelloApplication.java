package com.javiergm.ejerciciojavier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale español = new Locale("es","ES");
        Locale english = new Locale("en","UK");
        ResourceBundle idiomaIngles = ResourceBundle.getBundle("i18n/strings",english);
        ResourceBundle idiomaEspañol = ResourceBundle.getBundle("i18n/strings",español);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"),idiomaIngles);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ejercicio Javier González");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}