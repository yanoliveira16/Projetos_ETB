
package testes.funcionario;

import persistencia.FuncionarioDAO;

public class TesteFuncionarioDAOleUm1 {

    public static void main(String[] args)throws Exception{
        System.out.println(FuncionarioDAO.leUm("505050"));
    }
    
}
