package Items;

import Logic.Tabuleiro;

public class Bolsa {

    private Elixir[] elixir = new Elixir[3]; //O máximo do tabuleiro é 3
    private int capacidade = 3; // A capacidade é o máximo
    private int qtElixir;

   public Bolsa () {
      this.capacidade = 3;
      this.qtElixir = 0;
    }
    public void adicionarElixir(Elixir elixir){
if(qtElixir<capacidade) {
    this.elixir[qtElixir] = elixir;
    (this.qtElixir)++;
    Tabuleiro.setElixirLabel("Bolsa: " + qtElixir + " Elixir");
}
    }

    public void removeElixir(){
      if (qtElixir>0) {
          this.elixir[qtElixir] = null; //check
          (this.qtElixir)--;
          Tabuleiro.setElixirLabel("Bolsa: " + qtElixir + " Elixir");
      }
    }

    public int getQtElixir(){
        return this.qtElixir;
    }

}
