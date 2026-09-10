package com.example.ejerciciopractica;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroDocumentosApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-documentos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registro de Documentos");
        stage.setScene(scene);
        stage.show();


    }
}
