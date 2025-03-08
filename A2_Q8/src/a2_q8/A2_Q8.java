/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q8;

/**
 *
 * @author yashg
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ListBox Example with Programming Languages and Frameworks
public class A2_Q8 extends JFrame {
    private JList<String> languageList, frameworkList;
    private JLabel resultLabel;
    private JButton displayButton;

    public A2_Q8() {
        setTitle("Programming Languages and Frameworks");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Programming Languages List (Single Selection)
        String[] languages = {"Java", "Python", "C++", "JavaScript", "Ruby"};
        languageList = new JList<>(languages);
        languageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane langScrollPane = new JScrollPane(languageList);
        langScrollPane.setBorder(BorderFactory.createTitledBorder("Languages"));

        // Frameworks List (Multi-Selection)
        String[] frameworks = {"Spring", "Django", "React", "Angular", "Vue"};
        frameworkList = new JList<>(frameworks);
        frameworkList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane frameworkScrollPane = new JScrollPane(frameworkList);
        frameworkScrollPane.setBorder(BorderFactory.createTitledBorder("Frameworks"));

        // Display Button
        displayButton = new JButton("Show Selection");
        resultLabel = new JLabel("Selected: None", SwingConstants.CENTER);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySelection();
            }
        });

        // Layout Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(langScrollPane);
        panel.add(frameworkScrollPane);

        add(panel, BorderLayout.CENTER);
        add(displayButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void displaySelection() {
        String language = languageList.getSelectedValue();
        java.util.List<String> frameworks = frameworkList.getSelectedValuesList();
        
        String selectedText = "Selected: " + (language != null ? language : "None") + " | Frameworks: " + (frameworks.isEmpty() ? "None" : String.join(", ", frameworks));
        resultLabel.setText(selectedText);
    }

    public static void main(String[] args) {
        new A2_Q8();
    }
}
