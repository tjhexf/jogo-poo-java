import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StatChoose extends JPanel {
    public StatChoose(JPanel layout) throws IOException, FontFormatException {
        super(new GridLayout(5, 4));
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
                "Selecione Seu Atributo",
                SwingConstants.CENTER,
                Font.BOLD,
                Color.white,
                22
                );


    }
}
