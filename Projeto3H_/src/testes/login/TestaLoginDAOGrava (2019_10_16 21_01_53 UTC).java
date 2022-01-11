package testes.login;

import modelo.Login;
import persistencia.LoginDAO;

public class TestaLoginDAOGrava {

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setUsuario(1);
        login.setSenha(123);
        System.out.println(LoginDAO.grava(login));
    }

}
