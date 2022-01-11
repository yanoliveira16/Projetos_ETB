package testes.juridica;

import modelo.Juridica;
import modelo.Login;
import persistencia.JuridicaDAO;

public class TestaJuridicaDAOAltera {

    public static void main(String[] args) throws Exception{
        Juridica juridica = new Juridica ();
        juridica.setCnpj("606060");
        juridica.setNome("Pró Teste Produtos");
        juridica.setIdade(1000);
        
        Login login = new Login();
        login.setUsuario(4);
        juridica.setLogin(login);
        
        System.out.println(JuridicaDAO.altera(juridica));
    }
    
}
