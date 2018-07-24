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
public class Player {
    /**
     * nome do jogador.
     */
    private String name;
    /**
     * Sobrenome do jogador.
     */
    private String lastName;
    /**
     * Pontos do jogador.
     */
    private int score;
    /**
     * Construtor de Player.
     * @param name do jogador.
     * @param lastName do jogador.
     */
    public Player(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
        this.score=0;
    }
    /**
     * @return o nome do jogador.
     */
    public String getname(){
        return name;
    }
    /**
     * @return o Sobrenome do jogador.
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * @param score do jogador.
     */
    public void setScore(int score){
        this.score = score;
    }
    /**
     * @return score do jogador.
     */
    public int getScore(){
        return score;
    }
    /**
     * Adiciona pontos para o jogador.
     * @param score do jogador.
     */
    public void addScore(int score){
        this.score += score;
    }
    /**
     * Remove pontos do jogador.
     * @param score do jogador.
     */
    public void deleteScore(int score){
        this.score -= score;
    }
}
