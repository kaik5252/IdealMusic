package Model;

import Control.PopUp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Kaik D' Andrade
 * @author Gabriel Souza
 */
public class ConfigDatabase {

    private Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/teste?user=root&password=";

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning(error);
        }
        
        // Retorna a conexão
        return conn;
    }

    public void dbClose(Connection conn, PreparedStatement pstm, ResultSet res) {
        if (res != null) try {
            res.close();
        } catch (SQLException ignore) {}

        if (pstm != null) try {
            pstm.close();
        } catch (SQLException ignore) {}

        if (conn != null) try {
            conn.close();
        } catch (SQLException ignore) {}
    }
}