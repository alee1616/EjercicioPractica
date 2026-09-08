module com.example.ejerciciopractica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejerciciopractica to javafx.fxml;
    exports com.example.ejerciciopractica;
}