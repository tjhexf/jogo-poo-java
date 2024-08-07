import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;



public class CharSel extends JPanel {
    public CharSel() throws IOException, FontFormatException {
        super(new GridLayout(3,1));
        this.run();
    }
    private static class CharSelectIcons extends JPanel {
        CharSelectIcons() {
            super(new GridLayout(1, 3));
            //setSize(400, 150);
            setBackground(Color.DARK_GRAY);

            JButton button1 = new IconBasedButton("warriorr.png", Color.DARK_GRAY);
            JButton button2 = new JButton("2");
            button1.setBorderPainted(false);
            JButton button3 = new JButton("3");
            button1.setBorderPainted(false);

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            add(button1, c);
            add(button2, c);
            add(button3, c);

        }
    }
    public void run() throws IOException, FontFormatException {

        setBackground(Color.BLACK);

        GridBagConstraints c = new GridBagConstraints();

        setSize(800,800);

        JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("frame.png")));
        c.gridx = 0;
        c.gridy = 0;
        add(picLabel, c);
        c.gridx = 0;
        c.gridy = 1;


        CharSelectIcons icons = new CharSelectIcons();

        add(new CharSelectIcons(), c);
    }
}
