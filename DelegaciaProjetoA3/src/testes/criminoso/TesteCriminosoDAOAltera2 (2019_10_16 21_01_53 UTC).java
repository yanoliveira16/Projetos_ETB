
package testes.criminoso;

import delegaciaprojetoa3.Criminoso;
import delegaciaprojetoa3.Endereco;
import persistencia.CriminosoDAO;

public class TesteCriminosoDAOAltera2 {
    public static void main(String[] args)throws Exception{
        Criminoso criminoso = new Criminoso();
      criminoso.setNome("João");//where
      criminoso.setIdade(25);//set
      criminoso.setRgCriminoso("808080");//set
      
      Endereco endereco = new Endereco();
      endereco.setNumero(3);//set
      criminoso.setEndereco(endereco);
      
     System.out.println(CriminosoDAO.altera2(criminoso));
    }
}
