module fr.daron.louis {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.daron.louis to javafx.fxml;
    exports fr.daron.louis;
}
