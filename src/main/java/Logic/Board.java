package Logic;
import Items.Heroi;
import Items.Monster;
import Items.Armadilha;
import Items.Elixir;
import Items.Estrutura;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private static Heroi player;
    private Cell[][] boardCells;
    private Cell currCellOfPlayer = new Cell();
    private Cell cellChefao = new Cell();
    private int qtTips = 3;

    //12 armadilhas, 3 elixires e 3 monstros (fora o chefão, posicionado separadamente pois é sempre visivel)
    private int qtTrapsToPosition = 12;
    private int qtElixirsToPosition = 3;
    private int qtMonstersToPosition = 3;


    public Board() {
        this.boardCells = new Cell[5][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                boardCells[i][j] = new Cell(i, j, null);
                // Inicializa cada célula com posição e sem estrutura
            }
        }
    }

    public void createCells() {
        Random generator = new Random();

        int heroStartColumn = generator.nextInt(10);
        Cell heroStartCell = new Cell(0, heroStartColumn);
        heroStartCell.getCellStructure().setVisibility(true);
        setCurrCellOfPlayer(heroStartCell);

        Estrutura boss = new Monster();
        int bossColumn = generator.nextInt(10);
        Cell chefaoStartCell = new Cell(4, bossColumn);
        setBossCell(chefaoStartCell);
        chefaoStartCell.getCellStructure().setVisibility(true);
        this.boardCells[4][bossColumn].setCellStructure(boss);

        positionTraps(this.qtTrapsToPosition, generator, currCellOfPlayer.getColumn());
        positionElixirs(this.qtElixirsToPosition, generator, currCellOfPlayer.getColumn());
        positionMonsters(this.qtMonstersToPosition, currCellOfPlayer.getColumn());
    }


    public void positionTraps(int qtTrapsToPosition, Random generator, int heroPosition) {
        int randomLine;
        int randomColumn;
        Armadilha trap;
        while (qtTrapsToPosition > 0) {
            randomLine = generator.nextInt(5);
            randomColumn = generator.nextInt(10);
//caso não haja já algo na célula, e não seja a posição em que o herói iniciou
            if ((boardCells[randomLine][randomColumn]).getCellStructure() == null &&
                    (randomLine != 0 || randomColumn != heroPosition)) {
                trap = Cell.createRandomTrap();
                boardCells[randomLine][randomColumn].setCellStructure(trap);
                qtTrapsToPosition--;
            }
        }
    }

    public void positionElixirs(int qtElixirsToPosition, Random generator, int heroPosition) {
        int randomLine;
        int randomColumn;
        Elixir elixir;
        while (qtElixirsToPosition > 0) {
            randomLine = generator.nextInt(5);
            randomColumn = generator.nextInt(10);
//Caso não haja já algo na célula, e não seja a posição em que o herói iniciou
            if ((boardCells[randomLine][randomColumn]).getCellStructure() == null &&
                    (randomLine != 0 || randomColumn != heroPosition)) {
                elixir = new Elixir(player.getPontosDevida() - 1);
                boardCells[randomLine][randomColumn].setCellStructure(elixir);
                qtElixirsToPosition--;
            }
        }
    }

    public void positionMonsters(int qtMonstersToPosition, int heroPosition) {
        int currentLine = 0;
        int randomColumn;
        Random generator = new Random();
        Monster monster;

        while (qtMonstersToPosition > 0) {
            randomColumn = generator.nextInt(10);
//Caso não haja já algo na célula, e não seja a posição em que o herói iniciou. No caso dos monstros, há um por linha
            if ((boardCells[currentLine][randomColumn]).getCellStructure() == null &&
                    (currentLine != 0 || randomColumn != heroPosition)) {
                monster = Cell.createRandomMonster(player);
                boardCells[currentLine][randomColumn].setCellStructure(monster);
                currentLine++;
                qtMonstersToPosition--;
            }
        }
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

    public void setPlayer(Heroi heroi) {
        player = heroi;
    }
    public Cell getCurrCellOfPlayer() {
        return this.currCellOfPlayer;
    }

    public void setCurrCellOfPlayer(Cell currCellOfPlayer) {
        this.currCellOfPlayer = currCellOfPlayer;
    }

    public Cell getCellChefao() { //Está sempre visivel
        return this.cellChefao;
    }

    public void setBossCell(Cell cellChefao) { //Está sempre visivel
        this.cellChefao = cellChefao;
    }
    /*public int getQtTips(){ return this.qtTips;}
    public void setQtDicas(int qtDicas){ this.qtDicas = qtDicas;}
     */

}