package testes.criminoso;

import delegaciaprojetoa3.Criminoso;
import delegaciaprojetoa3.Endereco;
import persistencia.CriminosoDAO;

public class TesteCriminosoDAOAltera1 {
    public static void main(String[] args)throws Exception {
      Criminoso criminoso = new Criminoso();
      criminoso.setNome("João");//set
      criminoso.setIdade(23);//set
      criminoso.setRgCriminoso("909090");//where
      
      Endereco endereco = new Endereco();
      endereco.setNumero(2);//set
      criminoso.setEndereco(endereco);
      
        System.out.println(CriminosoDAO.altera(criminoso));
        
        //  Ordem dos comandos para melhor funcionamento
//       Grava
//       Altera
//       leUm ou leTodos
//       Exclui,grava,exclui,grava
    }
    
}
