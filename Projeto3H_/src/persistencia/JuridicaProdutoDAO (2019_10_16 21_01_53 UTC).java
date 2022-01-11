package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class JuridicaProdutoDAO {

    private static Connection connection;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static int gravaPorJuridica(String cnpj, String codBarra, int quantidade) throws Exception {
        int ret = 0;
        try {
            String sql = "INSERT INTO JuridicaProduto (Juridica_cnpj,Produto_codBarra,quantidade) VALUES (?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cnpj);
            st.setString(2, codBarra);
            st.setInt(3, quantidade);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static List<Produto> leTodosPorJuridica(String cnpj) throws Exception {
        List<Produto> listProdutos = new ArrayList<Produto>();
        try {
            String sql = "SELECT * FROM produto p INNER JOIN "
                    + "juridicaproduto jp ON p.codBarra = jp.produto_codBarra "
                    + "WHERE jp.juridica_cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cnpj);
            rs = st.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodBarra(rs.getString("codBarra"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                listProdutos.add(produto);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listProdutos;
    }

    public static int alteraPorJuridica(String novoProduto, int novaQuantidade, String cnpj, String codBarra) throws Exception {
        int ret = 0;
        try {
            String sql = "UPDATE juridicaproduto set produto_codbarra = ?, quantidade = ? "
                    + "WHERE juridica_cnpj = ? and produto_codBarra = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, novoProduto);
            st.setInt(2, novaQuantidade);
            st.setString(3, cnpj);
            st.setString(4, codBarra);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public static int excluiPorJuridica(String cnpj) throws Exception {
        int ret = 0;
        try {
            String sql = "DELETE FROM JuridicaProduto WHERE Juridica_cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cnpj);
            ret = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
}
