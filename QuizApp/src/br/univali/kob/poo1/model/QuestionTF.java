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
public class QuestionTF extends Question{
    /**
     * Respostas de verdadeiro ou falso.
     */
    private int answerTf;
    /**
     * Construtor de QuestionTF.
     * @param question de verdadeiro ou falso.
     * @param points de cada pergunta para verdadeiro ou falso.
     * @param answerTf de cada pergunta para verdadeiro ou falso.
     */
    public QuestionTF(String question, int points, int answerTf) {
        super(question, points);
        this.answerTf = answerTf;
    }
    /**
     * @return resposta de verdadeiro ou falso.
     */
    public int getAnswerTf(){
       return answerTf;
    }  
}

