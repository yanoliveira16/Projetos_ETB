package testes.vitima;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Vitima;
import persistencia.VitimaDAO;

public class TesteVitimaDAOAltera4 {
    public static void main(String[] args)throws Exception{
       Vitima vitima = new Vitima();
       vitima.setRgVitima("7070");//set
       vitima.setNome("Manoel"); //set 
       vitima.setTelefone("33334444");//where
       vitima.setIdade(26);//or
       
       Endereco endereco = new Endereco();
       endereco.setNumero(3);//set
       vitima.setEndereco(endereco);
        System.out.println(VitimaDAO.altera4(vitima));
    }
    
}
