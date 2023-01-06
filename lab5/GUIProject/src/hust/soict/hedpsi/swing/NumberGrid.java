package hust.soict.hedpsi.swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumber = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= 0 && button.charAt(0) <= 9) {
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                String text = tfDisplay.getText();
                tfDisplay.setText(text.substring(0, text.length() - 1));
            } else if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(getComponentOrientation().RIGHT_TO_LEFT);
        JPanel panelButton = new JPanel(new GridLayout(4, 3));
        addButtons(panelButton);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButton, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(400, 400);
        setVisible(true);
        displayResult();

    }

    void addButtons(JPanel panelButton) {
        ButtonListener btnListener = new ButtonListener();
        for (int i = 0; i < 10; i++) {
            btnNumber[i] = new JButton("" + i);
            panelButton.add(btnNumber[i]);
            btnNumber[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        panelButton.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButton.add(btnReset);
        btnReset.addActionListener(btnListener);

    }

    // display result
    public void displayResult() {
        System.out.println(tfDisplay.getText());
    }

    // main
    public static void main(String[] args) {
        new NumberGrid();
    }
}
