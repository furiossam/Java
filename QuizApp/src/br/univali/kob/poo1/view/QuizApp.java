/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.view;

import java.io.IOException;

/**
 *
 * @author Leonardo, Jean
 */
public class QuizApp {
    /**
     * Inicializador do jogo Quiz.
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        Menu quizGame = new Menu();
        
        quizGame.run();   
    }
}
