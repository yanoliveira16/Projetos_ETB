package testes.login;

import delegaciaprojetoa3.Login;
import persistencia.LoginDAO;

public class TestaLoginDAOGrava {

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setUsuario(5);
        login.setSenha(789);
        System.out.println(LoginDAO.grava(login));
    }

}
