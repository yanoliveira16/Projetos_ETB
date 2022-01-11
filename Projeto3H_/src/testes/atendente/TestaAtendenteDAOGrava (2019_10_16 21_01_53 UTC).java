package testes.atendente;

import modelo.Atendente;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOGrava {

    public static void main(String[] args) throws Exception {
        Atendente atendente = new Atendente();
        atendente.setMatr(10);
        atendente.setNome("Joaquim");
        System.out.println(AtendenteDAO.grava(atendente));
    }

}
