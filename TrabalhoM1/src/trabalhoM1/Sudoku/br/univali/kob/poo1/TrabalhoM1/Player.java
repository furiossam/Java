/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoM1.Sudoku.br.univali.kob.poo1.TrabalhoM1;

/**
 *
 * @author Leonardo,Jean
 */
public class Player {

    private static String name;
    /*
    * @param name
    * Contrutod de Player com parametro name obrigatório. 
    */
    Player(String name) {
        this.name=name;
    }
    /*
    * @return O nome do jogador.
    */
    public String getNome(){
        return name;
    }
    
}
