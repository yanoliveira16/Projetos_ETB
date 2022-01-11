
package testes.criminoso;

import delegaciaprojetoa3.Criminoso;
import delegaciaprojetoa3.Endereco;
import persistencia.CriminosoDAO;

public class TesteCriminosoDAOGrava {

    public static void main(String[] args)throws Exception {
        Criminoso criminoso=new Criminoso();
        criminoso.setRgCriminoso("808080");
        criminoso.setNome("Carlim");
        criminoso.setIdade(19);
        Endereco end = new Endereco();
        end.setNumero(2);
        criminoso.setEndereco(end);
        System.out.println(CriminosoDAO.grava(criminoso));
    }
    
}
    
    

