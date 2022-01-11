package testes.juridica;

import modelo.Juridica;
import modelo.Login;
import persistencia.JuridicaDAO;

public class TestaJuridicaDAOGrava {
    public static void main(String[] args) throws Exception{
        Juridica juridica = new Juridica();
        juridica.setCnpj("606060");
        juridica.setNome("Teste Produtos");
        juridica.setIdade(100);
        
        Login login = new Login ();
        login.setUsuario(2);
        juridica.setLogin(login);
        
        System.out.println(JuridicaDAO.grava(juridica));
    }
    
}
