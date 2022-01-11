
package persistencia;

import delegaciaprojetoa3.Arma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArmaDAO {
    

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Arma> leTodos() throws Exception {
        List<Arma> listArmas = new ArrayList<Arma>();
        try {
            String sql = "SELECT * FROM ARMA";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Arma a = new Arma();
                a.setDescricaoArma(rs.getString("descricaoArma"));
                a.setNumeroArma(rs.getInt("numeroArma"));             
                listArmas.add(a);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listArmas;
    }

    public static Arma leUm(int numeroArma) throws Exception {
        Arma arma = new Arma();
        try {
            String sql = "SELECT * FROM Arma WHERE numeroArma = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, numeroArma);
            rs = st.executeQuery();
            if (rs.next()) {
                arma.setNumeroArma(rs.getInt("numeroArma"));
                arma.setDescricaoArma(rs.getString("descricaoArma"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arma;
    }
    
    public static Arma leUm2(String descricaoArma) throws Exception {
 Arma arma = new Arma();
 
 try{
 String sql = "SELECT * FROM Arma WHERE descricaoArma = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricaoArma);
 rs = st.executeQuery();
 if (rs.next()) 
 arma.setNumeroArma(rs.getInt("numeroArma"));
 arma.setDescricaoArma(rs.getString("descricaoArma"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return arma;
 }

public static Arma leUm3(String descricaoArma, int numeroArma) throws Exception {
 Arma arma = new Arma();
 
 try{
 String sql = "SELECT * FROM Arma WHERE numeroArma = ? AND descricaoArma = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeroArma);
 st.setString(2,descricaoArma);
 rs = st.executeQuery();
 if (rs.next()) 
 arma.setNumeroArma(rs.getInt("numeroArma"));
 arma.setDescricaoArma(rs.getString("descricaoArma"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return arma;
 }


public static Arma leUm4(int numeroArma,String descricaoArma) throws Exception {
 Arma arma = new Arma();
 
 try{
 String sql = "SELECT * FROM Arma WHERE numeroArma = ? OR  descricaoArma = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeroArma);
 st.setString(2, descricaoArma);
 rs = st.executeQuery();
 if (rs.next()) 
 arma.setNumeroArma(rs.getInt("numeroArma"));
 arma.setDescricaoArma(rs.getString("descricaoArma"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return arma;
 }


    public static int grava(Arma arma) throws Exception {
        int ret = 1;
        try {
            String sql = "INSERT INTO Arma (numeroArma,descricaoArma) VALUES (?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, arma.getNumeroArma());
            st.setString(2, arma.getDescricaoArma());;
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera(Arma arma) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE arma SET  descricaoArma =  ? WHERE numeroArma = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, arma.getDescricaoArma());
            st.setInt(2,arma.getNumeroArma());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera2(Arma arma) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE arma SET  numeroArma =  ? WHERE descricaoArma = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1,arma.getNumeroArma());
            st.setString(2, arma.getDescricaoArma());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
public static int altera3(String descricaoArma,String novoDescricaoArma, int novoNumeroArma,int numeroArma) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE arma SET  numeroArma = ?, descricaoArma = ? WHERE numeroArma = ? AND descricaoArma  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoNumeroArma);
 st.setString(2, novoDescricaoArma);
 st.setInt(3, numeroArma);
 st.setString(4, descricaoArma);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(int novoNumeroArma,String novoDescricaoArma,int numeroArma,String descricaoArma) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE arma SET  numeroArma = ?,descricaoArma = ?, numeroArma = ? OR descricaoArma = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoNumeroArma);
 st.setString(2, novoDescricaoArma);
 st.setInt(3, numeroArma);
 st.setString(4, descricaoArma);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(int numeroArma) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM arma WHERE numeroArma = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, numeroArma);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    

public static int exclui2(String descricaoArma) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM arma WHERE descricaoArma = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, descricaoArma);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }


public static int exclui3(int numeroArma,String descricaoArma ) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM arma WHERE numeroArma = ? AND descricaoArma = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numeroArma);
 st.setString(2, descricaoArma);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(int numeroArma,String descricaoArma) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM arma WHERE numeroArma = ? OR descricaoArma = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setDouble(1, numeroArma);
 st.setString(2 ,descricaoArma);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
}
    
    
    
    
    
    



    

