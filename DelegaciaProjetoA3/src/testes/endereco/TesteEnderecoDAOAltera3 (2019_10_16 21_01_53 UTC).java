
package testes.endereco;
import persistencia.EnderecoDAO;
public class TesteEnderecoDAOAltera3 {
    public static void main(String[] args)throws Exception{
        System.out.println(EnderecoDAO.altera3("Dos mares", "miseria", 12, 11)); 
    }                                         //oldRua     novaRua   newNum  oldNum
}
