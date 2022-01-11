
package testes.endereco;
import delegaciaprojetoa3.Endereco;
import persistencia.EnderecoDAO;
public class TesteEnderecoDAOAltera2 {
    public static void main(String[] args)throws Exception{
         Endereco end = new Endereco();
        end.setNumero(11);//set
        end.setRua("Dos mares");//where
    }
    
}
