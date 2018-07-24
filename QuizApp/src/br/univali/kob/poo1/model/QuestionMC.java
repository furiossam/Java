/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.model;

/**
 *
 * @author Leonardo, Jean
 */
public class QuestionMC extends Question {
    /**
     * Respostas de multipla escolha.
     */
    private char answerMC;
    /**
     * Construtor de QuestionMC.
     * @param question de multipla escolha.
     * @param points de cada pergunta multipla escolha.
     * @param answerMC de cada pergunta multipla escolha.
     */
    public QuestionMC(String question, int points,char answerMC){
        super(question, points);
        this.answerMC = answerMC;  
    }
    /**
     * @return a resposta de multipla escolha. 
     */
    public char getAnswerMC(){
        return answerMC;
    }
    
}
