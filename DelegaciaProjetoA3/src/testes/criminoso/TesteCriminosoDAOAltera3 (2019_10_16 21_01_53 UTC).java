
package testes.criminoso;

import delegaciaprojetoa3.Criminoso;
import delegaciaprojetoa3.Endereco;
import persistencia.CriminosoDAO;

public class TesteCriminosoDAOAltera3 {
    public static void main(String[] args)throws Exception{
        Criminoso criminoso = new Criminoso();
        criminoso.setRgCriminoso("808080");//AND
        criminoso.setIdade(30);//set
        Endereco end = new Endereco();
        end.setNumero(1);//set
        criminoso.setEndereco(end);
        criminoso.setNome("João");//Where
        
        System.out.println(CriminosoDAO.altera3(criminoso));
        
        
      
    }
    
}
