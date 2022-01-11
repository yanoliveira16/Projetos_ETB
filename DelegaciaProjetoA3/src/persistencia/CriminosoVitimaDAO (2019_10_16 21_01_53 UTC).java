package persistencia;

import delegaciaprojetoa3.CriminosoVitima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CriminosoVitimaDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    
    public static int gravaPorCriminoso(String rgVitima,String rgCriminoso,String tipoDoCrime, String descricaoDoCrime, String localCrime, String dataCrime,int numeroArma,String rgFuncionario) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO criminosoVitima (Vitima_rgVitima,Criminoso_rgCriminoso,tipoDoCrime,descricaoDoCrime,localCrime,dataCrime,Arma_numeroArma,Funcionario_rgFuncionario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgVitima);
            st.setString(2, rgCriminoso);
            st.setString(3, tipoDoCrime);
            st.setString(4, descricaoDoCrime);
            st.setString(5, localCrime);
            st.setString(6, dataCrime);
            st.setInt(7,numeroArma );
            st.setString(8, rgFuncionario);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    
public static List<CriminosoVitima> leTodosPorCriminoso(String rgCriminoso) throws Exception {
        List<CriminosoVitima> listCriminosoVitimas = new ArrayList<CriminosoVitima>();
        try {
            String sql = "SELECT * FROM vitima v INNER JOIN "
                    + "criminosovitima cv ON v.rgVitima = cv.Vitima_rgVitima "
                    + "WHERE cv.Criminoso_rgCriminoso = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgCriminoso);
            rs = st.executeQuery();
            while (rs.next()) {
                CriminosoVitima cv = new CriminosoVitima();
                cv.setCriminoso(CriminosoDAO.leUm(rs.getString("Criminoso_rgCriminoso")));
                cv.setVitima(VitimaDAO.leUm(rs.getString("Vitima_rgVitima")));
                cv.setTipoDoCrime(rs.getString("tipoDoCrime"));
                cv.setDescricaoDoCrime(rs.getString("descricaoDoCrime"));
                cv.setLocalCrime(rs.getString("localCrime"));
                cv.setDataCrime(rs.getString("dataCrime"));
                cv.setArma(ArmaDAO.leUm(rs.getInt("Arma_numeroArma")));
                cv.setFuncionario(FuncionarioDAO.leUm(rs.getString("Funcionario_rgFuncionario")));
                listCriminosoVitimas.add(cv);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return listCriminosoVitimas;
    }

public static int alteraPorCriminosoVitima(String rgVitima,String novoRgVitima ,String rgCriminoso, String novoRgCriminoso) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE criminosovitima set Vitima_rgVitima = ?, Criminoso_rgCriminoso = ? "
                    + "WHERE Criminoso_rgCriminoso = ? and Vitima_rgVitima = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, novoRgVitima);
            st.setString(2, novoRgCriminoso);
            st.setString(3, rgCriminoso);
            st.setString(4, rgVitima);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        
              if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não carai");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }  

        return ret;
    }

public static int alteraPorVitima(String rgVitima,String novoRgVitima) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE criminosovitima set Vitima_rgVitima = ?"
                    + "WHERE Vitima_rgVitima = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, novoRgVitima);
            st.setString(2, rgVitima);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
         }
        
       
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não carai");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
         return ret;
}
        public static int alteraPorCriminoso(String rgCriminoso,String novoRgCriminoso) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE criminosovitima set Criminoso_rgCriminoso = ?"
                    + "WHERE Criminoso_rgCriminoso = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, novoRgCriminoso);
            st.setString(2, rgCriminoso);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
         }
        
       
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não carai");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
         return ret;
}
        
    
//    public static int alteraPorJuridica(String novoProduto, int novaQuantidade, String cnpj, String codBarra) throws Exception {
//        int ret = 0;
//        try {
//            String sql = "UPDATE juridicaproduto set produto_codbarra = ?, quantidade = ? "
//                    + "WHERE juridica_cnpj = ? and produto_codBarra = ?";
//            connection = GerenteDeConexao.getConnection();
//            st = connection.prepareStatement(sql);
//            st.setString(1, novoProduto);
//            st.setInt(2, novaQuantidade);
//            st.setString(3, cnpj);
//            st.setString(4, codBarra);
//            ret = st.executeUpdate();
//            st.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return ret;
//    }

    public static int excluiPorCriminosoVitima(String rgCriminoso,String rgVitima) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM criminosovitima WHERE Criminoso_rgCriminoso = ? and Vitima_rgVitima = ? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgCriminoso);
            st.setString(2, rgVitima);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não carai");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
        return ret;
    }


public static int excluiPorCriminoso(String rgCriminoso) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM criminosovitima WHERE Criminoso_rgCriminoso = ? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgCriminoso);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não carai");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
        return ret;
    }

public static int excluiPorVitima(String rgVitima) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM criminosovitima WHERE Vitima_rgVitima = ? ";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, rgVitima);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if( ret == 0){
            JOptionPane.showMessageDialog(null,"Não deu não carai");
        }else{
            JOptionPane.showMessageDialog(null,"Deu bom");
        }
        return ret;
    }
}