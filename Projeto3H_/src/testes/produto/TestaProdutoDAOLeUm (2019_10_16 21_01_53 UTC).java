package testes.produto;

import persistencia.ProdutoDAO;

public class TestaProdutoDAOLeUm {
    public static void main(String[] args) throws Exception{
        System.out.println(ProdutoDAO.leUm("12345"));
    }
    
}
