import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game extends JFrame {
    public Game() throws IOException, FontFormatException {
        super("Java Dungeon");
        setSize(800, 800);
        CharSel charSel = new CharSel();
        add(charSel);
        charSel.run();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
