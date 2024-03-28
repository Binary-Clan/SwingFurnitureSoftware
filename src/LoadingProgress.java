import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingProgress extends JFrame {

    private final JProgressBar progressBar;
    private final JLabel loadingLabel;
    private Timer blinkTimer;

    public LoadingProgress() {
        setTitle("Generating Progress");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 700);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(150, 100, 21)); // Set light brown background color

        // Create a panel for the logo
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon logoIcon = new ImageIcon("assets/Sofa scape.png"); // Change "logo.png" to your image file path
        JLabel logoLabel = new JLabel(logoIcon);
        // Add margin from the top to the image
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        logoPanel.add(logoLabel);

        // Create a panel for the progress bar
        JPanel progressBarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBarPanel.add(progressBar);

        add(logoPanel, BorderLayout.NORTH);
        add(progressBarPanel, BorderLayout.CENTER);

        // Create a label for displaying "Generating..."
        loadingLabel = new JLabel("Generating...");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setForeground(Color.WHITE);
        // Add margin from the top to the Generating label
        loadingLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        add(loadingLabel, BorderLayout.SOUTH);

        // Simulate progress
        simulateProgress();

        setVisible(true);
    }

    private void simulateProgress() {
        int delay = 200; // Milliseconds
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = progressBar.getValue();
                if (value < progressBar.getMaximum()) {
                    progressBar.setValue(value + 1);
                } else {
                    ((Timer) e.getSource()).stop();
                    loadingLabel.setText("Generating complete!");
                    progressBar.setString("Generating complete!");
                    progressBar.setStringPainted(true);
                    blinkTimer.stop();
                    JOptionPane.showMessageDialog(LoadingProgress.this, "Generating Complete!");
                }
            }
        });
        timer.start();

        // Blinking loading label
        blinkTimer = new Timer(600, new ActionListener() {
            private boolean isVisible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                loadingLabel.setVisible(isVisible);
                isVisible = !isVisible;
            }
        });
        blinkTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoadingProgress::new);
    }
}
