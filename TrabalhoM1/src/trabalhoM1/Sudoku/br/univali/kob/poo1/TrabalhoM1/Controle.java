/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoM1.Sudoku.br.univali.kob.poo1.TrabalhoM1;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Leonardo,Jean
 */
public class Controle {
    private static LocalTime inicioDeJogo;
    private Matriz tabuleiro;
    private Player player;
    private static int dificuldade;
    private int jogadasValidas=0;
    private int jogadasInvalidas=0;
    public Controle(int dif,String name){
        inicioDeJogo=LocalTime.now();
        dificuldade=dif;
        tabuleiro = new Matriz(dif);
        player=new Player(name);
        
    
    }
    /**
    * @param i
    * @param valor
    * Verifica se naquela linha já existe o valor.
    * @return (true) Quando não houver nenhum valor igual ao passado na linha. 
    * (false) para quando houver.
    */
    public boolean verificarLinha(int i,int valor){
        int cont=0;
        for (int j=0;j<9;j++){
            if (tabuleiro.getTabuleiro()[i][j]==valor){
                cont++;
            }
        }
        return cont<1;
        
    } 
    /**
    * @param j
    * @param valor
    * Verifica se naquela coluna já existe o valor.
    * @return (true) Quando não houver nenhum valor igual ao passado na coluna. 
    * (false) para quando houver.
    */
    public boolean verificarColuna(int j,int valor){
        int cont=0;
        for (int i=0;i<9;i++){
            if (tabuleiro.getTabuleiro()[i][j]==valor){
                cont++;
            }
        }
        System.out.println(cont);
        return cont<1;
        
    } 
    /**
    * @param i
    * @param j
    * @param valor
    * Verifica se naquele bloco já existe o valor.
    * @return (true) Quando não houver nenhum valor igual ao passado no bloco. 
    * (false) para quando houver.
    */
    public boolean verificarBloco(int i,int j,int valor){
        i=i/3;
        j=j/3;
        i=i*3;
        j=j*3;
        int cont=0;
        for (int row=i;row<i+3;row++){
            for(int col=j;col<j+3;col++){
                if (tabuleiro.getTabuleiro()[i][j]==valor){
                    cont++;
                }
            }
        }
        return cont<1;
    }
    /**
    * @param i
    * @param j
    * @param valor
    * Verifica se naquela posição em outro bloco 3x3 já existe aquele valor.
    * @return (true) Quando não houver nenhum valor igual ao passado na posição. 
    * (false) para quando houver.
    */
    public boolean verificarPosicao(int i,int j,int valor){
        int cont=0;
        for (int it=0;it<3;it++){
            for (int it2=0;it2<2;it2++){
                if (tabuleiro.getTabuleiro()[i][j]==valor){
                    cont++;
                }
                j+=3;
                if (j>8){
                    j-=9;
                }
            }
            if (tabuleiro.getTabuleiro()[i][j]==valor){
                cont++;
            }
            i+=3;
            if (i>8){
                    i-=9;
                }  
        }
        
        return cont<1;
    }
    /** 
    * @return O tempo de jogo em segundos. 
    */
    public long calculaTempoDeJogo(){
        LocalTime agora = LocalTime.now();
        Duration tempo = Duration.between(inicioDeJogo, agora);
        long tempoDeJogo = tempo.getSeconds();
        return tempoDeJogo;
    }
    /**
    * @param i
    * @param j
    * Atribui zero a célula indicada.
    */
    public void limpaCelula(int i,int j){
        tabuleiro.getTabuleiro()[i][j]=0;
    }
    /**
    * @param i
    * @param j
    * @param valor
    * Atribui um valor a célula indicada.
    */
    public void inserirValor(int i,int j,int valor){
        tabuleiro.getTabuleiro()[i][j]=valor;
    }
    /**
    * Incrementa o número de jogadas válidas.
    */
    public void jogadaValida(){
        jogadasValidas++;
    }
    /**
    * Incrementa o número de jogadas inválidas.
    */
    public void jogadaInvalida(){
        jogadasInvalidas++;
    }
    /**
    * @return O número de jogadas válidas.
    */
    public int getJogadasValidas(){
        return jogadasValidas;
    }
    /**
    * @return O número de jogadas inválidas.
    */
    public int getJogadasInvalidas(){
        return jogadasInvalidas;
    }
    /**
    * @return O player
    */
    public Player getPlayer(){
        return player;
    }
    /**
    * @return O tabuleiro 9x9.
    */
    public int[][] getTabuleiro(){
        return tabuleiro.getTabuleiro();
    }
    /**
    * @return O tabuleiro Espelho 9x9.
    */
    public int[][] getTabuleiroEspelho(){
        return tabuleiro.getTabuleiroEspelho();
    }
    /**
    * @return (true) para tabuleiro completo, (false) para incompleto.
    */
    public boolean verificaJogoCompleto(){
        int cont=0;
        for(int i =0;i<9;i++){
            for(int j = 0;j<9;j++){
                if (tabuleiro.getTabuleiro()[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}
