package com.example.ejerciciopractica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroProyectosApplication extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-proyectos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registro de Proyectos");
        stage.setScene(scene);
        stage.show();
    }
}