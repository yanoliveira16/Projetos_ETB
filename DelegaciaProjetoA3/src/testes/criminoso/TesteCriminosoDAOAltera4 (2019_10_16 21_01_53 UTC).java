
package testes.criminoso;

import delegaciaprojetoa3.Criminoso;
import delegaciaprojetoa3.Endereco;
import persistencia.CriminosoDAO;

public class TesteCriminosoDAOAltera4 {

    public static void main(String[] args)throws Exception{
     Criminoso criminoso = new Criminoso();
        criminoso.setRgCriminoso("808080");;//set
        criminoso.setIdade(30);//Where
        Endereco end = new Endereco();
        end.setNumero(1);//Where
        criminoso.setEndereco(end);
        criminoso.setNome("Marcos");//set
        
        System.out.println(CriminosoDAO.altera4(criminoso));
        
    }
    
}
