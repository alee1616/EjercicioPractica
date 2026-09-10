package com.example.ejerciciopractica;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroDocumentoController {

    @FXML
    private TextField txtNombreDocumento;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtArchivoSelec;

    @FXML
    private TextField txtDirectorio;

    @FXML
    private TextArea txtResultado;

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
        dc.setInitialDirectory(new File("c: \\"));
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

    private void mostrarResultado(){
        txtResultado.setText(txtNombreDocumento.getText());
    }

    @FXML
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();

    }


    @FXML
    private void Guardar(){
        if(validarFormulario()){
            return;
        }
        mostrarConfirmacion();

    }

    private boolean validarFormulario() {
        return true;
    }

    @FXML
    private void mostrarDialog(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Agregue una observación");
        dialog.setHeaderText("Observación del documento");
        dialog.setContentText("Observación:");
        Optional<String> resultado = dialog.showAndWait();
        resultado.ifPresent(valor -> {
            if(valor.isBlank()){
                txtResultado.appendText("Observación: " + valor + "\n");
            }
        });
    }






}
