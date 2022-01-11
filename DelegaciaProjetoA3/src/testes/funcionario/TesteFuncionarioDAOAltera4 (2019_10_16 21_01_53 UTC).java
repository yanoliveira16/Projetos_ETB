
package testes.funcionario;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Funcionario;
import delegaciaprojetoa3.Login;
import persistencia.FuncionarioDAO;

public class TesteFuncionarioDAOAltera4 {
    public static void main(String[] args)throws Exception{
        Funcionario funcionario = new Funcionario();
       funcionario.setRgFuncionario(3030);;//and
       funcionario.setNome("Yanzin");;//where
       funcionario.setIdade(24);;//set
       
       Login login = new Login();
       login.setUsuario(2);;//set
       funcionario.setLogin(login);
       
       Endereco end = new Endereco();
       end.setNumero(7);;//set
       funcionario.setEndereco(end);
       
        System.out.println(FuncionarioDAO.altera4(funcionario));
    }
}
