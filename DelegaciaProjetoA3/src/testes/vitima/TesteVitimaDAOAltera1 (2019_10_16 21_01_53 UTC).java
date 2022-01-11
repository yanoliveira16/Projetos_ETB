package testes.vitima;


import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Vitima;
import persistencia.VitimaDAO;

public class TesteVitimaDAOAltera1 {

    public static void main(String[] args)throws Exception{
       Vitima vitima = new Vitima();
       vitima.setRgVitima("6606006");//where
       vitima.setNome("Gabriel");//set
       vitima.setTelefone("22223333");//set
       vitima.setIdade(23);//set
       
       Endereco endereco = new Endereco();
       endereco.setNumero(3);//set
       vitima.setEndereco(endereco);
        System.out.println(VitimaDAO.altera(vitima));
    }
}
       
    
    

