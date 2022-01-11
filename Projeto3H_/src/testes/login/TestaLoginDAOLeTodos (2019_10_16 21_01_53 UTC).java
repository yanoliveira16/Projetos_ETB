package testes.login;

import persistencia.LoginDAO;

public class TestaLoginDAOLeTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(LoginDAO.leTodos());
    }
}
