import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainTicketPurchase {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Train Ticket Purchase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel startLabel = new JLabel("Start Station:");
        startLabel.setBounds(10, 20, 100, 25);
        panel.add(startLabel);

        String[] stations = {"N1", "N2", "N3", "N4", "N5", "N6", "N7", "N8", "N9", "N10"};
        JComboBox<String> startCombo = new JComboBox<>(stations);
        startCombo.setBounds(120, 20, 100, 25);
        panel.add(startCombo);

        JLabel endLabel = new JLabel("End Station:");
        endLabel.setBounds(10, 50, 100, 25);
        panel.add(endLabel);

        JComboBox<String> endCombo = new JComboBox<>(stations);
        endCombo.setBounds(120, 50, 100, 25);
        panel.add(endCombo);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 110, 200, 25);
        panel.add(resultLabel);

        JLabel paymentLabel = new JLabel("Enter Payment:");
        paymentLabel.setBounds(10, 80, 100, 25);
        panel.add(paymentLabel);

        JTextField paymentText = new JTextField(20);
        paymentText.setBounds(120, 80, 100, 25);
        panel.add(paymentText);

        JButton calculateChangeButton = new JButton("Calculate Change");
        calculateChangeButton.setBounds(10, 140, 150, 25);
        panel.add(calculateChangeButton);

        calculateChangeButton.addActionListener(e -> {
            String selectedStartStation = (String) startCombo.getSelectedItem();
            String selectedEndStation = (String) endCombo.getSelectedItem();
            int startStation = Integer.parseInt(selectedStartStation.substring(1));
            int endStation = Integer.parseInt(selectedEndStation.substring(1));
            int totalFare = calculateFare(startStation, endStation, 16, 3);
            resultLabel.setText("Total Fare: " + totalFare + " baht");

            try {
                int payment = Integer.parseInt(paymentText.getText());
                int change = payment - totalFare;
                if (change >= 0) {
                    resultLabel.setText("Total Fare: " + totalFare + " baht");
                    JOptionPane.showMessageDialog(null, "Change: " + change + " baht", "Change", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Payment", "Insufficient Payment", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input for payment", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static int calculateFare(int startStation, int endStation, int basePrice, int additionalPrice) {
        int distance = Math.abs(endStation - startStation);
        return basePrice + (distance - 1) * additionalPrice;
    }
}
