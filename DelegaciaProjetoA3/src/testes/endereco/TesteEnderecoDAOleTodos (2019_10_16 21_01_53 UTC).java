/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.endereco;

import persistencia.EnderecoDAO;

/**
 *
 * @author 264830
 */
public class TesteEnderecoDAOleTodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception  {
        System.out.println(EnderecoDAO.leTodos());
    }
    
}
