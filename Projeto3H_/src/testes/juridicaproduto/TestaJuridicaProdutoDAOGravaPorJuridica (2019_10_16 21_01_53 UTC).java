package testes.juridicaproduto;

import persistencia.JuridicaProdutoDAO;

public class TestaJuridicaProdutoDAOGravaPorJuridica {
    public static void main(String[] args) throws Exception {
        System.out.println(JuridicaProdutoDAO.gravaPorJuridica("202020","404040", 400));
    }
    
}
