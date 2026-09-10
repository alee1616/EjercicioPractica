package com.example.ejerciciopractica;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class RegistroProyectosController {

    @FXML
    private TextField txtNombreProyecto;

    @FXML
    private TextField txtResponsable;

    @FXML
    private TextField txtArchivoSelec;

    @FXML
    private TextField txtDirectorio;

    @FXML
    private TextArea txtTareas;

    @FXML
    private Button btnSelecArchivo;

    @FXML
    private void selecArchivo() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar archivo");

        // para txt, pdf, palabra y excel
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos los documentos admitidos", "*.txt", "*.pdf", "*.doc", "*.docx", "*.xls", "*.xlsx"),
                new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Documentos PDF (*.pdf)", "*.pdf"),
                new FileChooser.ExtensionFilter("Documentos de Word (*.doc, *.docx)", "*.doc", "*.docx"),
                new FileChooser.ExtensionFilter("Archivos de Excel (*.xls, *.xlsx)", "*.xls", "*.xlsx")
        );

        File dirInicial = new File("C:\\Documentos");
        if (dirInicial.exists()) {
            fc.setInitialDirectory(dirInicial);
        }
        File archivo = fc.showOpenDialog(btnSelecArchivo.getScene().getWindow());

        if (archivo != null) {
            txtArchivoSelec.setText(archivo.getAbsolutePath());
        }
    }

    @FXML
    private void selecDirectorio() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar carpeta");
        File dirInicial = new File("C:\\Documentos");
        if (dirInicial.exists()) {
            dc.setInitialDirectory(dirInicial);
        }
        File directorio = dc.showDialog(btnSelecArchivo.getScene().getWindow());

        if (directorio != null) {
            txtDirectorio.setText(directorio.getAbsolutePath());
        }
    }

    @FXML
    private void mostrarConfirmacion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Desea guardar el proyecto?");
        alert.setContentText("Proyecto: " + txtNombreProyecto.getText() + "\nResponsable: " + txtResponsable.getText());
        Optional<ButtonType> respuesta = alert.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            mostrarTareas();
        }
    }

    private void mostrarTareas() {
        txtTareas.setText("Proyecto: " + txtNombreProyecto.getText() + "\n");
    }

    @FXML
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void Guardar() {
        if (!validarFormulario()) {
            return;
        }
        mostrarConfirmacion();
    }

    private boolean validarFormulario() {
        return true;
    }

    @FXML
    private void mostrarDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Agregue una tarea");
        dialog.setHeaderText("Nueva tarea del proyecto");
        dialog.setContentText("Tarea:");

        Optional<String> resultado = dialog.showAndWait();
        resultado.ifPresent(valor -> {
            if (!valor.isBlank()) {
                txtTareas.appendText("- " + valor + "\n");
            }
        });
    }
}