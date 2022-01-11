package modelo;

public class Atendente {

    private int matr;
    private String nome;

    public int getMatr() {
        return matr;
    }

    public void setMatr(int matr) {
        this.matr = matr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Atendente() {
    }

    public Atendente(int matr, String nome) {
        this.matr = matr;
        this.nome = nome;
    }

    public String toString() {
        return "\n * Dados do Atendente"
                + "\n     Matrícula:" + getMatr()
                + "\n     Nome:" + getNome();
    }
}
