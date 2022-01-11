package modelo;

public class JuridicaProduto {

    private int quantidade;
    private Juridica juridica;
    private Produto produto;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Juridica getJuridica() {
        return juridica;
    }

    public void setJuridica(Juridica juridica) {
        this.juridica = juridica;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public JuridicaProduto() {
    }

    public JuridicaProduto(int quantidade, Juridica juridica, Produto produto) {
        this.quantidade = quantidade;
        this.juridica = juridica;
        this.produto = produto;
    }

    public String toString() {
        return "\n" + getJuridica()
                + "\n" + getProduto()
                + "\n Quantidade Fornecida:" + getQuantidade();
    }
}
