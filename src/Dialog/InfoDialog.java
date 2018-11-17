package Dialog;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Container;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

public class InfoDialog extends JFrame {

    private JPanel panel;

    public InfoDialog() {
        initUserInterface();
    }

    private void initUserInterface() {

        panel = (JPanel) getContentPane();

        JButton btnWarning = new JButton("Ostrzeżenie");
        JButton btnError = new JButton("Błąd");
        JButton btnQuestion = new JButton("Pytanie");
        JButton btnInfo = new JButton("Info");

        // klasa JOptionPane daje nam możliwość pokazania dialogu showMessageDialog i skonkretyzowania jego typu np JOptionPane.WARNING_MESSAGE
        btnWarning.addActionListener(event ->
                JOptionPane.showMessageDialog(panel,
                "Ta operacja może powodować błędy.",
                        "Ostrzeżenie",
                        JOptionPane.WARNING_MESSAGE)
        );

        btnError.addActionListener(event ->
                JOptionPane.showMessageDialog(panel,
                "Operacja nie powiodła się",
                        "Błąd",
                        JOptionPane.ERROR_MESSAGE)
        );

        btnQuestion.addActionListener(event ->
                JOptionPane.showMessageDialog(
                        panel,
                "Czy jesteś pewien że chcesz wyjść z programu? :(",
                        "Czy jesteś pewien?",
                        JOptionPane.QUESTION_MESSAGE)
        );

        btnInfo.addActionListener(event ->
                JOptionPane.showMessageDialog(
                        panel,
                        "Operacja zakończona sukcesem.",
                        "Info", JOptionPane.INFORMATION_MESSAGE)
        );

        prepareLayout(btnWarning, btnError, btnQuestion, btnInfo);

        setTitle("Wybierz rodzaj dialogu");
        setSize(300, 200);
        setLocationRelativeTo(null); // otworzy okno na środku
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void prepareLayout(JComponent... btn) { //varargs

        Container pane = getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);

        groupLayout.setAutoCreateGaps(true); //utworzy odstępy

        // utworzenie HorizontalGroup i VerticalGroup jest konieczne w przeciwnym wypadku -> IllegalStateException
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE) // odstęp lewy
                .addGroup(groupLayout.createParallelGroup().addComponent(btn[0]).addComponent(btn[2]))
                .addGroup(groupLayout.createParallelGroup().addComponent(btn[1]).addComponent(btn[3]))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE) // odstęp prawy
        );

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE) // odstęp góra
                .addGroup(groupLayout.createParallelGroup().addComponent(btn[0]).addComponent(btn[1]))
                .addGroup(groupLayout.createParallelGroup().addComponent(btn[2]).addComponent(btn[3]))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE) // odstęp dół
        );

        groupLayout.linkSize(btn[0], btn[1], btn[2], btn[3]); // każdy przycisk będzie miał takie same wymiary bez względu na tekst jaki przedstawia
    }

    public static void main(String[] args) {

        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setVisible(true);
    }
}