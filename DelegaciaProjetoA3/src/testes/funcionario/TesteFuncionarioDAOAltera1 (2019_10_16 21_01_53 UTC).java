
package testes.funcionario;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Funcionario;
import delegaciaprojetoa3.Login;
import persistencia.FuncionarioDAO;


public class TesteFuncionarioDAOAltera1 {

    public static void main(String[] args) throws Exception {
       Funcionario funcionario = new Funcionario();
       funcionario.setRgFuncionario(606060);;//where
       funcionario.setNome("Diego");;//set
       funcionario.setIdade(24);;//set
       
       Login login = new Login();
       login.setUsuario(1);;//set
       funcionario.setLogin(login);
       
       Endereco end = new Endereco();
       end.setNumero(3);;//set
       funcionario.setEndereco(end);
       
        System.out.println(FuncionarioDAO.altera(funcionario));
    }
    
}
