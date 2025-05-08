import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class LoveCalculator extends JFrame implements ActionListener {
    JTextField nameField1, nameField2;
    JButton calculateBtn;
    JLabel resultLabel;

    public LoveCalculator() {
        setTitle("💖 Love Calculator 💖");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Name 1:"));
        nameField1 = new JTextField(20);
        add(nameField1);

        add(new JLabel("Enter Name 2:"));
        nameField2 = new JTextField(20);
        add(nameField2);

        calculateBtn = new JButton("Calculate Love 💘");
        calculateBtn.addActionListener(this);
        add(calculateBtn);

        resultLabel = new JLabel("Your result will appear here...");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name1 = nameField1.getText().trim().toLowerCase();
        String name2 = nameField2.getText().trim().toLowerCase();

        if (name1.isEmpty() || name2.isEmpty()) {
            resultLabel.setText("Please enter both names 😅");
            return;
        }

        int lovePercent = calculateLove(name1, name2);
        String message = getLoveMessage(lovePercent);

        resultLabel.setText("💖 " + lovePercent + "% - " + message);
    }

    // Fun logic: generate love % based on hash for consistency
    private int calculateLove(String name1, String name2) {
        int hash = (name1 + name2).hashCode();
        Random rand = new Random(Math.abs(hash));
        return 10 + rand.nextInt(51); // 50 to 100%
    }

    private String getLoveMessage(int percent) {
        if (percent > 90) return "You're made for each other! 💍😍";
        else if (percent > 75) return "So cute together 💕";
        else if (percent > 60) return "Nice chemistry 💫";
        else if (percent > 40) return "Can be good friends 😅";
        else return "Just move on da... 🙃";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoveCalculator app = new LoveCalculator();
            app.setVisible(true);
        });
    }
} 