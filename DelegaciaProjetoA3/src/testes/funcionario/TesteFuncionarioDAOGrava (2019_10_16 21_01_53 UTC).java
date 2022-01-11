package testes.funcionario;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Funcionario;
import delegaciaprojetoa3.Login;
import persistencia.FuncionarioDAO;

public class TesteFuncionarioDAOGrava {

    public static void main(String[] args)throws Exception{
    Funcionario funcionario=new Funcionario();
        funcionario.setRgFuncionario(707070);
        funcionario.setIdade(25);
        funcionario.setNome("Wilson");
        Login log = new Login();
        log.setUsuario(1);
        funcionario.setLogin(log);
        Endereco end = new Endereco();
        end.setNumero(2);
        funcionario.setEndereco(end);
        System.out.println(FuncionarioDAO.grava(funcionario));
    }
    
}