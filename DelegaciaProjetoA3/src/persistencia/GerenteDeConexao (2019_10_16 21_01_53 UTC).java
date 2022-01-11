
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenteDeConexao {

    private static GerenteDeConexao connect;

    public static GerenteDeConexao getInstance() {
        if (connect == null) {
            return connect = new GerenteDeConexao();
        } else {
            return connect;
        }
    }
    private static String conexao = "jdbc:mysql://localhost:3306/delegaciaprojeto";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(conexao, user, password);
    }
}

