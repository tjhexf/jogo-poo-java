import javax.swing.*;
import java.awt.*;

public class IconBasedButton extends JButton {
    private ImageIcon iconImg;

    public IconBasedButton(String icon, Color backgroundColor) {
        super();
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(backgroundColor);
        ImageIcon iconImg = new ImageIcon(ClassLoader.getSystemResource(icon));
        setIcon(iconImg);
    }
}
