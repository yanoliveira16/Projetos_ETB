
package testes.Arma;

import persistencia.ArmaDAO;

public class TesteArmaDAOAltera3 {

    public static void main(String[] args)throws Exception{
        System.out.println(ArmaDAO.altera3("Faca", "Facao", 1010, 4040));
    }                               //antigaDes novoDesc novoNumArma antigoNumArma
    
}
