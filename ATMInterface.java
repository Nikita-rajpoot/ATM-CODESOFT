import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class ATMInterface extends JFrame {
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton balanceButton;
    private JButton exitButton;

    private BankAccount userAccount;

    public ATMInterface(BankAccount account) {
        userAccount = account;

        setTitle("XYZ Bank ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(null);

        withdrawButton = new JButton("Withdraw Money");
        withdrawButton.setBounds(420, 80, 250, 30);
        withdrawButton.setForeground(new Color(102, 252, 241));
        withdrawButton.setBorder(BorderFactory.createEtchedBorder());
        withdrawButton.setBorder(new LineBorder(new Color(102, 252, 241)));
        withdrawButton.setBackground(new Color(11, 12, 16));

        depositButton = new JButton("Deposit Money");
        depositButton.setBounds(420, 80, 250, 30);
        depositButton.setForeground(new Color(102, 252, 241));
        depositButton.setBorder(BorderFactory.createEtchedBorder());
        depositButton.setBorder(new LineBorder(new Color(102, 252, 241)));
        depositButton.setBackground(new Color(11, 12, 16));

        balanceButton = new JButton("Check Balance");
        balanceButton.setBounds(420, 80, 250, 30);
        balanceButton.setForeground(new Color(102, 252, 241));
        balanceButton.setBorder(BorderFactory.createEtchedBorder());
        balanceButton.setBorder(new LineBorder(new Color(102, 252, 241)));
        balanceButton.setBackground(new Color(11, 12, 16));

        exitButton = new JButton("Exit");
        exitButton.setBounds(420, 80, 250, 30);
        exitButton.setForeground(new Color(102, 252, 241));
        exitButton.setBorder(BorderFactory.createEtchedBorder());
        exitButton.setBorder(new LineBorder(new Color(102, 252, 241)));
        exitButton.setBackground(new Color(11, 12, 16));

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to handle withdrawal logic
                double withdrawalAmount = getAmountFromUserInput("Enter withdrawal amount:");
                if(withdrawalAmount > 0 && userAccount.withdraw(withdrawalAmount)){
                    JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                    showMessage("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient balance.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to handle deposit logic
                double depositAmount = getAmountFromUserInput("Enter deposit amount:");
                if (depositAmount > 0) {
                    userAccount.deposit(depositAmount);
                    JOptionPane.showMessageDialog(null, "Deposit successful. New balance: $" + userAccount.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
                }
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to handle balance checking logic
                JOptionPane.showMessageDialog(null, "Your current balance: $" + userAccount.getBalance());
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

    private double getAmountFromUserInput(String message) {
        try {
            String input = JOptionPane.showInputDialog(message);
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1.0; // Invalid input
        }
    }

    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATMInterface atm = new ATMInterface(account);
        atm.run();
    }
}


