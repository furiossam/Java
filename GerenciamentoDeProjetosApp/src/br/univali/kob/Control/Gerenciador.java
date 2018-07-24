/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.Control;

import br.univali.kob.Model.Atividade;
import br.univali.kob.Model.Colaborador;
import br.univali.kob.Model.Projeto;
import br.univali.kob.Model.Tarefa;
import java.util.ArrayList;

/**
 *
 * @author Leonardo, Jean
 */
public class Gerenciador {
    /**
     * Lista de objetos projetos.
     */
    private ArrayList<Projeto> projetos = new ArrayList<>();
    /*
    * Lista de objetos colaboradores.
    */
    private ArrayList<Colaborador> colaboradores = new ArrayList<>();
    /**
     * @return projetos.
     */
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }
    /**
     * @return colaboradores.
     */
    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }
    /**
     * Adiciona um colaborador em um novo projeto.
     * @param colaborador 
     * @param projeto 
     */
    public void alocaColaborador(Colaborador colaborador,Projeto projeto){
        ArrayList<Colaborador> colaboradores = projeto.getColaboradores();
        colaboradores.add(colaborador);
    }
    /**
     * Cadastra atividades em uma tarefa.
     * @param atividade
     * @param tarefa 
     */
    public void cadastrarAtividade(Atividade atividade,Tarefa tarefa){
        ArrayList<Atividade> atividades = tarefa.getAtividades();
        atividades.add(atividade);    
    }
    /**
     * Consulta atividades concluidas em um projeto.
     * @param projeto 
     */
    public void consultarAtividadesConcluidas(Projeto projeto){
        ArrayList<Tarefa> tarefas = projeto.getTarefas();
        for(int j = 0;j<tarefas.size();j++){
            Tarefa tarefa = tarefas.get(j);
            ArrayList<Atividade> atividades = tarefa.getAtividades();
            for(int k = 0;k<atividades.size();k++){
                if(atividades.get(k).getConcluida()){
                    atividades.get(k).mostra();
                }
            }
        }                       
    }
    /**
     * Consulta tarefas em aberto em um projeto.
     * @param projeto 
     */
    public void consultaTarefasEmAberto(Projeto projeto){
        ArrayList<Tarefa> tarefas = projeto.getTarefas();
        for(int j = 0;j<tarefas.size();j++){
            if(!tarefas.get(j).getConclusao()){
                tarefas.get(j).mostra();
            }
        }
        
    }
    /**
     * Consulta tarefas concluidas em um projeto.
     * @param projeto 
     */
    public void consultaTerefasConcluidas(Projeto projeto){
        ArrayList<Tarefa> tarefas = projeto.getTarefas();
        for(int j = 0;j<tarefas.size();j++){
            if(tarefas.get(j).getConclusao()){
                tarefas.get(j).mostra();
            }
        }
        
    }
    /**
     * Consulta tarefas em aberto em um projeto.
     * @param projeto 
     */
    public void consultaTarefasEmAtraso(Projeto projeto){
        ArrayList<Tarefa> tarefas = projeto.getTarefas();
        for(int j = 0;j<tarefas.size();j++){
            if(tarefas.get(j).getEmAtraso()){
                tarefas.get(j).mostra();
            }
        }
        
    }  
}
