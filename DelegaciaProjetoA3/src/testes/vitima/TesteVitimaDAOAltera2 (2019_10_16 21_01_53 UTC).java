package testes.vitima;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Vitima;
import persistencia.VitimaDAO;

public class TesteVitimaDAOAltera2 {
    public static void main(String[] args)throws Exception{
        Vitima vitima = new Vitima();
       vitima.setRgVitima("6060");//set
       vitima.setNome("yan");//where
       vitima.setTelefone("22223333");//set
       vitima.setIdade(25);//set
       
       Endereco endereco = new Endereco();
       endereco.setNumero(3);//set
       vitima.setEndereco(endereco);
        System.out.println(VitimaDAO.altera2(vitima));
    }
    
}
