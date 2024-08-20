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

class Heroi extends Entidade{

    public Heroi() {
        setAtaque(0);
    }


}

class Guerreiro extends Heroi {

}
class Paladino extends Heroi {

}
class Barbaro extends Heroi {

}