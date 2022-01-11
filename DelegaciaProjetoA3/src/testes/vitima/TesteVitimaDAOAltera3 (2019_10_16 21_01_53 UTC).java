package testes.vitima;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Vitima;
import persistencia.VitimaDAO;

public class TesteVitimaDAOAltera3 {
    public static void main(String[] args)throws Exception{
         Vitima vitima = new Vitima();
       vitima.setRgVitima("6060");// abd
       vitima.setNome("yan");//Where
       vitima.setTelefone("33334444");//set
       vitima.setIdade(26);//set
       
       Endereco endereco = new Endereco();
       endereco.setNumero(2);//set
       vitima.setEndereco(endereco);
        System.out.println(VitimaDAO.altera3(vitima));
    }
    
}

    
    

