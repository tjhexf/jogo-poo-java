package Logic;

import Items.Heroi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Game extends JFrame {
    public static JPanel cardLayout = new JPanel(new CardLayout());
    public static boolean isDebug() {
        return debug;
    }

    private static boolean debug = false;
    public static boolean isGamewin() {
        return gamewin;
    }

    public void setGamewin(boolean gamewin) {
        this.gamewin = gamewin;
    }

    private static boolean gamewin = false;
    private static Heroi Player;

    public static void setPlayer(Heroi player) {
        Player = player;
    }

    public static Heroi getPlayer() {
        return Player;
    }

    public class WelcomeScreen extends JPanel {
        public WelcomeScreen(JPanel layout) {
            super(new GridLayout(3,1));
            setBackground(Color.BLACK);
            run(layout);
        }
        private void run(JPanel layout) {
            IconBasedButton jogarBut = new IconBasedButton("jogar.png", Color.BLACK);
            add(jogarBut);
            IconBasedButton DebugBut = new IconBasedButton("debug.png", Color.BLACK);
            add(DebugBut);
            IconBasedButton SairBut = new IconBasedButton("sair.png", Color.BLACK);
            add(SairBut);

            DebugBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    debug = true;
                    panel.show(layout, "Tabuleiro");
                }
            });

            jogarBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout panel = (CardLayout) layout.getLayout();
                    debug = false;
                    panel.show(layout, "Logic.CharSel");
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
        Run();
    }
    private void Run() throws IOException, FontFormatException {


        WelcomeScreen welcomeScreen = new WelcomeScreen(cardLayout);


        setSize(800, 800);


        CharSel charSel = new CharSel(cardLayout);

        Tabuleiro tabuleiro = new Tabuleiro(cardLayout);

        StatChoose statChoose = new StatChoose(cardLayout);
        cardLayout.add(welcomeScreen, "Welcome");
        cardLayout.add(charSel, "Logic.CharSel");
        cardLayout.add(statChoose, "Logic.StatChoose");
        cardLayout.add(tabuleiro, "Tabuleiro");
        End end = new End(cardLayout);
        cardLayout.add(end, "End");

        add(cardLayout);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
