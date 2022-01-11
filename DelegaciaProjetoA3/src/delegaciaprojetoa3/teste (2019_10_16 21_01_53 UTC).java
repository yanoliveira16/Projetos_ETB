package delegaciaprojetoa3;
public class teste {
    public static void main(String[] args) {
        
        CriminosoVitima cv = new CriminosoVitima("Homicidio","Criminoso Matou a vitima, pois a mesma reagiu","Brasilia DF", "09/06/2019",
                             new Vitima("3355445","9848448871","Joana",45,
                             new Endereco("V", 6)),
                             new Criminoso("8787448","Sebastiao",30,
                             new Endereco("São Joao", 16)),
                             new Funcionario(8485457,
                             new Login(1, 123),"João",28,
                             new Endereco("Riacho Fundo", 10)),
                             new Arma("Preta", 5457));
        
        System.out.println(cv);
    }
    
}
