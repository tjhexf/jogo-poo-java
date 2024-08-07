import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game extends JFrame {
    public Game() throws IOException, FontFormatException {
        super("Java Dungeon");
        JPanel cardPanel = new JPanel(new CardLayout());
        setSize(800, 800);
        add(cardPanel);

        CharSel charSel = new CharSel();
        cardPanel.add(charSel, "Character Selection");

        charSel.run();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
