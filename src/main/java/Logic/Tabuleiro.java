package Logic;

import Items.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Tabuleiro extends JPanel {
    JPanel layout;
    private JButton[][] botao = new JButton[LINHAS][COLUNAS];

    private static JLabel elixirLabel;
    private static JLabel hpLabel;
    public static void setHpLabel(String text)  {
        hpLabel.setText(text);
    }

    public static void setElixirLabel(String text) {
        elixirLabel.setText(text);
    }
    public static Board getBoard() {
        return board;
    }

    //celula = cel[];
    private static Board board;
    public static Board Getboard() {
        return board;
    }
    //celulaAtual = celA;
    private static final int LINHAS = 5;
    private static final int COLUNAS = 10;
    private boolean tipMode = false;

    private boolean moveMode = false;

    public Tabuleiro(JPanel layout) throws IOException, FontFormatException {

        super(new GridBagLayout());
        this.layout = layout;
        GridBagConstraints c = new GridBagConstraints();
        JPanel tela = new JPanel();
        tela.setLayout(new GridBagLayout());
        setBackground(new Color(77, 70, 66));
        tela.setBackground(new Color(77, 70, 66));



        JLabel rotulo = new JLabel("Mensagens: ", SwingConstants.CENTER);
        rotulo.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton Dica = new JButton("  Dica  ");
        JButton Move = new JButton("Mover");
        JButton UsarElixir = new JButton("Usar Elixir");
        JButton debug = new JButton("Mostrar Mapa");
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        tela.add(Dica, c);
        c.gridy = 1;
        tela.add(Move, c);

        c.gridy = 2;
        tela.add(debug, c);

        c.gridy = 6;
        tela.add(UsarElixir);

        //tela.add(rotulo, c);
        tela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        board = new Board();
        Barbaro defaubarb = new Barbaro();
        board.setPlayer(defaubarb);

        elixirLabel = new JLabel(("Bolsa: " + board.getPlayer().getBolsa().getQtElixir() + "Elixir"));
        elixirLabel.setForeground(Color.WHITE);
        c.gridy = 3;
        tela.add(elixirLabel, c);

        hpLabel = new JLabel(("Vida: " + board.getPlayer().getPontosDevida()));
        c.gridy = 4;
        tela.add(hpLabel, c);




        board.createCells();

        JPanel gridPainel = new JPanel();
        gridPainel.setLayout(new GridBagLayout());

        UsarElixir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.getPlayer().getBolsa().getQtElixir() > 0) {
                    Game.getPlayer().setPontosDevida(Game.getPlayer().getPontosDevida() + 5);
                    Game.getPlayer().getBolsa().removeElixir();
                    elixirLabel.setText("Vida: " + Game.getPlayer().getPontosDevida());
                }
            }
        });

        debug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Game.isDebug()) setButtonIcons(board, botao);
            }
        });

        Move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!moveMode) {
                    Move.setBackground(new Color(90, 91, 94));
                    moveMode = true;
                }
                else {
                    Move.setBackground(Color.WHITE);
                    moveMode = false;
                }
            }
        });



        gridPainel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        for(int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                botao[i][j] = new JButton();
                c.gridy = i;
                c.weighty = 1;
                c.weightx = 1;
                botao[i][j].setPreferredSize(new Dimension(20, 40));
                botao[i][j].setBackground(new Color(245, 170, 113));
                c.fill = GridBagConstraints.BOTH;
                c.gridx = j;
                gridPainel.add(botao[i][j], c);

                int finalI = i;
                int finalJ = j;
                int finalI1 = i;
                botao[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton botaoMouse = (JButton) e.getSource();
                        if (moveMode) {
                            movePlayer(board, board.boardCells[finalI][finalJ], botao);
                        }
                        //movePlayer(board.boardCells[finalI][finalJ],);
                        if(tipMode){
                            //board.useTip();
                            tipMode = false;    //desativa dps de usar
                        }
                    }
                });
            }
        }
        setButtonIcons(board, botao);
        c.weighty = 0.5;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;

        add(gridPainel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        add(tela, c);
        setVisible(true);
    }

    private void movePlayer(Board board, Cell cellToDisplayPlayer, JButton[][] arr) {
        Cell oldCel = board.getCurrCellOfPlayer();
        int i = oldCel.getLine();
        int j = oldCel.getColumn();

        setHpLabel(("Vida: " + board.getPlayer().getPontosDevida()));

        arr[i][j].setIcon(null);

        board.setCurrCellOfPlayer(cellToDisplayPlayer);

        board.useOfStructure(board.getCurrCellOfPlayer());
        //if(board.getCurrCellOfPlayer() instanceof Armadilha){

        //}
        arr[cellToDisplayPlayer.getLine()][cellToDisplayPlayer.getColumn()].setIcon(new ImageIcon(ClassLoader.getSystemResource("warrior.png")));

        if (board.getPlayer().getPontosDevida() <= 0) {
            CardLayout cardLayout = (CardLayout) layout.getLayout();
            cardLayout.show(layout, "End");
        }


    }

    private void setButtonIcons(Board board, JButton[][] arr) {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (board.boardCells[i][j].getCellStructure() instanceof Elixir && Game.isDebug()) {
                    arr[i][j].setIcon(new ImageIcon(ClassLoader.getSystemResource("elixir.png")));
                    //arr[i][j] = null;
                }
                if (board.boardCells[i][j].getCellStructure() instanceof Monster
                && i != board.getCellChefao().getLine() && j!= board.getCellChefao().getColumn() && Game.isDebug()) {
                    arr[i][j].setIcon(new ImageIcon(ClassLoader.getSystemResource("monstror.png")));
                    //arr[i][j] = null;
                }
                if (board.boardCells[i][j].getCellStructure() instanceof Armadilha && Game.isDebug()) {
                    arr[i][j].setIcon(new ImageIcon(ClassLoader.getSystemResource("armadilhaa.png")));
                    //arr[i][j] = null;
                }
                if(i == board.getCurrCellOfPlayer().getLine() && j== board.getCurrCellOfPlayer().getColumn()) {
                    arr[i][j].setIcon(new ImageIcon(ClassLoader.getSystemResource("warrior.png")));
                }
                if(i == board.getCellChefao().getLine() && j== board.getCellChefao().getColumn()){
                    arr[i][j].setIcon(new ImageIcon(ClassLoader.getSystemResource("monstroboss.png")));
                }
            }
        }
    }

}

