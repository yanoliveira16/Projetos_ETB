package testes.produto;

import modelo.Produto;
import persistencia.ProdutoDAO;

public class TestaProdutoDAOGrava {

    public static void main(String[] args) throws Exception {
            Produto produto = new Produto();
            produto.setNome("Carlos");
            produto.setPreco(12.0);
            produto.setCodBarra("1234");
            System.out.println(ProdutoDAO.grava(produto));
    }
    
}
