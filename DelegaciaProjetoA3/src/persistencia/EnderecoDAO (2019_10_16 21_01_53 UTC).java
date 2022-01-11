/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import delegaciaprojetoa3.Endereco;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel
 */
public class EnderecoDAO {
    
    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Endereco> leTodos() throws Exception {
        List<Endereco> listEnderecos = new ArrayList<Endereco>();
        try {
            String sql = "SELECT * FROM ENDERECO";
            connection = persistencia.GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                listEnderecos.add(end);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listEnderecos;
    }

    public static Endereco leUm(int numero) throws Exception {
        Endereco end = new Endereco();
        try {
            String sql = "SELECT * FROM endereco WHERE numero = ?";
            connection = persistencia.GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, numero);
            rs = st.executeQuery();
            if (rs.next()) {
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return end;
    }
    
    public static Endereco leUm2(String rua) throws Exception {
Endereco end = new Endereco();
 
 try{
 String sql = "SELECT * FROM endereco WHERE rua = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, rua);
 rs = st.executeQuery();
 if (rs.next()) 
 end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return end;
 }

public static Endereco leUm3(String rua, int numero) throws Exception {
 Endereco end = new Endereco();
 
 try{
 String sql = "SELECT * FROM endereco WHERE numero = ? AND rua = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numero);
 st.setString(2,rua);
 rs = st.executeQuery();
 if (rs.next()) 
 end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return end;
 }


public static Endereco leUm4(String rua, int numero) throws Exception {
 Endereco end = new Endereco();
 
 try{
 String sql = "SELECT * FROM endereco WHERE numero = ? OR  rua = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numero);
 st.setString(2, rua);
 rs = st.executeQuery();
 if (rs.next()) 
 end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return end;
 }

    public static int grava(Endereco endereco) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO endereco (numero,rua) VALUES (?, ?)";
            connection = persistencia.GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, endereco.getNumero());
            st.setString(2, endereco.getRua());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        return ret;
    }

    public static int altera(Endereco endereco) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE endereco SET rua = ? WHERE numero = ?";
            connection = persistencia.GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, endereco.getRua());
           st.setInt(2, endereco.getNumero());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    public static int altera2(Endereco endereco) throws Exception {
     int ret = 0;
        try {
            String sql =  "UPDATE endereco SET  numero = ? WHERE rua = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, endereco.getNumero());
            st.setString(2, endereco.getRua());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          }
         return ret;
        }
    
       public static void alteraRua(Endereco endereco) throws Exception {
       
            String sql =  "UPDATE endereco SET  rua = ? WHERE numero = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, endereco.getRua());
            st.setInt(2, endereco.getNumero());
            st.executeUpdate();
            st.close();
       
        }
public static int altera3(String rua,String novoRua, int novoNumero,int numero) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE endereco SET  numero= ?, rua = ? WHERE numero = ? AND rua  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoNumero);
 st.setString(2, novoRua);
 st.setInt(3, numero);
 st.setString(4, rua);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(int numero,int novoNumero,String rua, String novoRua) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE endereco SET  numero = ?,rua = ? WHERE numero = ? OR rua = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, novoNumero);
 st.setString(2, novoRua);
 st.setInt(3, numero);
 st.setString(4, rua);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

    public static int exclui(int numero) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM endereco WHERE numero = ?";
            connection = persistencia.GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, numero);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int exclui2(String rua) throws Exception{
         int ret = 0;

        try {
            String sql = "DELETE FROM endereco WHERE rua = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rua);
            ret= st.executeUpdate();
            st.close();
  } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

public static int exclui3(int numero,String rua ) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM endereco WHERE numero = ? AND rua = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numero);
 st.setString(2, rua);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static int exclui4(int numero,String rua) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM endereco WHERE numero = ? OR rua = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, numero);
 st.setString(2 ,rua);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }

public static List<Endereco> leTodosEnd(String rua) throws Exception {
      
            String sql = "SELECT * FROM ENDERECO WHERE rua like ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1,rua);
            rs = st.executeQuery();
             List<Endereco> listEnderecos = new ArrayList<Endereco>();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                listEnderecos.add(end);
            }
            st.close();
            rs.close();
            return listEnderecos;
    }
  public static void alteraNumero(Endereco endereco) throws Exception {
       
            String sql =  "UPDATE endereco SET  numero = ?, WHERE rua = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, endereco.getNumero());
            st.setString(2, endereco.getRua());
            st.executeUpdate();
            st.close();
       
        }
  



}





