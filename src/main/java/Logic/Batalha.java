package Logic;

import Items.Monster;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.max;

public class Batalha extends JPanel {
    int monsterhp;
    int guerBonus;
    boolean especialUsed;
    JLabel label;
    JLabel monstroLabel;
    public Batalha() {
        setLayout(new GridBagLayout());
    }
    public void run(Monster monstro) {
        guerBonus = 0;
        monsterhp = 10 + monstro.getHealthValue();
        especialUsed = false;

        label = new JLabel("Hp: " + Game.getPlayer().getPontosDevida());
        add(label);

        monstroLabel = new JLabel("Hp Monstro: " + monsterhp);

        add(monstroLabel);

        JButton ataqueBut = new JButton("Atacar");
        add(ataqueBut);
        JButton EspecialBut = new JButton("Especial");
        add(EspecialBut);

        EspecialBut.addActionListener(e -> {
            if (especialUsed == false) {
                if (Objects.equals(Game.getPlayer().habilidade(), "Habilidade Paladino")) {
                    Game.getPlayer().setPontosDevida(Game.getPlayer().getPontosDevida() + (Game.getPlayer().getPontosDevida() / 2));
                    label.setText("Hp: " + Game.getPlayer().getPontosDevida());
                    especialUsed = true;
                }
                if (Objects.equals(Game.getPlayer().habilidade(), "Habilidade Guerreiro")) {
                    guerBonus = 2;
                    especialUsed = true;
                }
                if (Objects.equals(Game.getPlayer().habilidade(), "Habilidade Barbaro")) {
                    monsterhp = monsterhp - 5;
                    monstroLabel.setText("Hp Monstro: " + monsterhp);
                    especialUsed = true;
                }
                else System.out.println(Game.getPlayer().habilidade());
            }
        });
        ataqueBut.addActionListener(e -> {
            Random rand = new Random();
            int playerDmg = rand.nextInt(5) + Game.getPlayer().getAtaque();
            int monsterDef = rand.nextInt(5) + monstro.getDefenseValue();
            int playerDef = rand.nextInt(3) + Game.getPlayer().getDefesa();
            int monsterAttack = rand.nextInt(5) + monstro.getAttackValue();
            if (playerDmg > monsterDef) {
                monsterhp = monsterhp - playerDmg - monsterDef;
                monstroLabel.setText("Hp Monstro: " + monsterhp);
            }
            else {
                Game.getPlayer().setPontosDevida(Game.getPlayer().getPontosDevida() - max(0,(monsterAttack - playerDef - guerBonus)));
                label.setText("Hp: " + Game.getPlayer().getPontosDevida());
            }
            if (Game.getPlayer().getPontosDevida() <= 0 || monsterhp <= 0) {
                CardLayout test = (CardLayout) Game.cardLayout.getLayout();
                test.show(Game.cardLayout, "Tabuleiro");
                Game.cardLayout.remove(this);
            }
        });

        setVisible(true);
    }
}
