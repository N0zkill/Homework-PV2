module org.example.mazegamergroup4_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mazegamergroup4_fx to javafx.fxml;
    exports org.example.mazegamergroup4_fx;
}