package delegaciaprojetoa3;
public class CriminosoVitima {
    
    private String tipoDoCrime;
    private String descricaoDoCrime;
    private String localCrime;
    private String dataCrime;
    private Vitima vitima;
    private Criminoso criminoso;
    private Funcionario funcionario;
    private Arma arma;

    public CriminosoVitima() {
    }
    
    

    public CriminosoVitima(String tipoDoCrime, String descricaoDoCrime, String localCrime, String dataCrime, Vitima vitima, Criminoso criminoso, Funcionario funcionario, Arma arma) {
        this.tipoDoCrime = tipoDoCrime;
        this.descricaoDoCrime = descricaoDoCrime;
        this.localCrime = localCrime;
        this.dataCrime = dataCrime;
        this.vitima = vitima;
        this.criminoso = criminoso;
        this.funcionario = funcionario;
        this.arma = arma;
    }

    
 
    public String toString(){
        return  
                "\n Dados do Funcionario Responsavel por cadastrar o crime: "+getFuncionario()+
                "\n\n Dados do Crime "+
                "\n Tipo do Crime: "+getTipoDoCrime()+
                "\n Descrição do Crime: "+getDescricaoDoCrime()+
                "\n Local do Crime: "+getLocalCrime()+
                "\n Data do Crime: "+getDataCrime()+
                "\n "+getVitima()+
                "\n "+getCriminoso()+
                "\n "+getArma();
    }

    public String getTipoDoCrime() {
        return tipoDoCrime;
    }

    public void setTipoDoCrime(String tipoDoCrime) {
        this.tipoDoCrime = tipoDoCrime;
    }

    public String getDescricaoDoCrime() {
        return descricaoDoCrime;
    }

    public void setDescricaoDoCrime(String descricaoDoCrime) {
       this.descricaoDoCrime=descricaoDoCrime;
    }

    public String getLocalCrime() {
        return localCrime;
    }

    public void setLocalCrime(String localCrime) {
        this.localCrime = localCrime;
    }

    public String getDataCrime() {
        return dataCrime;
    }

    public void setDataCrime(String dataCrime) {
        this.dataCrime = dataCrime;
    }

    public Vitima getVitima() {
        return vitima;
    }

    public void setVitima(Vitima vitima) {
        this.vitima = vitima;
    }

    public Criminoso getCriminoso() {
        return criminoso;
    }

    public void setCriminoso(Criminoso criminoso) {
        this.criminoso = criminoso;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
