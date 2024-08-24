import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;



public class CharSel extends JPanel {
    public CharSel(JPanel layout) throws IOException, FontFormatException {
        super(new GridLayout(3,1));
        this.run(layout);
    }
    private static class CharSelectIcons extends JPanel {
        CharSelectIcons(JPanel layout) {
            super(new GridLayout(1, 3));
            //setSize(400, 150);
            setBackground(Color.DARK_GRAY);

            JButton button1 = new IconBasedButton("warriorr.png", Color.DARK_GRAY);
            JButton button2 = new IconBasedButton("paladinn.png", Color.DARK_GRAY);
            JButton button3 = new IconBasedButton("barbariann.png", Color.DARK_GRAY);
            button1.setBorderPainted(false);

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            add(button1, c);
            add(button2, c);
            add(button3, c);

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    Entidade.Jogador.setCharType("Warrior");
                    panel.show(layout, "StatChoose");
                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    Entidade.Jogador.setCharType("Paladin");
                    panel.show(layout, "StatChoose");
                }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    Entidade.Jogador.setCharType("Barbarian");
                    panel.show(layout, "StatChoose");
                }
            });

        }
    }
    public void run(JPanel layout) throws IOException, FontFormatException {

        setBackground(Color.BLACK);

        GridBagConstraints c = new GridBagConstraints();

        setSize(800,800);

        JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("frame.png")));
        c.gridx = 0;
        c.gridy = 0;
        add(picLabel, c);
        c.gridx = 0;
        c.gridy = 1;


        CharSelectIcons icons = new CharSelectIcons(layout);

        add(new CharSelectIcons(layout), c);
    }
}
