
package persistencia;

import delegaciaprojetoa3.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static List<Funcionario> leTodos() throws Exception {
        List<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
        try {
            String sql = "SELECT * FROM FUNCIONARIO";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);;
            rs = st.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setRgFuncionario(rs.getInt("rgFuncionario"));
                f.setLogin(LoginDAO.leUm(rs.getInt("Login_usuarios")));
                f.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                listFuncionarios.add(f);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listFuncionarios;
    }

    public static List<Funcionario> leTodosCad(int rgFuncionario) throws Exception {
      
            String sql = "SELECT * FROM FUNCIONARIO WHERE rgFuncionario like ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1,rgFuncionario);
            rs = st.executeQuery();
             List<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setRgFuncionario(rs.getInt("rgFuncionario"));
                f.setLogin(LoginDAO.leUm(rs.getInt("Login_usuarios")));
                f.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                listFuncionarios.add(f);
            }
            st.close();
            rs.close();
            return listFuncionarios;
    }
    
    
    
    public static Funcionario leUm(String rgFuncionario) throws Exception {
        Funcionario funcionario = new Funcionario();
        try {
            String sql = "SELECT * FROM funcionario WHERE rgFuncionario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgFuncionario);
            rs = st.executeQuery();
            if (rs.next()) {
                funcionario.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                funcionario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuarios")));
                funcionario.setRgFuncionario(rs.getInt("rgFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return funcionario;
    }
    
    public static Funcionario leUm2(String nome) throws Exception {
 Funcionario funcionario = new Funcionario();
 
 try{
 String sql = "SELECT * FROM Funcionario WHERE nome = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 rs = st.executeQuery();
 if (rs.next()) 
 funcionario.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                funcionario.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                funcionario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuarios")));
                funcionario.setRgFuncionario(rs.getInt("rgFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return funcionario;
 }

public static Funcionario leUm3(String nome, int idade) throws Exception {
 Funcionario funcionario = new Funcionario();
 
 try{
 String sql = "SELECT * FROM Funcionario WHERE nome = ? AND idade = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2,idade);
 rs = st.executeQuery();
 if (rs.next()) 
 funcionario.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                funcionario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuarios")));
                funcionario.setRgFuncionario(rs.getInt("rgFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return funcionario;
 }


public static Funcionario leUm4(int Login_usuarios,int Endereco_numero) throws Exception {
 Funcionario funcionario = new Funcionario();
 
 try{
 String sql = "SELECT * FROM Funcionario WHERE Login_usuarios = ? OR  Endereco_numero = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setInt(1, Login_usuarios);
 st.setInt(2, Endereco_numero);
 rs = st.executeQuery();
 if (rs.next()) 
 funcionario.setEndereco(EnderecoDAO.leUm(rs.getInt("Endereco_numero")));
                funcionario.setLogin(LoginDAO.leUm(rs.getInt("Login_usuarios")));
                funcionario.setRgFuncionario(rs.getInt("rgFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return funcionario;
 }

    public static int grava(Funcionario funcionario) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO funcionario (rgFuncionario,nome,Login_usuarios,Endereco_numero,idade) VALUES (?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, funcionario.getRgFuncionario());
            st.setString(2, funcionario.getNome());
            st.setInt(3, funcionario.getLogin().getUsuario());
            st.setInt(4,funcionario.getEndereco().getNumero());
            st.setInt(5,funcionario.getIdade());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int altera(Funcionario funcionario) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE funcionario SET nome = ?, idade = ?, Login_usuarios = ?, Endereco_numero = ? WHERE rgFuncionario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, funcionario.getNome());
            st.setInt(2, funcionario.getIdade()); 
            st.setInt(3, funcionario.getLogin().getUsuario());
            st.setInt(4, funcionario.getEndereco().getNumero());
            st.setInt(5, funcionario.getRgFuncionario());
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+e);
        }
        return ret;
  
    }
    
    public static int altera2(Funcionario funcionario) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE funcionario SET rgFuncionario = ?, idade = ?, Login_usuarios = ?, Endereco_numero = ? WHERE nome = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, funcionario.getRgFuncionario());
            st.setInt(2, funcionario.getIdade()); 
            st.setInt(3, funcionario.getLogin().getUsuario());
            st.setInt(4, funcionario.getEndereco().getNumero());
            st.setString(5, funcionario.getNome());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
public static int altera3(Funcionario funcionario) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE funcionario SET idade = ?,Login_usuarios = ?, Endereco_numero = ? WHERE nome = ? AND rgFuncionario  = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setInt(1, funcionario.getIdade()); 
            st.setInt(2, funcionario.getLogin().getUsuario());
            st.setInt(3, funcionario.getEndereco().getNumero());
            st.setString(4, funcionario.getNome());
            st.setInt(5, funcionario.getRgFuncionario());
            
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
}
 public static int altera4(Funcionario funcionario) throws Exception {
 int ret = 0;
 try {
 String sql = "UPDATE funcionario SET  nome = ?,rgFuncionario = ?,idade = ? WHERE Login_usuarios = ? OR Endereco_numero = ?";
  connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
            st.setString(1, funcionario.getNome());
            st.setInt(2, funcionario.getRgFuncionario());
            st.setInt(3, funcionario.getIdade()); 
            st.setInt(4, funcionario.getLogin().getUsuario());
            st.setInt(5, funcionario.getEndereco().getNumero());
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
 

    public static int exclui(int rgFuncionario) throws Exception {
        int ret = 0;

        try {
            String sql = "DELETE FROM funcionario WHERE rgFuncionario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, rgFuncionario);
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
 String sql = "DELETE FROM funcionario WHERE nome = ?";
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
 String sql = "DELETE FROM funcionario WHERE idade = ? AND Endereco_numero = ?";
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

public static int exclui4(String nome,int rgFuncionario) throws Exception {
 int ret = 0;

 try {
 String sql = "DELETE FROM funcionario WHERE nome = ? OR rgFuncionario = ?";
 connection = GerenteDeConexao.getConnection();
 st = connection.prepareStatement(sql);
 st.setString(1, nome);
 st.setInt(2 ,rgFuncionario);
 ret = st.executeUpdate();
 st.close();
 } catch (SQLException e) {
 System.out.println(e.getMessage());
 }
 return ret;
 }
    
    
    public static void excluiFun(int rgFuncionario) throws Exception{
            String sql = "DELETE FROM funcionario WHERE rgFuncionario = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, rgFuncionario);
            st.executeUpdate();
            st.close();
    }

}

    

