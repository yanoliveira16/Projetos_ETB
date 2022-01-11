package modelo;

public class Fisica extends Pessoa {

    private String cpf;
    private Atendente atendente;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Fisica() {
    }

    public Fisica(String nome, int idade, Login login, String cpf, Atendente atendente) {
        super(nome, idade, login);
        this.cpf = cpf;
        this.atendente = atendente;
    }

    public String toString() {
        return "\n Dados da Pessoa Física:"
                + "\n CPF:" + getCpf()
                + "\n Nome:" + getNome()
                + "\n Idade:" + getIdade()
                + "\n Dados do Login:" + getLogin()
                + "\n Dados do Atendente:" + getAtendente();
    }

}
