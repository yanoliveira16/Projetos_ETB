package delegaciaprojetoa3;
public class Criminoso extends Pessoa implements TempoDePena,Pena {
    
    /**
     *
     */
    public static String rgCriminoso;

    public Criminoso() {
    }

    
    
    public Criminoso(String rgCriminoso, String nome, int idade, Endereco Endereco) {
        super(nome, idade, Endereco);
        Criminoso.rgCriminoso = rgCriminoso;
    }
    
    @Override
    public Double calculaTempoPenaH(){
        return(penaH*tempoH);
    }
    
    /**
     *
     * @return
     */
    @Override
    public Double calculaTempoPenaA(){
        return(penaA*tempoA);
    }

    public String getRgCriminoso() {
        return rgCriminoso;
    }

    public void setRgCriminoso(String rgCriminoso) {
        Criminoso.rgCriminoso = rgCriminoso;
    }

   
    
    public String toString(){
        return  "\n Dados do Criminoso " +
                "\n Nome: "+getNome()+
                "\n Idade: "+getIdade()+
                "\n "+getEndereco()+
                "\n RG Criminoso: "+getRgCriminoso()+
                "\n Tempo de Pena: "+calculaTempoPenaH()+" anos entre "+calculaTempoPenaA()+" anos";
    }
 
}
