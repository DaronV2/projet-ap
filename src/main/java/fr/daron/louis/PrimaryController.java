package fr.daron.louis;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    void login(ActionEvent event) throws IOException, SQLException, NoSuchAlgorithmException {
        String log = loginEnter.getText();
        if(checklog()==true && comptableOuNon(log) == true){
            App.setRoot("accueil");
        }
        else if(checklog()==true && comptableOuNon(log) == false){
            App.setRoot("third");
        }
    }

    Boolean checklog() throws IOException, SQLException, NoSuchAlgorithmException{

        String log = loginEnter.getText();
        String pas = password.getText();

        System.out.println(verifierUtilisateur(log, pas));

        if(verifierUtilisateur(log,pas) == true){

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

        String sql = String.format("SELECT cr_identifiant,cr_mot_de_passe FROM gsb_etudiants.credentials WHERE cr_identifiant = '%s'  AND cr_mot_de_passe = '%s' ;", utilisateur,mdp);
        resultats = sql2.exeRequete(stmnt, sql);

        if (resultats.next() == true){
            return true; 
        }else{
            return false;
        }
    }

    /*private String chiffrerSha256(String password) throws NoSuchAlgorithmException{
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        m.update(password.getBytes());
        byte byteData[] = m.digest();

        // convertir le tableau de bits en une format hexadécimal - méthode 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }*/


    private boolean comptableOuNon(String utilisateur) throws SQLException{
        ResultSet resultats = null;
        Sqldb sql = new Sqldb();
        Connection c = sql.connexionDb();
        Statement stmnt = c.createStatement();

        String req = String.format("SELECT cr_identifiant FROM gsb_etudiants.credentials WHERE cr_identifiant = '%s'", utilisateur);

        resultats = sql.exeRequete(stmnt, req);

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
