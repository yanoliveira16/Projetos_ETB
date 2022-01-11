package testes.login;

import persistencia.LoginDAO;

public class TestaLoginDAOExclui {

    public static void main(String[] args) throws Exception {
        System.out.println(LoginDAO.exclui(10));
    }
}
