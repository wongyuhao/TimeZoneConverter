module org.hao {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    opens org.hao to javafx.fxml;
    exports org.hao;
}