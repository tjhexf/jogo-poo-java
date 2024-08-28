package Logic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class PixelFontLabel extends JLabel {
    public PixelFontLabel(String Text,
                          int HorizontalAlignment,
                          int FontType,
                          Color FontColor,
                          int size
    ) throws IOException, FontFormatException {
        super(Text, HorizontalAlignment);
        Font gameFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("gameFont.ttf")));
        setFont(gameFont.deriveFont(FontType, size));
        setForeground(FontColor);
    }
}
