package Calculator1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author kensh
 */
public class Calculator1 extends javax.swing.JFrame {
    
    private JTextField display;
    private JLabel sessionLabel;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewNumber = true;
    private String session = "";

    /**
     * Creates new form Calculator
     */
    public Calculator1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setTitle("Kalkulator");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Session Label
        sessionLabel = new JLabel();
        sessionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        sessionLabel.setText("0");

        // Display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setText("0");

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel untuk session dan display
        JPanel displayPanel = new JPanel(new BorderLayout(0, 5));
        displayPanel.add(sessionLabel, BorderLayout.NORTH);
        displayPanel.add(display, BorderLayout.SOUTH);
        
        mainPanel.add(displayPanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));

        // Buttons array: [row1, row2, row3, row4, row5, row6]
        String[][] buttons = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "=", "+"},
            {"%", "mod", "x²", "x³"},
            {"√", "C", "←", ""}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String btnText = buttons[row][col];
                if (btnText.isEmpty()) {
                    buttonPanel.add(new JPanel()); // Empty placeholder
                } else {
                    JButton btn = createButton(btnText);
                    buttonPanel.add(btn);
                }
            }
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
        pack();
        setSize(320, 420);
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);

        btn.addActionListener((ActionEvent e) -> handleButtonClick(text));
        return btn;
    }

    private void handleButtonClick(String buttonText) {
        String currentDisplay = display.getText();

        switch (buttonText) {
            case "C":
                display.setText("0");
                sessionLabel.setText("0");
                firstNumber = 0;
                operator = "";
                session = "";
                isNewNumber = true;
                break;
            case "←":
                if (currentDisplay.length() > 1) {
                    display.setText(currentDisplay.substring(0, currentDisplay.length() - 1));
                } else {
                    display.setText("0");
                }
                isNewNumber = true;
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "mod":
                if (!operator.isEmpty() && !isNewNumber) {
                    calculateResult();
                    session = display.getText() + " " + buttonText + " ";
                } else {
                    firstNumber = Double.parseDouble(currentDisplay);
                    session = currentDisplay + " " + buttonText + " ";
                }
                operator = buttonText;
                sessionLabel.setText(session);
                isNewNumber = true;
                break;
            case "x²":
                try {
                    double num = Double.parseDouble(currentDisplay);
                    double result = num * num;
                    display.setText(formatResult(result));
                    session = currentDisplay + "² = ";
                    sessionLabel.setText(session);
                    isNewNumber = true;
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
                break;
            case "x³":
                try {
                    double num = Double.parseDouble(currentDisplay);
                    double result = num * num * num;
                    display.setText(formatResult(result));
                    session = currentDisplay + "³ = ";
                    sessionLabel.setText(session);
                    isNewNumber = true;
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
                break;
            case "√":
                try {
                    double num = Double.parseDouble(currentDisplay);
                    if (num < 0) {
                        display.setText("Error");
                    } else {
                        double result = Math.sqrt(num);
                        display.setText(formatResult(result));
                        session = "√" + currentDisplay + " = ";
                        sessionLabel.setText(session);
                        isNewNumber = true;
                    }
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                }
                break;
            case "=":
                if (!operator.isEmpty() && !isNewNumber) {
                    session += currentDisplay;
                    sessionLabel.setText(session);
                    calculateResult();
                }
                isNewNumber = true;
                break;
            case ".":
                if (!currentDisplay.contains(".")) {
                    display.setText(currentDisplay + ".");
                    isNewNumber = false;
                }
                break;
            default:
                if (isNewNumber) {
                    display.setText(buttonText);
                    isNewNumber = false;
                } else {
                    display.setText(currentDisplay + buttonText);
                }
                break;
        }
    }

    private void calculateResult() {
        try {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
                case "%":
                    result = (firstNumber / 100) * secondNumber;
                    break;
                case "mod":
                    result = firstNumber % secondNumber;
                    break;
            }

            display.setText(formatResult(result));
            firstNumber = result;
            operator = "";
            isNewNumber = true;
        } catch (NumberFormatException ex) {
            display.setText("Error");
        }
    }

    private String formatResult(double number) {
        if (number == (long) number) {
            return String.format("%d", (long) number);
        } else {
            return String.format("%.6f", number).replaceAll("0+$", "").replaceAll("\\.$", "");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Calculator1().setVisible(true));
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}