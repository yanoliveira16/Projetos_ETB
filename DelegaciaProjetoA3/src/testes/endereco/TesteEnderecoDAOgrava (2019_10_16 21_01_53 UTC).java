/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.endereco;

import persistencia.EnderecoDAO;
import delegaciaprojetoa3.Endereco;

/**
 *
 * @author 264830
 */
public class TesteEnderecoDAOgrava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Endereco end=new Endereco();
        end.setNumero(11);
        end.setRua("Cacetada");
        System.out.println(EnderecoDAO.grava(end));
    }
    
}
