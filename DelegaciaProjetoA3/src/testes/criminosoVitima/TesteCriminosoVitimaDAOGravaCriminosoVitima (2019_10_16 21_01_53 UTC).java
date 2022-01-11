
package testes.criminosoVitima;

import persistencia.CriminosoVitimaDAO;

public class TesteCriminosoVitimaDAOGravaCriminosoVitima {

    public static void main(String[] args)throws Exception{
        System.out.println(CriminosoVitimaDAO.gravaPorCriminoso("202020","101010",
                "Homicidio", "Criminoso Matou a Vitima, após reagir a assalto",
                "Brasilia DF", "09/05/2015",5050,"707070"));
        //Vitima_rgVitima,Criminoso_rgCriminoso,
        //tipoDoCrime,descricaoDoCrime,
        //localCrime,dataCrime,Arma_numeroArma,Funcionario_rgFuncionario
    }
}
