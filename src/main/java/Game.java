import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Game extends JFrame {
    //game é uma gameWindow(JFrame), ou seja, precisa de um gamePanel(JPanel) para funcionar direito, tipo moldura,
    //tu coloca uma foto (JPanel) dentro da moldura (JFrame).
    public class WelcomeScreen extends JPanel {
        public WelcomeScreen(JPanel layout) {   //Mesma coisa do comentário acima, so que aplicada
            super(new GridLayout(3,1));     //oq o super faz? entendi que isso seta a quantidade de botões
            run(layout);    //oq o run faz?
        }
        private void run(JPanel layout) {
            IconBasedButton jogarBut = new IconBasedButton("jogar.png", Color.BLACK);
            add(jogarBut);
            IconBasedButton DebugBut = new IconBasedButton("debug.png", Color.BLACK);
            add(DebugBut);
            IconBasedButton SairBut = new IconBasedButton("sair.png", Color.BLACK);
            add(SairBut);

            jogarBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    panel.show(layout, "CharSel");
                }
            });
            SairBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }

    }

    public Game() throws IOException, FontFormatException {
        super("Java Dungeon");

        JPanel cardLayout = new JPanel(new CardLayout());

        WelcomeScreen welcomeScreen = new WelcomeScreen(cardLayout);

        setSize(800, 800);
        setLocationRelativeTo(null);    //põe no meio da tela

        CharSel charSel = new CharSel(cardLayout);
        StatChoose statChoose = new StatChoose(cardLayout);

        cardLayout.add(welcomeScreen, "Welcome");
        cardLayout.add(charSel, "CharSel");
        cardLayout.add(statChoose, "StatChoose");

        add(cardLayout);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
