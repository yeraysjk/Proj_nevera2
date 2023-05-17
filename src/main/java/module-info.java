module com.example.proj_nevera {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.proj_nevera to javafx.fxml;
    exports com.example.proj_nevera;
}