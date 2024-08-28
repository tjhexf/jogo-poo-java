package Items;
public class Bolsa {

    private Elixir[] elixir = new Elixir[3]; //O máximo do tabuleiro é 3
    private int capacidade = 3; // A capacidade é o máximo
    private int qtElixir = 0;

    public void adicionarElixir(Elixir elixir){
        this.elixir[qtElixir] = elixir;
        qtElixir++;
    }
    public void removeElixir(){
        this.elixir[qtElixir] = null; //check
        qtElixir--;
    }

    public int getQtElixir(){
        return this.qtElixir;
    }
    public void setQtElixir(){
        this.qtElixir =
    }
}
