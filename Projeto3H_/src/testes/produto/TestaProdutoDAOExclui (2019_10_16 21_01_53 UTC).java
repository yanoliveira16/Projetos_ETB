package testes.produto;

import persistencia.ProdutoDAO;

public class TestaProdutoDAOExclui {

    public static void main(String[] args) throws Exception {
        System.out.println(ProdutoDAO.exclui("123"));
    }

}
