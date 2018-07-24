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
public abstract class Question {
    /**
     * Perguntas em geral.
     */
    private String question;
    /**
     * Pontuação de cada pergunta.
     */
    private int points;
    /**
     * Construtor de Question.
     * @param question em geral.
     * @param points de cada  pergunta.
     */
    Question(String question, int points){
        this.question = question;
        this.points = points;
    }
    /**
     * @return a pergunta.
     */
    public String getQuestion(){
        return question;
    }
    /**
     * @return a pontuação.
     */
    public int getPoints(){
        return points;
    }
    
}
