package testes.juridicaproduto;

import persistencia.JuridicaProdutoDAO;

public class TestaJuridicaProdutoDAOExcluiPorJuridica {
    public static void main(String[] args)throws Exception {
        System.out.println(JuridicaProdutoDAO.excluiPorJuridica("202020"));
    }
    
}
