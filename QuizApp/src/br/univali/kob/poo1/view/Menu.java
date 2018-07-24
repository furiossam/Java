/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.view;

import br.univali.kob.poo1.control.QuizBowl;
import br.univali.kob.poo1.model.QuestionMC;
import br.univali.kob.poo1.model.QuestionSA;
import br.univali.kob.poo1.model.QuestionTF;
import java.io.IOException;

/**
 *
 * @author Leonardo, Jean
 */
public class Menu {
    /**
     * Objeto quiz do QuizBowl.
     */
    private QuizBowl quiz;
    /**
     * Pergunta o Sobrenome com validação.
     * @return o Sobrenome do jogador.
     */
    private String askLastName(){
        Console cons = new Console();
        boolean flag = false;
        String lastName;
        do {
            lastName = cons.readLine("Qual seu último nome?\n");
            if (lastName.length() >= 3){
                flag = true;
            } else { 
                System.out.println("Sobrenome inválido!");
            }
        } while(!flag);
        return lastName;
    }
    /**
     * Pergunta o Nome com validação.
     * @return o Nome do jogador.
     */
    private String askName(){
        Console cons = new Console();
        boolean flag = false;
        String name;
        do {
            name = cons.readLine("Qual seu primeiro nome? \n");
            if (name.length() >= 3){
                flag = true;
            } else {
                System.out.println("Nome inválido!");
            }
        } while(!flag);
        return name;
    }
    /**
     * Pergunta o Nome do Arquivo com as perguntas.
     * @return o caminho do arquivo.
     */
    private String askPath(){
        Console cons = new Console();
        boolean flag = false;
        String path = null;
        while(!flag){
        path = cons.readLine("Informe o nome do arquivo com a sessão de treinamento: \n");
        flag=true;    
        }
        return path;  
    }
    /**
     * Pergunta o Numero de Questoes para responder.
     * @return o numero de questoes.
     */
    private int askNumberQuestions(){
        Console cons = new Console();
        boolean flag = false;
        int numberQuestions;
        do {
            numberQuestions = cons.readInint("Quantas questões você gostaria de responder(1 a "
                                             + quiz.getQuantityQuestions() + ")? \n");
            if (numberQuestions < 1 || numberQuestions > quiz.getQuantityQuestions()){
                System.out.println("Quantidade inválida!");
            } else {
                flag = true;
            }
        } while(!flag);
        return numberQuestions;
    }
    /**
     * Faz as perguntas de multipla escolha.
     */
    private void askQuestionsMC(){
        for(int i=0;i<quiz.getQuantityQuestions();i++){
            Console cons = new Console();
            if(quiz.getQuestions().get(i) instanceof QuestionMC){
                QuestionMC questao = (QuestionMC) quiz.getQuestions().get(i);
                String answer = cons.readLine(questao.getQuestion());
                if (answer.toUpperCase().charAt(0) == questao.getAnswerMC()){
                    System.out.println("\nCorreto! Você ganhou "+ quiz.getQuestions().get(i).getPoints() +" pontos.\n");
                    quiz.getPlayer().addScore(questao.getPoints());
                }else if(answer.equalsIgnoreCase("PASSAR")){
                    System.out.println("\nVocê optou por pular esta questão.\n");
                }else{
                    System.out.println("\nIncorreto!" + " A resposta correta é "+  questao.getAnswerMC()
                            + " .Você perdeu. "+ quiz.getQuestions().get(i).getPoints() +" pontos.\n");
                    quiz.getPlayer().deleteScore(questao.getPoints());
                }    
            }
        }
    }    
    /**
    * Faz as Perguntas de resposta curta.
    */
    private void askQuestionsSA(){ 
        for(int i=0;i<quiz.getQuantityQuestions();i++){
            Console cons = new Console();    
            if(quiz.getQuestions().get(i) instanceof QuestionSA){
                QuestionSA questao = (QuestionSA) quiz.getQuestions().get(i);
                String answer = cons.readLine(questao.getQuestion());
                if (answer.equalsIgnoreCase(questao.getAnswerSa())){
                    System.out.println("\nCorreto! Você ganhou "+ quiz.getQuestions().get(i).getPoints() +" pontos.\n");
                    quiz.getPlayer().addScore(questao.getPoints());
                }else if(answer.equalsIgnoreCase("PASSAR")){
                    System.out.println("\nVocê optou por pular esta questão.\n");
                }else{
                    System.out.println("\nIncorreto! A resposta correta é "+  questao.getAnswerSa()
                            + " .Você perdeu. "+ quiz.getQuestions().get(i).getPoints() +" pontos.\n");
                    quiz.getPlayer().deleteScore(questao.getPoints());
                }          
            }
        }
    }
    /**
    * Perguntas de verdadeiro ou falso.
    */
    private void askQuestionsTF(){        
        for(int i=0;i<quiz.getQuantityQuestions();i++){
            Console cons = new Console();
            if(quiz.getQuestions().get(i) instanceof QuestionTF){
                QuestionTF questao = (QuestionTF) quiz.getQuestions().get(i);
                int answer = cons.readInboolean(questao.getQuestion());
                if (answer == questao.getAnswerTf()){
                    System.out.println("\nCorreto! Você ganhou "+ quiz.getQuestions().get(i).getPoints() +" pontos.\n");
                    quiz.getPlayer().addScore(questao.getPoints());
                }else if(answer==-1){
                    System.out.println("\nVocê optou por pular esta questão.\n");
                }else{
                    String ans;
                    ans = questao.getAnswerTf()==1?"Verdadeiro":"False";
                    System.out.println("\nIncorreto!A resposta correta é "+  ans
                            + " .Você perdeu. "+ quiz.getQuestions().get(i).getPoints() +" pontos.\n");
                    quiz.getPlayer().deleteScore(questao.getPoints());
                }
            }
        }
    }
    /**
     * Mostra informações da partida do jogador.
     */
    private void showPlayerStats(){
        System.out.println("Fim de jogo!");
        System.out.println("Jogador: " + quiz.getPlayer().getname() +
                           " " + quiz.getPlayer().getLastName());
        System.out.println("Score: " + quiz.getPlayer().getScore() + " pontos.");
    }
    /**
     * Chama os construtores e os metodos necessarios para iniciar o QuizGame,
     * e mostrar as saidas na tela. 
     */
    public void run(){
        String name = askName();
        String lastName = askLastName();
        quiz = new QuizBowl(name,lastName);
        boolean flag=true;
        while(flag){
            try {
                quiz.readFile(askPath());
                flag=false;
            } catch (IOException ex) {
                System.out.println("\nEndereço para arquivo inválido! Tente novamente...\n");
            }
        }
        quiz.setQuantityQuestions(askNumberQuestions());
        quiz.shuffleQuestions();
        askQuestionsMC();
        askQuestionsSA();
        askQuestionsTF();
        showPlayerStats();
    }
}
