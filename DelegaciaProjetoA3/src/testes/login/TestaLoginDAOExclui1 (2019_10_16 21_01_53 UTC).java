package testes.login;

import persistencia.LoginDAO;

public class TestaLoginDAOExclui1 {

    public static void main(String[] args) throws Exception {
        System.out.println(LoginDAO.exclui(3));
    }
}
