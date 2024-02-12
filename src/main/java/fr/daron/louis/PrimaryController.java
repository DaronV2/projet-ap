package fr.daron.louis;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button btnConnexion;

    @FXML
    private Button btn_deuxpage;

    @FXML
    private Button btn_troispage;

    @FXML
    private TextField loginEnter;

    @FXML
    private PasswordField password;

    @FXML
    private Label wrongLabel;

    @FXML
    void login(ActionEvent event) throws IOException {
        checklog();
    }

    void checklog() throws IOException{
        //App m = new App();
        System.out.println(loginEnter.getText());
        System.out.println(password.getText());
        if (loginEnter.getText().toString().equals("test") && password.getText().toString().equals("test")){
            wrongLabel.setText("Connexion reussie");
            //m.changeScene("secondary");
        }else{
            wrongLabel.setText("Connexion non réussie");
        }
    }

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToThird(ActionEvent event) throws IOException{
        App.setRoot("third");
    }

}
