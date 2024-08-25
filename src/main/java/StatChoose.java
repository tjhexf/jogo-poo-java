import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StatChoose extends JPanel {
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
        atributosLabel.setMinimumSize(new Dimension(300,100));
        c.gridx = 1;
        c.gridy = 0;
        c.weighty = 0;
        atributosLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(atributosLabel, c);

        IconBasedButton minusButton = new IconBasedButton("minus.png", Color.BLACK);
        IconBasedButton minusDefButton = new IconBasedButton("minus.png", Color.BLACK);
        IconBasedButton minusSauButton = new IconBasedButton("minus.png", Color.BLACK);
        //minusButton.setHorizontalAlignment(SwingConstants.LEFT);

        IconBasedButton addButton = new IconBasedButton("plus.png", Color.BLACK);
        IconBasedButton addDefButton = new IconBasedButton("plus.png", Color.BLACK);
        IconBasedButton addSauButton = new IconBasedButton("plus.png", Color.BLACK);
       // addButton.setHorizontalAlignment(SwingConstants.RIGHT);

        c.gridx = 0;
        c.gridy = 1;
        add(minusButton, c);

        c.gridx = 0;
        c.gridy = 2;
        add(minusDefButton, c);

        c.gridx = 0;
        c.gridy = 3;
        add(minusSauButton, c);

        PixelFontLabel AtaqueLabel = new PixelFontLabel(
                ("Ataque: 0"),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
        );
        c.gridx = 1;
        c.gridy = 1;
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
        c.gridy = 2 ;
        add(DefesaLabel, c);

        PixelFontLabel SaudeLabel = new PixelFontLabel(
                ("Saude: 0"),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                20
        );
        c.gridx = 1;
        c.gridy = 3 ;
        add(SaudeLabel, c);

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getAtaque() > 0)
                    Game.getPlayer().setAtaque(Game.getPlayer().getAtaque() - 1);
                AtaqueLabel.setText("Ataque: " + Game.getPlayer().getAtaque());
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getAtaque() >= 0)
                    Game.getPlayer().setAtaque(Game.getPlayer().getAtaque() + 1);
                AtaqueLabel.setText("Ataque: " + Game.getPlayer().getAtaque());
            }
        });

        minusDefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getDefesa() > 0)
                    Game.getPlayer().setDefesa(Game.getPlayer().getDefesa() - 1);
                DefesaLabel.setText("Defesa: " + Game.getPlayer().getDefesa());
            }
        });
        addDefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getDefesa() >= 0)
                    Game.getPlayer().setDefesa(Game.getPlayer().getDefesa() + 1);
                DefesaLabel.setText("Defesa: " + Game.getPlayer().getDefesa());
            }
        });

        minusSauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getSaude() > 0)
                    Game.getPlayer().setSaude(Game.getPlayer().getSaude() - 1);
                SaudeLabel.setText("Saúde: " + Game.getPlayer().getSaude());
            }
        });
        addSauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getSaude() >= 0)
                    Game.getPlayer().setSaude(Game.getPlayer().getSaude() + 1);
                SaudeLabel.setText("Saúde: " + Game.getPlayer().getSaude());
            }
        });



        c.gridx = 2;
        c.gridy = 1;
        add(addButton, c);

        c.gridx = 2;
        c.gridy = 2;
        add(addDefButton, c);

        c.gridx = 2;
        c.gridy = 3;
        add(addSauButton, c);

        c.gridx = 1;
        c.gridy = 4;
        IconBasedButton confirmButton = new IconBasedButton("confirmar.png", Color.BLACK);
        confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(confirmButton, c);


    }
}
