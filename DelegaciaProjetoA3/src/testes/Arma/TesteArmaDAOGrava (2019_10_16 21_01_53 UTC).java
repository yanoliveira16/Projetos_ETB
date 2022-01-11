package testes.Arma;


import delegaciaprojetoa3.Arma;
import persistencia.ArmaDAO;

public class TesteArmaDAOGrava {
    public static void main(String[] args)throws Exception{
      Arma arma = new Arma();
      arma.setNumeroArma(3838);
      arma.setDescricaoArma("Revolver");
        System.out.println(ArmaDAO.grava(arma));
        
//       Ordem dos comandos para melhor funcionamento
//       Grava
//       Altera
//       leUm ou leTodos
//       Exclui,grava,exclui,grava

    
    
    }
    
}
