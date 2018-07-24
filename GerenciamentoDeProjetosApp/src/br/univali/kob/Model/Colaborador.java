/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.Model;

/**
 *
 * @author Leonardo, Jean
 */
public class Colaborador {
    /**
     * Nome do colaborador.
     */
    private String nome;
    /**
     * Responsabilidades do colaborador.
     */
    private Responsabilidades papel;
    /**
     * Construtor de colaboradores.
     * @param nome 
     */
    public Colaborador(String nome){
        this.nome=nome; 
    }
    /**
     * Seta uma responsabilidade para colaborador.
     * @param papel 
     */
    public void setPapel(Responsabilidades papel){
        this.papel=papel;
    }
    /**
     * @return papel(responsabilidade do colaborador).
     */
    public Responsabilidades getPapel(){
        return papel;
    }
    
}
