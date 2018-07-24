/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Leonardo, Jean
 */
public class Projeto {
    /**
     * Gerente do projeto.
     */
    private Colaborador gerente;
    /**
     * Colaboradores do projeto.
     */
    private ArrayList<Colaborador> colaboradores;
    /**
     * Tarefas do projeto.
     */
    private ArrayList<Tarefa> tarefas;
    /**
     * Nome do projeto.
     */
    private String nome;
    /**
     * Data de inicio do projeto.
     */
    private Date inicio;
    /**
     * Data de fechamento do projeto.
     */
    private Date fechamento;
    /**
     * Construtor de Projetos.
     * @param gerente
     * @param nome
     * @param inicio
     * @param fechamento
     * @throws IllegalArgumentException 
     */
    public Projeto(Colaborador gerente, String nome, Date inicio, Date fechamento)throws IllegalArgumentException{
        if(inicio.before(new Date())||(fechamento.before(inicio))){
            throw new IllegalArgumentException("Data irregular");
        } 
        else{
            this.gerente=gerente;
            this.nome=nome;
            this.inicio=inicio;
            this.fechamento=fechamento;
        }
    }
    /**
     * 
     * @return nome do projeto.
     */
    public String getNome(){
        return nome;
    }
    /**
     * @return data de inicio do projeto.
     */
    public Date getInicio(){
        return inicio;
    }
    /**
     * @return data de fechamento do projeto.
     */
    public Date getFechamento(){
        return fechamento;
    }
    /**
     * @return gerente do projeto.
     */
    public Colaborador getGerente(){
        return gerente;
    }
    /**
     * @return colaboradores do projeto.
     */
    public ArrayList<Colaborador> getColaboradores(){
        return colaboradores;
    }
    /**
     * @return tarefas do projeto.
     */
    public ArrayList<Tarefa> getTarefas(){
        return tarefas;
    }
}
