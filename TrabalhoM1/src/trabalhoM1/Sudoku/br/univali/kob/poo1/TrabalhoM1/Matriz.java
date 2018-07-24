/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoM1.Sudoku.br.univali.kob.poo1.TrabalhoM1;

import java.util.Random;

/**
 *
 * @author Leonardo,Jean
 */
public class Matriz {
    private int[][] tabuleiro;
    private int[][] tabuleiroEspelho;

    /**
    * Construtor da Matriz
    * @param dif que é a dificuldade do jogo.
    */
    Matriz(int dif) {
        switch(dif){
            case 1:
                geraTabuleiro(45);
                break;
            case 2:
                geraTabuleiro(49);
                break;
            case 3:
                geraTabuleiro(54);
                break;
        }
        
    }

    /**
     *
     * @return tabuleiro
     */
    public int[][] getTabuleiro(){
        return tabuleiro;
    }
    /**
    *@return  tabuleiroEspelho que é a base para sabermos qual posição 
    * pode ser zerada.
    */
    public int[][] getTabuleiroEspelho(){
        return tabuleiroEspelho;
    }

    /**
     *
     * @param dificuldade
     * Método que a partir de um tabuleiro válido faz o embaralhamento das casas
     * e zera células para se formar um tabuleiro válido para o sudoku.
     */
    public void geraTabuleiro(int dificuldade){
        tabuleiro = new int[][]{{1,2,3,4,5,6,7,8,9},
                                {4,5,6,7,8,9,1,2,3},
                                {7,8,9,1,2,3,4,5,6},
                                {2,3,4,5,6,7,8,9,1},
                                {5,6,7,8,9,1,2,3,4},
                                {8,9,1,2,3,4,5,6,7},
                                {3,4,5,6,7,8,9,1,2},
                                {6,7,8,9,1,2,3,4,5},
                                {9,1,2,3,4,5,6,7,8}};
        embaralhaLinha();
        embaralhaBlocos3x9();
        embaralhaBlocos9x3();
        zeraPosicoes(dificuldade);
        criaEspelho();
        
    }
    /**
    * Método responsável pelo embaralhamento das linhas.
    */
    private void embaralhaLinha(){
        Random sorteio = new Random();
        int i = sorteio.nextInt(2)+1;
        int aux;     
        for (int coluna=0;coluna<9;coluna++){
            aux=tabuleiro[i][coluna];
            tabuleiro[i][coluna]=tabuleiro[0][coluna];
            tabuleiro[0][coluna]=aux;
        }
        for (int coluna=0;coluna<9;coluna++){
            aux=tabuleiro[i+3][coluna];
            tabuleiro[i+3][coluna]=tabuleiro[3][coluna];
            tabuleiro[3][coluna]=aux;
        }
        for (int coluna=0;coluna<9;coluna++){
            aux=tabuleiro[i+6][coluna];
            tabuleiro[i+6][coluna]=tabuleiro[6][coluna];
            tabuleiro[6][coluna]=aux;
        }

    }
    /**
    * Método que embaralha blocos de 3x9 dentro do tabuleiro.
    */
    private void embaralhaBlocos3x9(){
        Random sorteio = new Random();
        int aux;     
        int j = sorteio.nextInt(2)+1;
        for (int linha=0;linha<3;linha++){
            for (int coluna=0;coluna<9;coluna++){
                aux = tabuleiro[(j*3)+linha][coluna];
                tabuleiro[(j*3)+linha][coluna]=tabuleiro[linha][coluna];
                tabuleiro[linha][coluna]=aux;
            }
        }  
    }
    /**
    * Método que embaralha blocos de 9x3 dentro do tabuleiro.
    */
    private void embaralhaBlocos9x3(){
        Random sorteio = new Random();
        int aux;     
        int l = sorteio.nextInt(2)+1;
        for (int coluna=0;coluna<3;coluna++){
            for (int linha=0;linha<9;linha++){
                aux = tabuleiro[linha][(l*3)+coluna];
                tabuleiro[linha][(l*3)+coluna]=tabuleiro[linha][coluna];
                tabuleiro[linha][coluna]=aux;
            }
        }
    }
    /**
    * @param dificuldade
    * Método que zera algumas posições da matriz baseado na dificuldade que
    * ele recebe como parametro.
    */
    private void zeraPosicoes(int dificuldade){
        Random sorteio = new Random();
        int cont = 0;    
        while(cont<dificuldade){
            int i = sorteio.nextInt(9);
            int j = sorteio.nextInt(9);
           if (tabuleiro[i][j]!=0 && testaRegra(i, j)){
                tabuleiro[i][j]=0;
                cont++;   
            }                 
        }     
        
    }
    /**
    * Método que faz uma cópia do tabuleiro já formado, para termos como base 
    * para a validação de algumas entradas.
    */
    private void criaEspelho(){
        tabuleiroEspelho = new int[9][9];
        for (int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                tabuleiroEspelho[i][j]=tabuleiro[i][j];
            }
        }
    }
    /**
    * @param i
    * @param j
    * Método que testa a regra de numero de casas não zeradas em blocos 3x3, para 
    * termos blocos válidos, usado pelo método zeraPosicoes. 
    */
    private boolean testaRegra(int i,int j){
        i=i/3;
        j=j/3;
        i=i*3;
        j=j*3;
        int cont=0;
        for (int row=i;row<i+3;row++){
            for(int col=j;col<j+3;col++){
                if (tabuleiro[row][col]!=0){
                    cont++;
                }
            }
        }
        if (cont>1){
            return true;
        }
        else{
            return false;
        }
    }    
}
