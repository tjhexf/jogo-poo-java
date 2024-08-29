package Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StatChoose extends JPanel {

    private int PointsLeft = 9;

    public StatChoose(JPanel layout) throws IOException, FontFormatException {
        super(new GridBagLayout());
        run(layout);
    }

    private void run(JPanel layout) throws IOException, FontFormatException {
        setBackground(Color.BLACK);
        GridBagConstraints c = new GridBagConstraints();
        setSize(800,800);

        PixelFontLabel atributosLabel = new PixelFontLabel(
                "Selecione Seus Atributos",
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
                );
        PixelFontLabel pointsLabel = new PixelFontLabel(
                ("Pontos Restantes:" + PointsLeft),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
        );
        atributosLabel.setMinimumSize(new Dimension(300,100));
        pointsLabel.setMinimumSize(new Dimension(300,100));
        c.gridx = 1;
        c.gridy = 0;
        c.weighty = 0;
        atributosLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(atributosLabel, c);
        c.gridy = 1;
        add(pointsLabel, c);

        IconBasedButton minusButton = new IconBasedButton("minus.png", Color.BLACK);
        IconBasedButton minusDefButton = new IconBasedButton("minus.png", Color.BLACK);
        IconBasedButton minusSauButton = new IconBasedButton("minus.png", Color.BLACK);
        //minusButton.setHorizontalAlignment(SwingConstants.LEFT);

        IconBasedButton addButton = new IconBasedButton("plus.png", Color.BLACK);
        IconBasedButton addDefButton = new IconBasedButton("plus.png", Color.BLACK);
        IconBasedButton addSauButton = new IconBasedButton("plus.png", Color.BLACK);
       // addButton.setHorizontalAlignment(SwingConstants.RIGHT);

        c.gridx = 0;
        c.gridy = 2;
        add(minusButton, c);

        c.gridx = 0;
        c.gridy = 3;
        add(minusDefButton, c);

        c.gridx = 0;
        c.gridy = 4;
        add(minusSauButton, c);

        PixelFontLabel AtaqueLabel = new PixelFontLabel(
                ("Ataque: 0"),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
        );
        c.gridx = 1;
        c.gridy = 2;
        c.weighty = 1;
        add(AtaqueLabel, c);

        PixelFontLabel DefesaLabel = new PixelFontLabel(
                ("Defesa: 0"),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
        );
        c.gridx = 1;
        c.gridy = 3 ;
        add(DefesaLabel, c);

        PixelFontLabel SaudeLabel = new PixelFontLabel(
                ("Saude: 0"),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
        );
        c.gridx = 1;
        c.gridy = 4 ;
        add(SaudeLabel, c);

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getAtaque() > 0) {
                    Game.getPlayer().setAtaque(Game.getPlayer().getAtaque() - 1);
                    PointsLeft += 1;
                    pointsLabel.setText("Pontos Restantes: " + PointsLeft);
                }
                AtaqueLabel.setText("Ataque: " + Game.getPlayer().getAtaque());
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getAtaque() >= 0 && PointsLeft > 0) {
                    Game.getPlayer().setAtaque(Game.getPlayer().getAtaque() + 1);
                    PointsLeft -= 1;
                    pointsLabel.setText("Pontos Restantes: " + PointsLeft);
                }
                AtaqueLabel.setText("Ataque: " + Game.getPlayer().getAtaque());
            }
        });

        minusDefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getDefesa() > 0) {
                    Game.getPlayer().setDefesa(Game.getPlayer().getDefesa() - 1);
                    PointsLeft += 1;
                    pointsLabel.setText("Pontos Restantes: " + PointsLeft);
                }
                DefesaLabel.setText("Defesa: " + Game.getPlayer().getDefesa());
            }
        });
        addDefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getDefesa() >= 0 && PointsLeft > 0) {
                    Game.getPlayer().setDefesa(Game.getPlayer().getDefesa() + 1);
                    PointsLeft -= 1;
                    pointsLabel.setText("Pontos Restantes: " + PointsLeft);
                }
                DefesaLabel.setText("Defesa: " + Game.getPlayer().getDefesa());
            }
        });

        minusSauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getHealth() > 0) {
                    Game.getPlayer().setHealth(Game.getPlayer().getHealth() - 1);
                    PointsLeft += 1;
                    pointsLabel.setText("Pontos Restantes: " + PointsLeft);
                }
                SaudeLabel.setText("Saúde: " + Game.getPlayer().getHealth());
            }
        });
        addSauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getHealth() >= 0 && PointsLeft > 0) {
                    Game.getPlayer().setHealth(Game.getPlayer().getHealth() + 1);
                    PointsLeft -= 1;
                    pointsLabel.setText("Pontos Restantes: " + PointsLeft);
                }
                SaudeLabel.setText("Saúde: " + Game.getPlayer().getHealth());
            }
        });



        c.gridx = 2;
        c.gridy = 2;
        add(addButton, c);

        c.gridx = 2;
        c.gridy = 3;
        add(addDefButton, c);

        c.gridx = 2;
        c.gridy = 4;
        add(addSauButton, c);

        c.gridx = 1;
        c.gridy = 5;
        IconBasedButton confirmButton = new IconBasedButton("confirmar.png", Color.BLACK);
        confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(confirmButton, c);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout panel = (CardLayout) layout.getLayout();
                Tabuleiro.Getboard().setPlayer(Game.getPlayer());
                Game.getPlayer().setPontosDevida(10 + Game.getPlayer().getHealth());
                panel.show(layout, "Tabuleiro");
            }
        });


    }
}
