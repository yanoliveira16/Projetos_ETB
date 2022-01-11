
package testes.funcionario;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Funcionario;
import delegaciaprojetoa3.Login;
import persistencia.FuncionarioDAO;

public class TesteFuncionarioDAOAltera3 {

    public static void main(String[] args)throws Exception{
        Funcionario funcionario = new Funcionario();
       funcionario.setRgFuncionario(1515);;//set
       funcionario.setNome("yan");;//and
       funcionario.setIdade(23);
       
       Login login = new Login();
       login.setUsuario(2);;//set
       funcionario.setLogin(login);
       
       Endereco end = new Endereco();
       end.setNumero(7);;//where
       funcionario.setEndereco(end);
       
        System.out.println(FuncionarioDAO.altera3(funcionario));
    }
    
}
