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
        checklog();
    }

    void checklog() throws IOException, SQLException{
        String log = loginEnter.getText();
        String pas = password.getText();
        String url = "jdbc:mysql://localhost/ap_test";
        System.out.println(verifierUtilisateur(log, pas));
        if(verifierUtilisateur(log,pas)== true){
            wrongLabel.setText("Connexion réussie");
            App.setRoot("secondary");
        }else{
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setText("Connexion non réussi, le mot de passe ou le nom d'utilisateur n'est pas bon !");
        }
    }

    private boolean verifierUtilisateur(String utilisateur, String mdp) throws IOException, SQLException{
        String url = "jdbc:mysql://localhost/ap_test";
        String userdb = "daron";
        String passw = "daron";
        ResultSet resultats = null;
        Connection c = DriverManager.getConnection(url,userdb,passw);
        Statement stmnt = c.createStatement();
        resultats = stmnt.executeQuery("SELECT * FROM `utilisateurs` WHERE login = \""+utilisateur+"\" AND password = \""+mdp+"\" ;");
        ResultSetMetaData rsmd = resultats.getMetaData();
        System.out.println();
        System.out.println(resultats.getString(1));
        System.out.println(reponseOuPAs(resultats));
        if (reponseOuPAs(resultats)){
            return false; 
        }else{
            return true;
        }
        /*boolean encore = resultats.next();
            String password = resultats.getString(3);
            String utilisat = resultats.getString(2);
            encore = resultats.next();*/
    }

    private boolean reponseOuPAs(ResultSet res) throws SQLException{
        String stres = "";
        for (int i=1;i<4;i++){
            String valeur = res.getString(i);
            stres = stres + valeur;
        }
        if (stres == " "){
            return false;
        }else{
            return true;
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
