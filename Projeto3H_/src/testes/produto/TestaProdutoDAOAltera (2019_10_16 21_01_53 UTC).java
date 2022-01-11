package testes.produto;

import modelo.Produto;
import persistencia.ProdutoDAO;

public class TestaProdutoDAOAltera {
     public static void main(String[] args) throws Exception {
        
         Produto produto = new Produto ();
         produto.setNome("Victor");
         produto.setPreco(10.5);
         produto.setCodBarra("123");
         System.out.println(ProdutoDAO.altera(produto));
         
    }
    
}
