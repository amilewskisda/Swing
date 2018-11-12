package ticTacToeGame;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeButton extends JButton implements ActionListener {
    ImageIcon xImageIcon, oImageIcon;
    byte clickCounter = 0;

    public TicTacToeButton() {
        oImageIcon = new ImageIcon(getClass().getResource("resources/O.png"));
        xImageIcon = new ImageIcon(getClass().getResource("resources/X.png"));
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        clickCounter++;
        clickCounter %= 3;
        switch (clickCounter) {
            case 0:
                setIcon(null);
                break;
            case 1:
                setIcon(oImageIcon);
                break;
            case 2:
                setIcon(xImageIcon);
                break;
        }
    }
}