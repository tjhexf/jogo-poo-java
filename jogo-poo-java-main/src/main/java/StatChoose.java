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

    private int ataque = 0;
    private int defesa = 0;
    private int saude = 0;

    private void run(JPanel layout) throws IOException, FontFormatException {
        setBackground(Color.BLACK);
        GridBagConstraints c = new GridBagConstraints();
        setSize(800,800);

        PixelFontLabel atributosLabel = new PixelFontLabel(
                "Selecione Seus Atributos",
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                22
                );
        c.gridx = 1;
        c.gridy = 0;
        atributosLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(atributosLabel, c);

        IconBasedButton minusButton = new IconBasedButton("minus.png", Color.BLACK);
        //minusButton.setHorizontalAlignment(SwingConstants.LEFT);

        IconBasedButton addButton = new IconBasedButton("plus.png", Color.BLACK);
       // addButton.setHorizontalAlignment(SwingConstants.RIGHT);

        c.gridx = 0;
        c.gridy = 1;
        add(minusButton, c);

        PixelFontLabel AtaqueLabel = new PixelFontLabel(
                ("Ataque: " + Entidade.Jogador.getAtaque()),
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                26
        );
        c.gridx = 1;
        c.gridy = 1;
        add(AtaqueLabel, c);

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Entidade.Jogador.getAtaque() > 0)
                    Entidade.Jogador.setAtaque(Entidade.Jogador.getAtaque() - 1);
                AtaqueLabel.setText("Ataque: " + Entidade.Jogador.getAtaque());
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Entidade.Jogador.getAtaque() >= 0)
                    Entidade.Jogador.setAtaque(Entidade.Jogador.getAtaque() + 1);
                AtaqueLabel.setText("Ataque: " + Entidade.Jogador.getAtaque());
            }
        });


        c.gridx = 2;
        c.gridy = 1;
        add(addButton, c);

        c.gridx = 1;
        c.gridy = 3;
        IconBasedButton confirmButton = new IconBasedButton("confirmar.png", Color.BLACK);
        confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(confirmButton, c);


    }
}
