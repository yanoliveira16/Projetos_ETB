package testes.vitima;

import delegaciaprojetoa3.Endereco;
import delegaciaprojetoa3.Vitima;
import persistencia.VitimaDAO;

public class TesteVitimaDAOGrava {

    public static void main(String[] args)throws Exception {
        Vitima vitima=new Vitima();
        //rgVitima,telefone,nome,idade,Endereco_numero
        vitima.setRgVitima("6606006");
        vitima.setTelefone("66667777");
        vitima.setNome("Yan");
        vitima.setIdade(19);
        Endereco end = new Endereco();
        end.setNumero(2);
        vitima.setEndereco(end);
        System.out.println(VitimaDAO.grava(vitima));
    }
    
}
