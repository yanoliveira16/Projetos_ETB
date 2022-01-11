package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOAltera {

    public static void main(String[] args) throws Exception {
        System.out.println(AtendenteDAO.altera("Francisco", 10));
    }

}
