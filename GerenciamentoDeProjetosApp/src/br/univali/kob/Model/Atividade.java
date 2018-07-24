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
public class Atividade {
    /**
     * Nome da atividade.
     */
    private String nome;
    /**
     * Descricao da atividade.
     */
    private String descricao;
    /**
     * Esforço da atividade.
     */
    private int esforco;
    /**
     * Representa um status da atividade se esta concluida ou nao.
     */
    private boolean concluida;
    /**
     * Representa um status da atividade se esta em atraso ou nao.
     */
    private boolean emAtraso;
    /**
     * Construtor de Atividades.
     * @param nome
     * @param descricao
     * @param esforco 
     */
    public Atividade(String nome,String descricao,int esforco){
        this.nome=nome;
        this.descricao=descricao;
        this.esforco=esforco;
        this.concluida=false;
        this.emAtraso=false;
    }
    /**
     * @return nome da atividade.
     */
    public String getNome(){
        return nome;
    }
    /**
     * @return descriçao da atividade.
     */
    public String getDescricao(){
        return descricao;
    }
    /**
     * @return esforço da atividade.
     */
    public int getEsforco(){
        return esforco;
    }
    /**
     * @return um status de conclusao ou nao conclusao.
     */
    public boolean getConcluida(){
        return concluida;
    }
    /**
     * @return um status de atraso ou em dia.
     */
    public boolean getEmAtraso(){
        return emAtraso;
    }
    /**
     * Imprime na tela as informacoes da atividade.
     */
    public void mostra(){
        System.out.println("Nome: "+ getNome());
        System.out.println("Descrição: "+ getDescricao());
    }
}

