package Items;

import Logic.Tabuleiro;

import java.util.Random;
public class Armadilha implements Estrutura {
    private boolean typeFixed; // true é fixa, false é perda aleatória
    public Armadilha(boolean typeFixed){
        this.typeFixed = typeFixed;
    }

    private boolean visibility;

    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    };

    public void decreaseLifePoints(Heroi player){
    int currentLifePoints = player.getPontosDevida();
    if(typeFixed==true){
     player.setPontosDevida(currentLifePoints-1);
        Tabuleiro.setHpLabel("Vida: " + player.getPontosDevida());
    } else{
        Random generator = new Random();
        int valueToDecrease = generator.nextInt((Math.abs(currentLifePoints + 1)));
        player.setPontosDevida(currentLifePoints-valueToDecrease);
        Tabuleiro.setHpLabel("Vida: " + player.getPontosDevida());
    }
    }
}
