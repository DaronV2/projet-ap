package fr.daron.louis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    void login(ActionEvent event) throws IOException, SQLException {
        checklog();
    }

    void checklog() throws IOException, SQLException{
        //App m = new App();
        System.out.println(loginEnter.getText());
        System.out.println(password.getText());
        String url = "jbdc:mysql://127.0.0.1:3306/ap_test";
        if (loginEnter.getText().toString().equals("test") && password.getText().toString().equals("test")){
            wrongLabel.setText("Connexion reussie");
           // try{
                //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url,"daron","daron");   
            //}
          /*  catch(Exception e ){
                System.out.println(e);
            }*/
            App.setRoot("Secondary");
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
