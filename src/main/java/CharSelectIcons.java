import javax.swing.*;
import java.awt.*;

public class CharSelectIcons extends JPanel {
    CharSelectIcons() {
        super(new GridLayout(1, 3));
        setSize(400, 150);
        setBackground(Color.DARK_GRAY);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("warriorr.png"));

        JButton button1 = new JButton(icon1);
        button1.setFocusPainted(false);
        button1.setContentAreaFilled(false);
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
