
package testes.criminosoVitima;

import persistencia.CriminosoVitimaDAO;

public class TesteCriminosoVitimaDAOExcluiCriminoso {

    public static void main(String[] args)throws Exception{
        System.out.println(CriminosoVitimaDAO.excluiPorCriminoso("707070"));
    }
    
}
