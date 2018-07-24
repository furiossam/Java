/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoM1.Sudoku.br.univali.kob.poo1.TrabalhoM1;

/**
 *
 * @author Leonardo,Jean
 */

public class Menu {
    private Controle jogo;
    /*
    * Interface que pergunta o nome do player.
    */
    public String entradaPlayer(){
        Console a = new Console();
        String nome = a.readLine("Entre com seu nome: \n");
        return nome;
    }
    /*
    * Interface que pergunta a dificuldade da matriz.
    */
    public int entradaDificuldade(){
        int dificuldade = 0;
        do{
             Console a = new Console();
             System.out.println("-----------------------------");
             System.out.println("     BEM VINDO AO SUDOKU     ");
             System.out.println("-----------------------------");
             dificuldade = a.readInint("Escolha a dificuldade do jogo:\n1)Facil\n2)Medio\n3)Dificil\n");
        }while (dificuldade < 1 || dificuldade > 3);
        return dificuldade;
    }
    /*
    * Exibe o tabuleiro.
    */
    public void mostraSudoku(){
        System.out.println("\n***** SUDOKU *****");
        for(int i = 0; i < jogo.getTabuleiro().length; i++){
           System.out.println();
           for(int j = 0; j < jogo.getTabuleiro().length; j++){
               System.out.print(" " + jogo.getTabuleiro()[i][j]);
           }
        } 
    }
    /*
    * Interface que chama método para o preenchimento da célula.
    */
    public void preencheCelula(){
        int i=0,j=0,valor=0;
        Console a = new Console();
        Console b = new Console();
        Console c = new Console();
        do{  
            i = (a.readInint("Escolha a Linha: \n"))-1;
        }while(i<0||i>9);
        do{
             j = (b.readInint("Escolha a Coluna: \n"))-1;
        }while(j<0||j>9);
        while(true){
             valor = (c.readInint("Digite o valor a ser preenchido: "));
             if(jogo.verificarColuna(j, valor)&&jogo.verificarLinha(i, valor)
                     &&jogo.verificarBloco(i, j, valor)&&jogo.verificarPosicao(i, j, valor)&&(jogo.getTabuleiroEspelho()[i][j]==0)){
                 jogo.jogadaValida();
                 jogo.inserirValor(i, j, valor);
                 break;
             }
             else{
                 jogo.jogadaInvalida();
                 System.out.println("JOGADA INVÁLIDA!");
                 break;
             }
            
        }
        
        
    }
    /*
    * Interface que chama método para se zerar a célula.
    */
    public void zeraCelula(){
        int i,j,valor;
        Console a = new Console();
        Console b = new Console();
        
        while(true){
            do{  
                i = (a.readInint("Escolha a Linha: \n"))-1;
            }while(i<0||i>9);
            do{
                 j = (b.readInint("Escolha a Coluna: \n"))-1;
            }while(j<0||j>9);
            if(jogo.getTabuleiroEspelho()[i][j]==0){
                jogo.limpaCelula(i, j);
                jogo.jogadaValida();
                break;
            }
            else{
                jogo.jogadaInvalida();
                System.out.println("JOGADA INVÁLIDA!");
            }
        }
        
    }
    /*
    * Método com o menu que chama os construtores da Matriz com as entradas do usuário,
    * e permite a saida do jogo.
    */
    public void run(){
        int opc=0,opc2=0;
        do{
            jogo = new Controle(entradaDificuldade(), entradaPlayer());
            Console a = new Console();
            do{
                mostraSudoku();
                opc = a.readInint("\nDigite o que deseja fazer: \n1)Prencher celula\n2)Zerar Celula\n3)Verificar tempo de jogo\n"
                       + "4)Mostrar tabuleiro\n5)Desistir\n");
               switch(opc){
                    case 1:
                        preencheCelula();
                        break;
                    case 2:
                        zeraCelula();
                        break;
                    case 3:
                        System.out.println(jogo.calculaTempoDeJogo() + " segundos.");
                        a.WaitForEnter();
                        break;
                    case 4:
                        mostraSudoku();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opcao Invalida...");
                        a.WaitForEnter();        
                }
            }while((!jogo.verificaJogoCompleto())&&(opc!=5)); 
            System.out.println("\nRelatório de Jogo: ");
            System.out.println("------------------");
            System.out.print("Jogadas Válidas: ");
            System.out.println(jogo.getJogadasValidas());
            System.out.print("Jogadas Inválidas: ");
            System.out.println(jogo.getJogadasInvalidas());
            System.out.println("Tempo de jogo: " + jogo.calculaTempoDeJogo() + " Segundos.");
            if(jogo.verificaJogoCompleto())
                System.out.println("Você Completou o jogo");
            else
                System.out.println("Você Não Completou o jogo");
            do{
                opc2 = a.readInint("Deseja jogar novamente: (1)Sim  (2)Não\n");
            }while(opc2<1||opc2>2);
        }while(opc2==1);
                
            
        
    }
    
}
