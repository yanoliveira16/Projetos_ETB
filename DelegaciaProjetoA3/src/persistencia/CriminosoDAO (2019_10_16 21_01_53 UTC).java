
package persistencia;

import delegaciaprojetoa3.Criminoso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CriminosoDAO {
    

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Criminoso> leTodos() throws Exception {
        List<Criminoso> listCriminosos = new ArrayList<Criminoso>();
        try {
            String sql = "SELECT * FROM CRIMINOSO";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Criminoso c = new Criminoso();
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                c.setRgCriminoso(rs.getString("rgCriminoso"));
                c.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                listCriminosos.add(c);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listCriminosos;
    }

    public static Criminoso leUm(String rgCriminoso) throws Exception {
        Criminoso criminoso = new Criminoso();
        try {
            String sql = "SELECT * FROM Criminoso WHERE rgCriminoso = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgCriminoso);
            rs = st.executeQuery();
            if (rs.next()) {
                criminoso.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                criminoso.setRgCriminoso(rs.getString("rgCriminoso"));
                criminoso.setIdade(rs.getInt("idade"));
                criminoso.setNome(rs.getString("nome"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return criminoso;
    }
    
    public static Criminoso leUm2(String nome) throws Exception {
 Criminoso criminoso = new Criminoso();
 
 try{
 String sql = "SELECT * FROM Criminoso WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) 
 criminoso.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                criminoso.setRgCriminoso(rs.getString("rgCriminoso"));
                criminoso.setIdade(rs.getInt("idade"));
                criminoso.setNome(rs.getString("nome"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return criminoso;
 }

public static Criminoso leUm3(String nome, int idade) throws Exception {
 Criminoso criminoso = new Criminoso();
 
 try{
 String sql = "SELECT * FROM Criminoso WHERE nome = ? AND idade = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2,idade);
 rs = st.executeQuery();
 if (rs.next()) 
 criminoso.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                criminoso.setRgCriminoso(rs.getString("rgCriminoso"));
                criminoso.setIdade(rs.getInt("idade"));
                criminoso.setNome(rs.getString("nome"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return criminoso;
 }


public static Criminoso leUm4(String rgCriminoso,int Endereco_numero) throws Exception {
 Criminoso criminoso = new Criminoso();
 
 try{
 String sql = "SELECT * FROM Criminoso WHERE rgCriminoso = ? OR  Endereco_numero = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, rgCriminoso);
 st.setInt(2, Endereco_numero);
 rs = st.executeQuery();
 if (rs.next()) 
 criminoso.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                criminoso.setRgCriminoso(rs.getString("rgCriminoso"));
                criminoso.setIdade(rs.getInt("idade"));
                criminoso.setNome(rs.getString("nome"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return criminoso;
 }



    public static int grava(Criminoso criminoso) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO Criminoso (rgCriminoso,nome,idade,Endereco_numero) VALUES (?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, criminoso.getRgCriminoso());
            st.setString(2, criminoso.getNome());
            st.setInt(3, criminoso.getIdade());
            st.setInt(4,criminoso.getEndereco().getNumero());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera(Criminoso criminoso) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE criminoso SET nome = ?,idade = ?,Endereco_numero = ? WHERE rgCriminoso = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, criminoso.getNome());
            st.setInt(2, criminoso.getIdade());
            st.setInt(3,criminoso.getEndereco().getNumero());
            st.setString(4, criminoso.getRgCriminoso());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera2(Criminoso criminoso) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE criminoso SET rgCriminoso = ?,idade = ?,Endereco_numero = ? WHERE nome = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, criminoso.getRgCriminoso());
 st.setInt(2, criminoso.getIdade());
 st.setInt(3,criminoso.getEndereco().getNumero());
 st.setString(4, criminoso.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Criminoso criminoso) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE criminoso SET  idade = ?, Endereco_numero = ? WHERE nome = ? AND rgCriminoso  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
st.setInt(1, criminoso.getIdade());
st.setInt(2,criminoso.getEndereco().getNumero());
st.setString(3, criminoso.getNome());
st.setString(4, criminoso.getRgCriminoso());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(Criminoso criminoso) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE criminoso SET  nome = ?,rgCriminoso = ? WHERE idade = ? OR Endereco_numero = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
st.setString(1, criminoso.getNome());
st.setString(2, criminoso.getRgCriminoso());
st.setInt(3, criminoso.getIdade());
st.setInt(4,criminoso.getEndereco().getNumero());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(String rgCriminoso) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM criminoso WHERE rgCriminoso = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgCriminoso);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int exclui2(String nome) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM criminoso WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }


public static int exclui3(int idade,int Endereco_numero ) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM criminoso WHERE idade = ? AND Endereco_numero = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, idade);
 st.setInt(2, Endereco_numero);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(String nome,String rgCriminoso) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM criminoso WHERE nome = ? OR rgCriminoso = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setString(2 ,rgCriminoso);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
}


    

