package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Fisica;

public class FisicaDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Fisica> leTodos() throws Exception {
        List<Fisica> listFisicas = new ArrayList<Fisica>();
        try {
            String sql = "SELECT * FROM FISICA";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Fisica fisica = new Fisica();
                fisica.setCpf(rs.getString("cpf"));
                fisica.setNome(rs.getString("nome"));
                fisica.setIdade(rs.getInt("idade"));
                fisica.setAtendente(AtendenteDAO.leUm(rs.getInt("atendente_matr")));
                fisica.setLogin(LoginDAO.leUm(rs.getInt("login_usuario")));
                listFisicas.add(fisica);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listFisicas;
    }

    public static Fisica leUm(String cpf) throws Exception {
        Fisica fisica = new Fisica();
        try {
            String sql = "SELECT * FROM Fisica WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cpf);
            rs = st.executeQuery();
            if (rs.next()) {
                fisica.setCpf(rs.getString("cpf"));
                fisica.setNome(rs.getString("nome"));
                fisica.setIdade(rs.getInt("idade"));
                fisica.setAtendente(AtendenteDAO.leUm(rs.getInt("atendente_matr")));
                fisica.setLogin(LoginDAO.leUm(rs.getInt("login_usuario")));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fisica;
    }

    public static int grava(Fisica fisica) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO Fisica (cpf,nome,idade,atendente_matr,login_usuario) VALUES (?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, fisica.getCpf());
            st.setString(2, fisica.getNome());
            st.setInt(3, fisica.getIdade());
            st.setInt(4, fisica.getAtendente().getMatr());
            st.setInt(5, fisica.getLogin().getUsuario());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera(Fisica fisica) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE Fisica SET nome = ?, idade = ?,atendente_matr = ?, login_usuario = ? WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, fisica.getNome());
            st.setInt(2, fisica.getIdade());
            st.setInt(3, fisica.getAtendente().getMatr());
            st.setInt(4, fisica.getLogin().getUsuario());
            st.setString(5, fisica.getCpf());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int exclui(String cpf) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM Fisica WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cpf);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
}
