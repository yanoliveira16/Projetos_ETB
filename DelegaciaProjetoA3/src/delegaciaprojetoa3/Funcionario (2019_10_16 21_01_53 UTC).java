package delegaciaprojetoa3;
public class Funcionario extends Pessoa {
    
    public static int rgFuncionario;
    private Login login;

    public Funcionario() {
    }
    
    

    public Funcionario(int rgFuncionario, Login login, String nome, int idade,Endereco Endereco) {
        super(nome, idade, Endereco);
        Funcionario.rgFuncionario = rgFuncionario;
        this.login = login;
    }
    
    public int getRgFuncionario() {
        return rgFuncionario;
    }

    public void setRgFuncionario(int rgFuncionario) {
        Funcionario.rgFuncionario = rgFuncionario;
    }


    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public String toString(){
        return  
                "\n Nome: "+getNome()+
                "\n"+getEndereco()+
                "\n "+getLogin()+
                "\n Idade: "+getIdade()+
                "\n RG Funcionario: "+getRgFuncionario();
                
    }
}
