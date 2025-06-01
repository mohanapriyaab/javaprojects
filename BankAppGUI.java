import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ✅ Custom Exception: InvalidAmountException
class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

// ✅ Custom Exception: InsufficientFundsException
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

// ✅ Main Bank GUI Application
public class BankAppGUI extends JFrame {
    private double balance = 1000.0;

    private JTextField amountField;
    private JTextArea outputArea;

    public BankAppGUI() {
        setTitle("🏦 MyBank - Swing App");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🎨 Input & Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        amountField = new JTextField();
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton balanceBtn = new JButton("Check Balance");

        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositBtn);
        panel.add(withdrawBtn);

        // 💬 Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add components
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(balanceBtn, BorderLayout.SOUTH);

        // 🧠 Action Listeners
        depositBtn.addActionListener(e -> handleDeposit());
        withdrawBtn.addActionListener(e -> handleWithdraw());
        balanceBtn.addActionListener(e -> showBalance());
    }

    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            deposit(amount);
            showMessage("Deposited ₹" + amount);
        } catch (InvalidAmountException ex) {
            showMessage("❌ " + ex.getMessage());
        } catch (NumberFormatException ex) {
            showMessage("❌ Enter a valid number.");
        }
    }

    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            withdraw(amount);
            showMessage("Withdrawn ₹" + amount);
        } catch (InvalidAmountException | InsufficientFundsException ex) {
            showMessage("❌ " + ex.getMessage());
        } catch (NumberFormatException ex) {
            showMessage("❌ Enter a valid number.");
        }
    }

    private void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit must be more than zero.");
        }
        balance += amount;
    }

    private void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal must be more than zero.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available: ₹" + balance);
        }
        balance -= amount;
    }

    private void showBalance() {
        showMessage("Current Balance: ₹" + balance);
        showMessage("Thank you for banking with us! 😊");
    }

    private void showMessage(String message) {
        outputArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankAppGUI().setVisible(true);
        });
    }
}
