package Items;

import Logic.Board;
import Logic.Cell;

public abstract class Heroi{

    private int ataque;
    private int defesa;
    private int health;
    private int pontosDevida;
    private Bolsa bolsa;
    private String name;
    public abstract void habilidade();
    public int getAtaque(){
        return this.ataque;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    public int getDefesa(){
        return this.defesa;
    }
    public void setDefesa(int defesa){
        this.defesa = defesa;
    }

    public int getHealth(){
        return this.health;
    }
    public void setHealth(int saude){
        this.health = health;
    }
    public int getPontosDevida(){
        return this.pontosDevida;
    }
    public void setPontosDevida(int pontosDevida){
        this.pontosDevida = pontosDevida;
    }

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name;}

    public Bolsa getBolsa(){ return this.bolsa;}

    public void setBolsa(Bolsa bolsa){ this.bolsa = bolsa;}
}
