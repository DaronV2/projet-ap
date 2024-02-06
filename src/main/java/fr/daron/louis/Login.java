package fr.daron.louis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

     @FXML
    private TextField loginEnter;

    @FXML
    private PasswordField password;

    @FXML
    void logIn(ActionEvent event) {
        checklog();
    }

    private void checklog(){
        
    }
    
}
