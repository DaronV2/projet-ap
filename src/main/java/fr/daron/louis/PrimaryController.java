package fr.daron.louis;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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
        if(checklog()==true){
            App.setRoot("secondary");
        }
    }

    Boolean checklog() throws IOException, SQLException{

        String log = loginEnter.getText();
        String pas = password.getText();

        System.out.println(verifierUtilisateur(log, pas));

        if(verifierUtilisateur(log,pas) == true){
            wrongLabel.setText("Connexion réussie");
            return true;
        }else{
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setText("Connexion non réussi, le mot de passe ou le nom d'utilisateur n'est pas bon !");
            return false;
        }
    }

    private boolean verifierUtilisateur(String utilisateur, String mdp) throws IOException, SQLException{
        ResultSet resultats = null;
        Sqldb sql2 = new Sqldb();

        Connection c = sql2.connexionDb();
        Statement stmnt = c.createStatement();

        String sql = String.format("SELECT id,login,password,statut FROM `utilisateurs` WHERE login = '%s'  AND password = '%s' ;", utilisateur,mdp);
        resultats = sql2.exeRequete(stmnt, sql);

        if (resultats.next() == true){
            return true; 
        }else{
            return false;
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
