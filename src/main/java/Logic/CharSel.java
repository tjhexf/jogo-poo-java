package Logic;

import Items.Barbaro;
import Items.Guerreiro;
import Items.Heroi;
import Items.Paladino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CharSel extends JPanel {
    private Heroi hero;
    public CharSel(JPanel layout) throws IOException, FontFormatException {
        super(new GridLayout(3,1));
        this.run(layout);
    }
    public Heroi getHero() {
        return hero;
    }
    private class CharSelectIcons extends JPanel {
        JButton button1 = new IconBasedButton("warriorr.png", Color.DARK_GRAY);
        JButton button2 = new IconBasedButton("paladinn.png", Color.DARK_GRAY);
        JButton button3 = new IconBasedButton("aaaa/barbariann.png", Color.DARK_GRAY);

        CharSelectIcons(JPanel layout) {
            super(new GridLayout(1, 3));
            //setSize(400, 150);
            setBackground(Color.DARK_GRAY);


            button1.setBorderPainted(false);

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            add(button1, c);
            add(button2, c);
            add(button3, c);
            run(layout);
        }
        private void run(JPanel layout) {
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    hero = new Guerreiro();
                    Game.setPlayer(hero);
                    Tabuleiro.getBoard().setPlayer(hero);
                    panel.show(layout, "Logic.StatChoose");
                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    hero = new Paladino();
                    Game.setPlayer(hero);
                    Tabuleiro.getBoard().setPlayer(hero);
                    panel.show(layout, "Logic.StatChoose");
                }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    hero = new Barbaro();
                    Game.setPlayer(hero);
                    Tabuleiro.getBoard().setPlayer(hero);
                    panel.show(layout, "Logic.StatChoose");
                }
            });
        }
    }
    public void run(JPanel layout) throws IOException, FontFormatException {

        setBackground(Color.BLACK);

        GridBagConstraints c = new GridBagConstraints();

        setSize(800,800);

        JLabel picLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("frame.png")));
        c.gridx = 0;
        c.gridy = 0;
        add(picLabel, c);
        c.gridx = 0;
        c.gridy = 1;


        CharSelectIcons icons = new CharSelectIcons(layout);

        add(new CharSelectIcons(layout), c);
    }
}
