package Logic;

import Items.*;

import java.util.Scanner;
import java.util.Scanner;

public class GameTerminal {
    private static Heroi player;
    private int qtTips = 3;
    public void setPlayer(Heroi heroi) {
        player = heroi;
    }

    public void useTip(){
        if(qtTips>0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Para usar dica, digite 1, para não usar, digite 0");
            int tip = sc.nextInt();
            if (tip == 1) {
                System.out.print("Digite a linha da dica:");
                int lineTip = sc.nextInt();
                System.out.print("Digite a coluna da dica:");
                int columnTip = sc.nextInt();
                Cell cellTip = new Cell(lineTip, columnTip);
                if (cellTip.getCellStructure() instanceof Armadilha) {
                    System.out.println("A célula informada tem uma armadilha");
                }
                qtTips--;
            }
        }
    }
    public Cell move(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma linha para ir:");
        int linha = sc.nextInt();
        System.out.print("Digite uma coluna para ir:");
        int coluna = sc.nextInt();
        Cell newCell = new Cell(linha, coluna);
        sc.close(); //Encerra o programa
        return newCell;
    }

    public void battle(Monster monster){
     int menu=0;
     int round =0;
     int lifePointsMonstro = monster.getHealthValue();
     int lifePointsPlayer = player.getPontosDevida();
     int playerAttack = player.getAtaque();
     int monsterAttack = monster.getAttackValue();
    while(lifePointsMonstro>0 && lifePointsPlayer>0){
        System.out.println("\n1-Atacar\n2-Habilidade\n3-Elixir\n");
        Scanner sc = new Scanner(System.in);
        menu = sc.nextInt();
        switch (menu){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        round++;
    }

    }
    public void useOfStructure(Estrutura structure) {
        // if(structure instanceof Elixir){
            //System.out.println("Você encontrou um elixir!");
            // player.getBolsa().adicionarElixir((Elixir) structure);
            //}
        //else if(structure instanceof Armadilha){
            //System.out.println("Você encontrou uma armadilha!");
            // ((Armadilha) structure).decreaseLifePoints(player);
            //}
        //else if(structure instanceof Monster){
        //   System.out.println("Você encontrou um monstro!");
            //  battle((Monster) structure);
        // }
    }
    public void run(){
    Barbaro barbaro = new Barbaro();
        setPlayer(barbaro);
        player.setDefesa(12);
        player.setAtaque(5);
        player.setHealth(6);
        player.setPontosDevida(14);
        player.setName("Jogador");
        Board board = new Board();
        board.createCells(player);
        Estrutura structureCurrCellOfPlayer;
        while(player.getPontosDevida()>0){
            useTip();
            // board.setCurrCellOfPlayer(move());
            //structureCurrCellOfPlayer = board.getCurrCellOfPlayer().getCellStructure();
            // useOfStructure(structureCurrCellOfPlayer);
            player.setPontosDevida(0);
        }
     return;
    }
}
