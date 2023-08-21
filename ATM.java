import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame {
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton balanceButton;
    private JButton exitButton;

    private double accountBalance = 1000.0;

    public ATM() {
        setTitle("XYZ Bank ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        withdrawButton = new JButton("Withdraw Money");
        depositButton = new JButton("Deposit Money");
        balanceButton = new JButton("Check Balance");
        exitButton = new JButton("Exit");

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to handle withdrawal logic
                double withdrawalAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount:"));
                withdraw(withdrawalAmount);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to handle deposit logic
                double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
                deposit(depositAmount);
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to handle balance checking logic
                checkBalance();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(balanceButton);
        panel.add(exitButton);

        add(panel);
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: $" + accountBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient balance.");
        }
    }

    private void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: $" + accountBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }

    private void checkBalance() {
        JOptionPane.showMessageDialog(null, "Your current balance: $" + accountBalance);
    }


    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
