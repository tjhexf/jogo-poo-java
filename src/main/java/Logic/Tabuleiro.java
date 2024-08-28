package Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro extends JPanel {
    //celula = cel[];
    //celulaAtual = celA;
    private static final int LINHAS = 5;
    private static final int COLUNAS = 10;

    public void avancaCelula(){

    }
    public Tabuleiro() {
        JPanel tela = new JPanel();
        tela.setLayout(new BorderLayout());

        JLabel rotulo = new JLabel("Mensagens: ", SwingConstants.CENTER);
        rotulo.setFont(new Font("Arial", Font.PLAIN, 16));
        tela.add(rotulo, BorderLayout.CENTER);
        tela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //espaçamento?

        JPanel gridPainel = new JPanel();
        gridPainel.setLayout(new GridLayout(LINHAS, COLUNAS, 5, 5)); //gridlayout com espaçamento 5
        gridPainel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton[][] botao = new JButton[LINHAS][COLUNAS];
        for(int i = 0; i < LINHAS; i++){
            for(int j = 0; j < COLUNAS; j++){
                botao[i][j] = new JButton(i+","+ j);
                gridPainel.add(botao[i][j]);

                botao[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton botaoMouse = (JButton) e.getSource();
                        String message = "Botao clicado: " + botaoMouse.getText();
                        System.out.println(message);
                        rotulo.setText(message);
                    }
                });
            }
        }
        add(gridPainel, BorderLayout.CENTER);
        add(tela, BorderLayout.SOUTH);
        setVisible(true);
    }
}
