package com.example.ejerciciopractica;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroDocumentoController {

    @FXML
    private TextField txtNombreDocumento;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtArchivoSelec;

    @FXML
    private TextField txtDirectorio;

    @FXML
    private TextField txtResultado;

    @FXML
    private Button btnSelecArchivo;


    @FXML
    private void selecArchivo(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar archivo");
        fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("TXT", "*.txt"));
        File archivo = fc.showOpenDialog(btnSelecArchivo.getScene().getWindow());

        if (archivo != null) {
            txtArchivoSelec.setText(archivo.getAbsolutePath());
        }

    }

    @FXML
    private void selecDirectorio(){
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar archivo");
        File directorio = dc.showDialog(btnSelecArchivo.getScene().getWindow());

        if (directorio != null) {
            txtDirectorio.setText(directorio.getAbsolutePath());
        }

    }

    @FXML
    private void mostrarConfirmacion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Desea guardar el documento?");
        alert.setContentText(txtNombreDocumento.getText());

        Optional<ButtonType> respuesta = alert.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK){
            mostrarResultado();
        }

    }

    @FXML
    private void mostrarAlerta(){

    }

    @FXML
    private void Guardar(){

    }






}
