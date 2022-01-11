
package delegaciaprojetoa3;
public class Arma {
    
    private String descricaoArma;
    private int numeroArma;

    public Arma() {
    }
    
    

    public Arma(String descricaoArma, int numeroArma) {
        this.descricaoArma = descricaoArma;
        this.numeroArma = numeroArma;
    }
    
    

    public String getDescricaoArma() {
        return descricaoArma;
    }

    public void setDescricaoArma(String descricaoArma) {
        this.descricaoArma = descricaoArma;
    }

    public int getNumeroArma() {
        return numeroArma;
    }

    public void setNumeroArma(int numeroArma) {
        this.numeroArma = numeroArma;
    }
    
    public String toString(){
        return  "\n Dados da Arma " +
                "\n Descrição Arma: "+getDescricaoArma()+
                "\n Número da Arma: "+getNumeroArma();
    }

    
}
