
package testes.funcionario;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Funcionario;
import delegaciaprojetoa3.Login;
import persistencia.FuncionarioDAO;

public class TesteFuncionarioDAOAltera2 {

    public static void main(String[] args)throws Exception{
       Funcionario funcionario = new Funcionario();
       funcionario.setRgFuncionario(1515);;//set
       funcionario.setNome("yan");;//where
       funcionario.setIdade(27);;//set
       
       Login login = new Login();
       login.setUsuario(5);;//set
       funcionario.setLogin(login);
       
       Endereco end = new Endereco();
       end.setNumero(1);;//set
       funcionario.setEndereco(end);
       
        System.out.println(FuncionarioDAO.altera2(funcionario));
    }
    
}
