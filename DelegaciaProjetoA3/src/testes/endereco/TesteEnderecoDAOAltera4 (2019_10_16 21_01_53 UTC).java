package testes.endereco;

import persistencia.EnderecoDAO;

public class TesteEnderecoDAOAltera4 {
    public static void main(String[] args)throws Exception{
        System.out.println(EnderecoDAO.altera4(11, 12, "Dos mares", "Cacetada"));
    }                                    //newNum  oldNum  oldRua    newRua 
    
}
