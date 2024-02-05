package fr.daron.louis;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField login;

    @FXML
    private PasswordField passw;

    @FXML
    private Button primaryButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
