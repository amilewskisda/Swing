package ticTacToeGame;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class TicTacToeFrame extends JFrame {
    JPanel jPanel = new JPanel();
    TicTacToeButton buttons[] = new TicTacToeButton[9];

    public static void main(String args[]) {
        new TicTacToeFrame();
    }

    public TicTacToeFrame() {
        super("Kółko i krzyżyk super gra");
        setSize(500, 500);
        setResizable(false);    // przy ustawieniu na true programista ma więcej roboty z skalowaniem obrazów
        setDefaultCloseOperation(EXIT_ON_CLOSE); // spróbuj zakomentować i zamknąć Frame krzyżykiem
        jPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new TicTacToeButton();
            jPanel.add(buttons[i]);
        }
        add(jPanel);

        setVisible(true);
    }
}