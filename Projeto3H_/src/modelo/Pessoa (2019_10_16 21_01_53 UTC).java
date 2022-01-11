package modelo;

public abstract class Pessoa {

    private String nome;
    private int idade;
    private Login login;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, Login login) {
        this.nome = nome;
        this.idade = idade;
        this.login = login;
    }
}
