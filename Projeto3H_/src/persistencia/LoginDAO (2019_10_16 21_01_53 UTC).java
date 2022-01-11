package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Login;

public class LoginDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Login> leTodos() throws Exception {
        List<Login> listLogins = new ArrayList<Login>();
        try {
            String sql = "SELECT * FROM LOGIN";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Login login = new Login();
                login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
                listLogins.add(login);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listLogins;
    }

    public static Login leUm(int usuario) throws Exception {
        Login login = new Login();
        try {
            String sql = "SELECT * FROM Login WHERE usuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario);
            rs = st.executeQuery();
            if (rs.next()) {
                login.setUsuario(rs.getInt("usuario"));
                login.setSenha(rs.getInt("senha"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return login;
    }

    public static int grava(Login login) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO Login (usuario,senha) VALUES (?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, login.getUsuario());
            st.setInt(2, login.getSenha());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera(int senha, int usuario) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE Login SET senha = ? WHERE usuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, senha);
            st.setInt(2, usuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int exclui(int usuario) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM Login WHERE usuario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    
}
