package modelo;

public class Produto {

    private String codBarra;
    private String nome;
    private Double preco;

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto() {
    }

    public Produto(String codBarra, String nome, Double preco) {
        this.codBarra = codBarra;
        this.nome = nome;
        this.preco = preco;
    }

    public String toString() {
        return "\n Dados do Produto:"
                + "\n Código de Barras:" + getCodBarra()
                + "\n Nome:" + getNome()
                + "\n Preço:" + getPreco();
    }
}
