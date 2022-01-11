
package testes.criminosoVitima;

import persistencia.CriminosoVitimaDAO;

public class TesteCriminosoVitimaDAOExcluiVitima {
    public static void main(String[] args)throws Exception{
        System.out.println(CriminosoVitimaDAO.excluiPorVitima("202020"));
    }
    
}
