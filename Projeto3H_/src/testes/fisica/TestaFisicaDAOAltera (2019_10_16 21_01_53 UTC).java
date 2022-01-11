package testes.fisica;

import modelo.Atendente;
import modelo.Fisica;
import modelo.Login;
import persistencia.FisicaDAO;

public class TestaFisicaDAOAltera {
    public static void main(String[] args) throws Exception{
        Fisica fisica = new Fisica();
        fisica.setNome("");
        fisica.setIdade(1);
        
        Atendente atendente = new Atendente ();
        atendente.setMatr(1);
        fisica.setAtendente(atendente);
        
        Login login = new Login ();
        login.setUsuario(1);
        fisica.setLogin(login);
        
        System.out.println(FisicaDAO.altera(fisica));
    }
    
}
