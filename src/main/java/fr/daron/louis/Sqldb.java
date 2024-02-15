package fr.daron.louis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Sqldb {
    
    private String url = "jdbc:mysql://localhost/ap_test";

    private String user = "daron";

    private String mdp = "daron";

    Sqldb(){
    }

    @SuppressWarnings("exports")
    public Connection connexionDb() throws SQLException{
        Connection c = DriverManager.getConnection(this.url,this.user,this.mdp);
        return c;
    }

    @SuppressWarnings("exports")
    public ResultSet exeRequete(Statement stmnt, String requete) throws SQLException{
        ResultSet res = stmnt.executeQuery(requete);
        return res;
    }
}
