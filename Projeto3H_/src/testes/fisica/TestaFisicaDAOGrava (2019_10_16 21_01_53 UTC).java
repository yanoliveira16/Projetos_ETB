package testes.fisica;

import modelo.Atendente;
import modelo.Fisica;
import persistencia.AtendenteDAO;

public class TestaFisicaDAOGrava {
    
    public static void main(String[] args) throws Exception {
        Fisica fisica = new Fisica();
        fisica.setCpf("0202");
        fisica.setNome("Victor ");
        fisica.setIdade(10);
        
        Atendente atendente = new Atendente();
        atendente.setMatr(4);
        atendente.setNome("Jojo");
        fisica.setAtendente(atendente);
        
        System.out.println(AtendenteDAO.grava(atendente));
    }
    
}
