import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ModelViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("View the Model");
            frame.setLayout(new BorderLayout()); // Use BorderLayout

            final JFXPanel fxPanel = new JFXPanel();
            frame.add(fxPanel, BorderLayout.CENTER); // Add JFXPanel at the center

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set the layout

            // Create buttons
            JButton saveButton = new JButton("Save");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");
            JButton returnButton = new JButton("Return");

            // Add action listeners for the buttons
            saveButton.addActionListener(e -> System.out.println("Save"));
            editButton.addActionListener(e -> System.out.println("Edit"));
            deleteButton.addActionListener(e -> System.out.println("Delete"));
            returnButton.addActionListener(e -> System.out.println("Hello"));

            // Add buttons to the panel
            buttonPanel.add(saveButton);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(returnButton);

            // Add the panel of buttons to the bottom of the frame
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Platform.runLater(() -> {
                initFX(fxPanel);
            });
        });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        WebView webView = new WebView();
        webView.getEngine().load("https://sketchfab.com/models/433b076e60e04a5987c278d74570a6b5/embed");

        Scene scene = new Scene(webView);
        fxPanel.setScene(scene);
    }
}
