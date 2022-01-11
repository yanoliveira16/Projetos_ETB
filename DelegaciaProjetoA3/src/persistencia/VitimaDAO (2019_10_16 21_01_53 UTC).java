
package persistencia;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Vitima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VitimaDAO {
    

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Vitima> leTodos() throws Exception {
        List<Vitima> listVitimas = new ArrayList<Vitima>();
        try {
            String sql = "SELECT * FROM VITIMA";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Vitima v = new Vitima();
                v.setNome(rs.getString("nome"));
                v.setIdade(rs.getInt("idade"));
                v.setRgVitima(rs.getString("rgVitima"));
                v.setTelefone(rs.getString("telefone"));
                v.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                listVitimas.add(v);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listVitimas;
    }

    public static Vitima leUm(String rgVitima) throws Exception {
        Vitima vitima = new Vitima();
        try {
            String sql = "SELECT * FROM Vitima WHERE rgVitima = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgVitima);
            rs = st.executeQuery();
            if (rs.next()) {
                vitima.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                vitima.setTelefone(rs.getString("telefone"));
                vitima.setRgVitima(rs.getString("rgVitima"));
                vitima.setIdade(rs.getInt("idade"));
                vitima.setNome(rs.getString("nome"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vitima;
    }
    
    public static Vitima leUm2(String nome) throws Exception {
 Vitima vitima = new Vitima();
 
 try{
 String sql = "SELECT * FROM Vitima WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) 
 vitima.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                vitima.setTelefone(rs.getString("telefone"));
                vitima.setRgVitima(rs.getString("rgVitima"));
                vitima.setIdade(rs.getInt("idade"));
                vitima.setNome(rs.getString("nome"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return vitima;
 }

public static Vitima leUm3(String nome, int idade) throws Exception {
 Vitima vitima = new Vitima();
 
 try{
 String sql = "SELECT * FROM Vitima WHERE nome = ? AND idade = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2,idade);
 rs = st.executeQuery();
 if (rs.next()) 
 vitima.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                vitima.setTelefone(rs.getString("telefone"));
                vitima.setRgVitima(rs.getString("rgVitima"));
                vitima.setIdade(rs.getInt("idade"));
                vitima.setNome(rs.getString("nome"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return vitima;
 }


public static Vitima leUm4(String rgVitima,int Endereco_numero) throws Exception {
 Vitima vitima = new Vitima();
 
 try{
 String sql = "SELECT * FROM Vitima WHERE rgVitima = ? OR  Endereco_numero = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, rgVitima);
 st.setInt(2, Endereco_numero);
 rs = st.executeQuery();
 if (rs.next()) 
 vitima.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                vitima.setTelefone(rs.getString("telefone"));
                vitima.setRgVitima(rs.getString("rgVitima"));
                vitima.setIdade(rs.getInt("idade"));
                vitima.setNome(rs.getString("nome"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return vitima;
 }

    public static int grava(Vitima vitima) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO Vitima (rgVitima,telefone,nome,idade,Endereco_numero) VALUES (?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, vitima.getRgVitima());
            st.setString(2, vitima.getTelefone());
            st.setString(3, vitima.getNome());
            st.setInt(4, vitima.getIdade());
            st.setInt(5,vitima.getEndereco().getNumero());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
   
  
    public static int altera(Vitima vitima) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE vitima SET nome = ?, telefone = ?, idade = ?, Endereco_numero = ? WHERE rgVitima = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, vitima.getNome());
            st.setString(2, vitima.getTelefone());
            st.setInt(3, vitima.getIdade());
            st.setInt(4,vitima.getEndereco().getNumero());
            st.setString(5, vitima.getRgVitima());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera2(Vitima vitima) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE vitima SET rgVitima = ?, telefone = ?, idade = ?, Endereco_numero = ? WHERE nome = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setString(1, vitima.getRgVitima());
            st.setString(2, vitima.getTelefone());
            st.setInt(3, vitima.getIdade());
            st.setInt(4,vitima.getEndereco().getNumero());
            st.setString(5, vitima.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Vitima vitima) throws Exception {
 int ret = 0;
 try {
 String sql =  "UPDATE vitima SET telefone = ?, idade = ?, Endereco_numero = ? WHERE nome = ? AND rgVitima=?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setString(1, vitima.getTelefone());
            st.setInt(2, vitima.getIdade());
            st.setInt(3,vitima.getEndereco().getNumero());
            st.setString(4, vitima.getNome());
            st.setString(5, vitima.getRgVitima());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(Vitima vitima) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE vitima SET nome = ?, rgVitima = ?, Endereco_numero = ? WHERE telefone = ? OR idade=?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setString(1, vitima.getNome());
            st.setString(2, vitima.getRgVitima());
            st.setInt(3,vitima.getEndereco().getNumero());
            st.setString(4, vitima.getTelefone());
            st.setInt(5, vitima.getIdade());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(String rgVitima) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM vitima WHERE rgVitima = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgVitima);
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
 String sql = "DELETE FROM vitima WHERE nome = ?";
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
 String sql = "DELETE FROM vitima WHERE idade = ? AND Endereco_numero = ?";
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

public static int exclui4(String nome,String rgVitima) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM vitima WHERE nome = ? OR rgVitima = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setString(2 ,rgVitima);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

}

    

