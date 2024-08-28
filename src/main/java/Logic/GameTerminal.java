package Logic;

import Items.*;

import java.util.Scanner;
import java.util.Scanner;

public class GameTerminal {

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
            board.useTip();
            // board.setCurrCellOfPlayer(move());
            //structureCurrCellOfPlayer = board.getCurrCellOfPlayer().getCellStructure();
            // useOfStructure(structureCurrCellOfPlayer);
            player.setPontosDevida(0);
        }
     return;
    }
}
