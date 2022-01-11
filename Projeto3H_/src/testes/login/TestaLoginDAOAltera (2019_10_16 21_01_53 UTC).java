package testes.login;

import persistencia.LoginDAO;

public class TestaLoginDAOAltera {

    public static void main(String[] args) throws Exception {
        System.out.println(LoginDAO.altera(1, 321));
    }
}
