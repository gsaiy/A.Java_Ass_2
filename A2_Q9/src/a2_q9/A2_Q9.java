/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q9;

/**
 *
 * @author yashg
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// JTextArea with Word and Character Count
public class A2_Q9 extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel, charCountLabel;

    public A2_Q9() {
        setTitle("Word and Character Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Text Area with ScrollPane
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Enter Text"));
        add(scrollPane, BorderLayout.CENTER);

        // Labels for Count
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");
        JPanel countPanel = new JPanel();
        countPanel.setLayout(new FlowLayout());
        countPanel.add(wordCountLabel);
        countPanel.add(charCountLabel);
        add(countPanel, BorderLayout.SOUTH);

        // Key Listener to Update Counts
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                updateCounts();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                updateCounts();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateCounts();
            }
        });

        setVisible(true);
    }

    private void updateCounts() {
        String text = textArea.getText().trim();
        int charCount = text.length();
        int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;

        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
    }

    public static void main(String[] args) {
        new A2_Q9();
    }
}
