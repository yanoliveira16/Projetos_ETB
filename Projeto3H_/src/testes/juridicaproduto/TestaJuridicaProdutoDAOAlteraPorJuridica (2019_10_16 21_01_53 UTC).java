package testes.juridicaproduto;

import persistencia.JuridicaProdutoDAO;

public class TestaJuridicaProdutoDAOAlteraPorJuridica {
    public static void main(String[] args) throws Exception{
        System.out.println(JuridicaProdutoDAO.alteraPorJuridica("303030", 30, "101010","404040"));
    }
    
}
