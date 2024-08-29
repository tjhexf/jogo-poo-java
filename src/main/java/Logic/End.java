package Logic;

import javax.swing.*;
import java.awt.*;

public class End extends JPanel {
    public End(JPanel layout) {
        super(new GridBagLayout());

        JLabel label = new JLabel("Fim de Jogo!");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel labelwin = new JLabel("Você Perdeu!");
        if (Game.isGamewin()) labelwin.setText("Você Venceu!");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(label, gbc);
        gbc.gridy = 1;
        add(labelwin, gbc);

        JButton resetBotao = new JButton("Menu");
        gbc.gridy = 2;
        add(resetBotao, gbc);

        resetBotao.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) layout.getLayout();
            cardLayout.show(layout, "Welcome");
        });


    }
}
