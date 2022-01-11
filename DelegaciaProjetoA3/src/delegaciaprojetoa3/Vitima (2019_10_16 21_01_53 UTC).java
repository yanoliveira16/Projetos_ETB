package delegaciaprojetoa3;
public class Vitima extends Pessoa {
    
    public static String rgVitima;
    private String telefone;

    public Vitima() {
    }

    
    
    public Vitima(String rgVitima, String telefone, String nome, int idade,Endereco Endereco) {
        super(nome, idade, Endereco);
        Vitima.rgVitima = rgVitima;
        this.telefone = telefone;
    }
    
    

    public String getRgVitima() {
        return rgVitima;
    }

    public void setRgVitima(String rgVitima) {
        Vitima.rgVitima = rgVitima;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String toString(){
        return  "\n Dados da Vitima " +
                "\n Nome: "+getNome()+
                "\n Idade: "+getIdade()+
                "\n "+getEndereco()+
                "\n RG Vitima: "+getRgVitima()+
                "\n Telefone: "+getTelefone();
                
    }
    
}
