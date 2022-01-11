
package testes.Arma;

import delegaciaprojetoa3.Arma;
import persistencia.ArmaDAO;

public class TesteArmaDAOAltera1 {

    public static void main(String[] args)throws Exception{
       Arma arma = new Arma();
       arma.setNumeroArma(3838); //where
       arma.setDescricaoArma("Faca"); //set
        System.out.println(ArmaDAO.altera(arma));
       
    }
    
}
