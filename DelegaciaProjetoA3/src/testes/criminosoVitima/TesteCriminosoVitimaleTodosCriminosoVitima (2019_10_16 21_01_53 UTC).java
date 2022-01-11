
package testes.criminosoVitima;

import persistencia.CriminosoVitimaDAO;

public class TesteCriminosoVitimaleTodosCriminosoVitima {

    public static void main(String[] args)throws Exception{
        System.out.println(CriminosoVitimaDAO.leTodosPorCriminoso("808080"));
    }
    
}
