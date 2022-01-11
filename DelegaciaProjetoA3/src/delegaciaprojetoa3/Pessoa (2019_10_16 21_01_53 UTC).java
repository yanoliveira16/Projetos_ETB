
package delegaciaprojetoa3;
public abstract class Pessoa {
    
    private String nome;
    public static int idade;
    private Endereco Endereco;

    public Pessoa() {
    }
    
    

    public Pessoa(String nome, int idade, Endereco Endereco) {
        this.nome = nome;
        this.idade = idade;
        this.Endereco = Endereco;
    }
    
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

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.Endereco = Endereco;
    }
    
    public abstract String toString();
}
    

