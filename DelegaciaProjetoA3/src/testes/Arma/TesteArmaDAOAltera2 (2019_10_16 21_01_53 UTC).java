
package testes.Arma;

import delegaciaprojetoa3.Arma;
import persistencia.ArmaDAO;

public class TesteArmaDAOAltera2 {

    public static void main(String[] args)throws Exception{
        Arma arma = new Arma();
       arma.setNumeroArma(4040); //set
       arma.setDescricaoArma("Faca"); //where
        System.out.println(ArmaDAO.altera2(arma));
       
    }
    
}
