package com.example.ejerciciopractica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroDocumentoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegistroDocumentoApplication.class.getResource("registro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registro de Documento");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}