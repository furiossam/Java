/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.view;

import java.util.Scanner;

/**
 *
 * @author Leonardo, Jean
 */
public class Console {
    /**
     * Entrada e dados.
     */
    private Scanner in;
    /**
     * Construtor de Console sem parametros.
     */
    public Console(){
        in = new Scanner(System.in);
    }
    /**
     * Leitura de valor inteiro.
     * @param question em geral.
     * @return valor inteiro.
     */
    public int readInint(String question)
    {
        System.out.print(question);
        int answer;
        answer = in.nextInt();        
        return answer;
    }
    /**
     * Leitura de valor String.
     * @param question em geral.
     * @return valor String.
     */
    public String readLine(String question)
    {
        System.out.print(question);
        return in.nextLine();
    }
    /**
    * Leitura de valor Float.
    * @param question em geral.
    * @return valor float.
    */
    public float readInfloat(String question){
        System.out.print(question);
        float answer;
        answer = in.nextFloat();
        return answer;
    }
    /**
     * Leitura de valor Boolean.
     * @param question em geral.
     * @return valor Boolean.
     */
    public int readInboolean(String question){
        System.out.print(question);
        String answer;
        answer = in.nextLine();
        if ("V".equalsIgnoreCase(answer))
            return 1;
        else if("F".equalsIgnoreCase(answer))
            return 0;
        else
            return -1;
    }
    /**
     * Leitura de valor Char.
     * @param question em geral.
     * @return valor Char.
     */
    public char readInchar(String question){
        System.out.print(question);
        String answer;
        answer = in.nextLine();
        return answer.charAt(0);
    }
    /**
     * Espera pelo enter
     */
    public void WaitForEnter()
    {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
}

