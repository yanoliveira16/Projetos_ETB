package modelo;

public class Juridica extends Pessoa {

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Juridica() {
    }

    public Juridica(String nome, int idade, Login login, String cnpj) {
        super(nome, idade, login);
        this.cnpj = cnpj;
    }

    public String toString() {
        return "\n Dados da Pessoa Jurídica:"
                + "\n CNPJ:" + getCnpj()
                + "\n Nome:" + getNome()
                + "\n Idade:" + getIdade()
                + getLogin();
    }
}
