package Logic;

import Items.Barbaro;
import Items.Elixir;
import Items.Heroi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro extends JPanel {
    //celula = cel[];
    //celulaAtual = celA;
    private static final int LINHAS = 5;
    private static final int COLUNAS = 10;

    public Tabuleiro() {
        super(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel tela = new JPanel();
        tela.setLayout(new GridBagLayout());

        JLabel rotulo = new JLabel("Mensagens: ", SwingConstants.CENTER);
        rotulo.setFont(new Font("Arial", Font.PLAIN, 16));
        tela.add(rotulo, c);
        tela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //espaçamento?

        Board board = new Board();

        board.setPlayer(new Barbaro());

        board.createCells();



        //Cell playercellCurr = board.getCurrCellOfPlayer();


        JPanel gridPainel = new JPanel();
        gridPainel.setLayout(new GridBagLayout());


        gridPainel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton[][] botao = new JButton[LINHAS][COLUNAS];

        for(int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                botao[i][j] = new JButton();
                c.gridx = i;
                c.weighty = 1;
                c.weightx = 1;
                botao[i][j].setPreferredSize(new Dimension(20, 40));
                c.fill = GridBagConstraints.BOTH;
                c.gridy = j;
                gridPainel.add(botao[i][j], c);

                int finalI = i;
                int finalJ = j;
                botao[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton botaoMouse = (JButton) e.getSource();
                        String message = "Botao clicado: " + botaoMouse.getText();
                        //movePlayer(board.boardCells[finalI][finalJ],);
                        System.out.println(message);
                        rotulo.setText(message);
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
        add(tela, c);
        setVisible(true);
    }

    private void movePlayer(Board board, Cell cellToDisplayPlayer, JButton[][] arr) {
        int celx = cellToDisplayPlayer.getLine();
        int cely = cellToDisplayPlayer.getColumn();

        int srccelx = board.getCurrCellOfPlayer().getLine();
        int srccely = board.getCurrCellOfPlayer().getColumn();

        arr[celx][cely].setIcon(new ImageIcon(ClassLoader.getSystemResource("barbariann.png")));

        arr[srccelx][srccely].setIcon(null);

    }

    private void setButtonIcons(Board board, JButton[][] arr) {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (board.boardCells[i][j].getCellStructure() instanceof Elixir) {
                    arr[i][j].setIcon(new ImageIcon(ClassLoader.getSystemResource("elixir.png")));
                }

            }
        }
    }

}

