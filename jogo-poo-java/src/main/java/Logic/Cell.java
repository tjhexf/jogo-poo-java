package Logic;

import Items.*;

import java.util.Random;
public class Cell {
    private int line;
    private int column;
    private Estrutura cellStructure;
    public Cell(){
    };
    public Cell(int line, int column){
        this.line = line;
        this.column = column;
    }
    public Cell(int line, int column, Estrutura cellStructure){
        this.line = line;
        this.column = column;
        this.cellStructure = cellStructure;
    }

    public static Armadilha createRandomTrap() {
        Random generator = new Random();
        boolean typeOfTrap;
        Armadilha trap;
        typeOfTrap = (generator.nextInt(2) > 0.5);
        trap = new Armadilha(typeOfTrap);
        return trap;
    }
    public static Monster createRandomMonster(Heroi player){
        Random generator = new Random();

        String[] possibleRewardAtributtes = {"attack", "defense", "health"};
        int rewardValue;
        int randomRewardAtributte;
        int randomMonsterAttackValue = generator.nextInt((player.getAtaque() - Math.round(player.getAtaque()/3))+1);;
        int randomMonsterDefenseValue = generator.nextInt(player.getDefesa() - Math.round(player.getDefesa()/3)+1);;
        int randomMonsterHealthValue = generator.nextInt(player.getHealth() - Math.round(player.getHealth()/3)+1);;
        Monster monster = null;

        //O valor de ataque/defesa/pontos de vida do monstro não chefão é 2/3 dos atributos do player

        randomRewardAtributte = generator.nextInt(3);


        switch (possibleRewardAtributtes[randomRewardAtributte]){
            case "attack":
                //O valor do reward de ataque para o jogador é metade do ataque do monstro + 1
                rewardValue = generator.nextInt(Math.round(randomMonsterAttackValue/2)+1);
                monster = new Monster(randomMonsterAttackValue, randomMonsterDefenseValue, randomMonsterHealthValue, "attack", rewardValue);
                break;
            case "defense":
                //O valor do reward de defesa para o jogador é metade da defesa do monstro + 1
                rewardValue = generator.nextInt(Math.round(randomMonsterDefenseValue/2)+1);
                monster = new Monster(randomMonsterAttackValue, randomMonsterDefenseValue, randomMonsterHealthValue, "defense", rewardValue);
                break;
            case "health":
                //O valor do reward de defesa para o jogador é metade da defesa do monstro + 1
                rewardValue = generator.nextInt(Math.round(randomMonsterHealthValue/2)+1);
                monster = new Monster(randomMonsterAttackValue, randomMonsterDefenseValue, randomMonsterHealthValue, "health", rewardValue);
                break;
        }

        return monster;
    }
    /*
   public static Elixir createRandomElixir(Heroi player){
        Random generator = new Random();
        int elixirValue;
        elixirValue = generator.nextInt(player.getPontosDevida() - 1);
        Elixir elixir = new Elixir(elixirValue);
        return elixir;
    }

     */
    public int getLine(){
        return this.line;
    }
    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn(){
        return this.column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public Estrutura getCellStructure(){
        return this.cellStructure;
    }
    public void setCellStructure(Estrutura cellStructure) {
        this.cellStructure = cellStructure;
    }


}
