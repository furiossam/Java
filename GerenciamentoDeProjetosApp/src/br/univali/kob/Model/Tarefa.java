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
public class Tarefa {
    /**
     * Atividades em uma tarefa.
     */
    private ArrayList<Atividade> atividades;
    /**
     * nome da Tarefa.
     */
    private String nome;
    /**
     * descriçao da Tarefa.
     */
    private String descricao;
    /**
     * data de inicio da Tarefa.
     */
    private Date inicio;
    /**
     * data fechamento da Tarefa.
     */
    private Date fechamento;
    /**
     * status da tarefa (concluida ou nao concluida).
     */
    private boolean concluida;
    /**
     * status da tarefa (em atraso ou em dia).
     */
    private boolean emAtraso;
    /**
     * Construtor de tarefas.
     * @param nome
     * @param descricao
     * @param inicio
     * @param fechamento
     * @param projeto 
     */
    public Tarefa(String nome, String descricao, Date inicio, Date fechamento, Projeto projeto) {
        if(inicio.before(new Date())||(fechamento.before(inicio))||(inicio.before(projeto.getInicio()))){
            throw new IllegalArgumentException("Data irregular");
        }
        else{
            this.descricao=descricao;
            this.nome=nome;
            this.inicio=inicio;
            this.fechamento=fechamento;
            this.concluida=false;
            this.emAtraso=false;
        }
    }
    /**
     * @return nome da tarefa.
     */
    public String getNome(){
        return nome;
    }
    /**
     * @return descriçao da tarefa.
     */
    public String getDescricao(){
        return descricao;
    }
    /**
     * @return data de inicio da tarefa.
     */
    public Date getInicio(){
        return inicio;
    }
    /**
     * @return data de fechamento da tarefa.
     */
    public Date getFechamento(){
        return fechamento;
    }
    /**
     * @return status (concluida ou nao concluida).
     */
    public boolean getConclusao(){
        return concluida;
    }
    /**
     * @return status (em atraso ou em dia).
     */
    public boolean getEmAtraso(){
        return emAtraso;
    }
    /**
     * @return atividades de uma tarefa.
     */
    public ArrayList<Atividade> getAtividades(){
        return atividades;
    }
    /**
     * Imprime as informaçoes de uma tarefa.
     */
    public void mostra(){
        System.out.println("Nome: "+ getNome());
        System.out.println("Descrição: "+ getDescricao());
    }
    
}
