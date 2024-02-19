package fr.daron.louis;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ThirdController {
    @FXML
    void accueil(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
