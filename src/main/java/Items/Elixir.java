package Items;

import Logic.Tabuleiro;

public class Elixir implements Estrutura{

    private int value;
    private boolean visibility;
    public Elixir(int value){
        this.value = value;
    }

    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    };


    public void increaseLifePoints(Heroi player) {

        player.setPontosDevida(player.getPontosDevida()+this.value);

        Tabuleiro.setElixirLabel("Bolsa: " + player.getBolsa().getQtElixir() + " Elixir");
    }

}
