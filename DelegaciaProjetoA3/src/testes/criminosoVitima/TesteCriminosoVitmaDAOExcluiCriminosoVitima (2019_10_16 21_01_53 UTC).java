package testes.criminosoVitima;

import persistencia.CriminosoVitimaDAO;

public class TesteCriminosoVitmaDAOExcluiCriminosoVitima {
    public static void main(String[] args)throws Exception{
        System.out.println(CriminosoVitimaDAO.excluiPorCriminosoVitima("707070", "101010"));
    }
    
}
