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
public class QuestionSA extends Question{
    /**
     * Respostas curtas de uma palavra.
     */
    private String answerSa;
    /**
     * Construtor de QuestionSA.
     * @param question de resposta curta.
     * @param points de cada pergunta para resposta curta.
     * @param answerSa de cada pergunta para resposta curta.
     */
    public QuestionSA(String question, int points, String answerSa) {
        super(question, points);
        this.answerSa = answerSa;
    }
    /**
     * @return resposta curta de uma palavra.
     */
    public String getAnswerSa(){
        return answerSa;
    }
    
}

