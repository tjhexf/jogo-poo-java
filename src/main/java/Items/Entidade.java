package Items;

public abstract class Entidade {
    private int Ataque = 0;
    private int Defesa = 0;
    private int Saude = 0;

    public int getAtaque() {
        return Ataque;
    }

    public void setAtaque(int ataque) {
        Ataque = ataque;
    }

    public int getDefesa() {
        return Defesa;
    }

    public void setDefesa(int defesa) {
        Defesa = defesa;
    }

    public int getSaude() {
        return Saude;
    }

    public void setSaude(int saude) {
        Saude = saude;
    }
}

