package testes.juridicaproduto;

import persistencia.JuridicaProdutoDAO;

public class TestaJuridicaProdutoDAOLeTodosPorJuridica {
    public static void main(String[] args) throws Exception {
        System.out.println(JuridicaProdutoDAO.leTodosPorJuridica("202020"));
    }
    
}
