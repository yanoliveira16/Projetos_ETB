package testes.produto;

import persistencia.ProdutoDAO;

public class TestaProdutoDAOLeTodos {

    public static void main(String[] args) throws Exception{
        System.out.println(ProdutoDAO.leTodos());
    }
    
}
