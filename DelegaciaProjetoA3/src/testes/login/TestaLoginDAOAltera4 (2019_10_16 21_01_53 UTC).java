package testes.login;

import persistencia.FuncionarioDAO;
import persistencia.LoginDAO;

public class TestaLoginDAOAltera4 {
    public static void main(String[] args)throws Exception{
        System.out.println(LoginDAO.altera4(5, 6, 789, 456));
    }
    
}
