import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class CharSel extends JFrame {
    public CharSel() throws IOException, FontFormatException {

        super("Dungeon Java");

        Font gameFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResourceAsStream("gameFont.ttf")));

        setSize(800,800);

        JPanel pane = new JPanel(new GridLayout(3,1));

        pane.setBackground(Color.BLACK);

        add(pane);

        GridBagConstraints c = new GridBagConstraints();

        //pane.setSize(800,800);

        JLabel label = new JLabel("Selecione seu Herói", SwingConstants.CENTER);

        label.setFont(gameFont.deriveFont(Font.BOLD, 30));
        label.setForeground(Color.WHITE);

        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;

        pane.add(label, c);

        c.gridx = 0;
        c.gridy = 1;

        pane.add(new CharSelectIcons(), c);
        setVisible(true);
    }
}
