module com.example.proj_nevera {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.proj_nevera to javafx.fxml;
    exports com.example.proj_nevera;
}