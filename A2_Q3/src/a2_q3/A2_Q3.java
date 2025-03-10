/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q3;

/**
 *
 * @author yashg
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class A2_Q3 extends JFrame {
    public A2_Q3() {
        setTitle("Tabbed Pane Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel colorPanel = new JPanel();
        JButton colorButton = new JButton("Choose Color");
        colorPanel.add(colorButton);
        
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(null, "Select a Color", getContentPane().getBackground());
            if (chosenColor != null) {
                getContentPane().setBackground(chosenColor);
            }
        });

        JPanel filePanel = new JPanel();
        JButton openFileButton = new JButton("Open File");
        JButton saveFileButton = new JButton("Save File");
        filePanel.add(openFileButton);
        filePanel.add(saveFileButton);

        openFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(null, "Selected file: " + selectedFile.getAbsolutePath());
            }
        });

        saveFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(null, "File saved: " + selectedFile.getAbsolutePath());
            }
        });
        
        tabbedPane.addTab("Color Chooser", colorPanel);
        tabbedPane.addTab("File Dialogs", filePanel);
        
        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(A2_Q3::new);
    }
}
