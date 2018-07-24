/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.control;

import br.univali.kob.poo1.model.Player;
import br.univali.kob.poo1.model.Question;
import br.univali.kob.poo1.model.QuestionMC;
import br.univali.kob.poo1.model.QuestionSA;
import br.univali.kob.poo1.model.QuestionTF;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 *
 * @author Leonardo, Jean
 */
public class QuizBowl {
    /**
     * Quantidade de perguntas do QuizBowl.
     */
    private int quantityQuestions;
    /**
     * Objetos perguntas de Question.
     */
    private ArrayList<Question> questions = new ArrayList<>(); 
    /**
     * Objeto jogador de Player.
     */
    private Player player;
    /**
     * Construtor de QuizBowl para inicializar player.
     * @param name do jogador.
     * @param lastName do jogador.
     */
    public QuizBowl(String name, String lastName) {
        player = new Player(name,lastName);
    }
    /**
     * @return as perguntas.
     */
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    /**
     * @return o jogador.
     */
    public Player getPlayer(){
        return player;
    }
    /**
     * @param quantityQuestions do QuizBowl.
     */
    public void setQuantityQuestions(int quantityQuestions){
        this.quantityQuestions = quantityQuestions;
    }
    /** 
     * @return a quantidade de perguntas do QuizBowl.
     */
    public int getQuantityQuestions(){
        return quantityQuestions;
    }
    /**
     * Baralha as perguntas.
     */
    public void shuffleQuestions(){
        shuffle(questions);
    }
    /**
     * Leitura do arquivo com as perguntas. 
     * @param path do arquivo de perguntas.
     * @throws IOException 
     */
    public void readFile(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "", tipo;
        int contador = 0, questionQuantity = 0;
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                contador++;
            }else
                break;
            if (contador == 2){
                try {
                    questionQuantity = Integer.parseInt(linha);
                } catch (NumberFormatException e) {
                    System.out.println("Numero com formato errado!");
                    return ;
                }
                setQuantityQuestions(questionQuantity);
            }
            else{
                tipo = linha.substring(0, 2);
                /**
                 * Perguntas e respostas de verdadeiro ou falso.
                 */
                if("VF".equals(tipo)){
                    int points;
                    points = Integer.parseInt(linha.substring(3, linha.length()));
                    String question;
                    question = buffRead.readLine();
                    String answer;
                    answer = buffRead.readLine();
                    int answerTF;
                    if("V".equals(answer)){
                        answerTF = 1;
                    }
                    else{
                        answerTF = 0;
                    }
                    QuestionTF questaoVF = new QuestionTF(question, points, answerTF);
                    questions.add(questaoVF);
                }
                /**
                 * Perguntas e respostas de respostas curtas.
                 */
                if("RC".equals(tipo)){
                    int points;
                    points = Integer.parseInt(linha.substring(3, linha.length()));
                    String question;
                    question = buffRead.readLine();
                    String answer;
                    answer = buffRead.readLine();
                    QuestionSA questaoSA = new QuestionSA(question, points, answer);
                    questions.add(questaoSA);
                }
                /**
                 * Perguntas e respostas de multipla escolha.
                 */
                if("ME".equals(tipo)){
                    int points, limite;
                    points = Integer.parseInt(linha.substring(3, linha.length()));
                    String question;
                    question = buffRead.readLine();
                    limite = Integer.parseInt(buffRead.readLine());
                    for(int i=0; i<limite; i++){
                        question += "\n";
                        question += buffRead.readLine();
                    }
                    String answer;
                    answer = buffRead.readLine();
                    QuestionMC questaoME = new QuestionMC(question, points, answer.charAt(0));
                    questions.add(questaoME);
                }
            } 
        }
        buffRead.close();    
    }
}

