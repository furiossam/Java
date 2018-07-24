/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoM1.Sudoku.br.univali.kob.poo1.TrabalhoM1;

import java.util.Scanner;

/**
 *
 * @author Leonardo,Jean
 */
public class Console {
    
    private Scanner in;
    
    public Console(){
        in = new Scanner(System.in);
    }
    /**
     * 
     * @param question
     * @return uma string
     */
    public int readInint(String question)
    {
        System.out.print(question);
        int answer;
        answer = in.nextInt();        
        return answer;
    }
    /**
     * 
     * @param question
     * @return o inteiro
     */
    public String readLine(String question)
    {
        System.out.print(question);
        return in.nextLine();
    }
    /**
    *
    * @param question
    * @return o float
    */
    public float readInfloat(String question){
        System.out.print(question);
        float answer;
        answer = in.nextFloat();
        return answer;
        
    }
    
    /**
     * Espera pelo enter
     */
    public void WaitForEnter()
    {
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }
}
