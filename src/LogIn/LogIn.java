package LogIn;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;

    //JLabel infoLabel;

    public LogIn() {
        initUI();
    }

    private void initUI() {

        JLabel loginLabel = new JLabel("Login");
        JLabel passwordLabel = new JLabel("Hasło");
        //infoLabel = new JLabel("Wprowadź login i hasło");

        loginField = new JTextField(15);
        passwordField = new JPasswordField(15);

        JButton submitButton = new JButton("Potwierdź");
        submitButton.addActionListener(new SubmitAction());

        //createLayout(loginLabel, loginField, passwordLabel, passwordField, submitButton, infoLabel);
        createLayout(loginLabel, loginField, passwordLabel, passwordField, submitButton);

        setTitle("Logowanie");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class SubmitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            logInAction();
        }

        private void logInAction() {
            // TODO
            // ZADANIE: obsłuż przypadki gdy podany login/haslo jest nieprawidlowy lub w ogole nie zostal wypelniony.
            // Poinformuj użytkownika o zaistnialej sytuacji na ekranie. Błąd kolor czerwony, sukces zielony

/*            String login = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());
            System.out.println("Wprowadzono login: " + login + " hasło: " + password);

            if (login.equals("SDA") && password.equals("sdaPass")) {
                infoLabel.setText("Witaj użytkowniku SDA!");
                infoLabel.setForeground(Color.GREEN);
            } else {
                infoLabel.setText("Błąd logowania");
                infoLabel.setForeground(Color.RED);
            }*/
        }
    }

    private void createLayout(Component... arg) {

        Container pane = getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4])
                        .addComponent(arg[5]))
        );

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[2])
                        .addComponent(arg[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[4])
                        .addComponent(arg[5]))
        );
        pack();
    }

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
    }
}