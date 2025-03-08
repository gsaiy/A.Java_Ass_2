/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q6;

/**
 *
 * @author yashg
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

// JList Example with Add and Remove Functionality
public class A2_Q6 extends JFrame {
    private JList<String> subjectList;
    private DefaultListModel<String> listModel;
    private JTextField subjectField;
    private JButton addButton, removeButton;

    public A2_Q6() {
        setTitle("Subject List Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Initialize List with Default Subjects
        listModel = new DefaultListModel<>();
        listModel.addElement("Math");
        listModel.addElement("Science");
        listModel.addElement("English");
        listModel.addElement("History");
        listModel.addElement("Geography");

        subjectList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(subjectList);
        add(scrollPane, BorderLayout.CENTER);

        // Input Field and Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        subjectField = new JTextField(15);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        panel.add(subjectField);
        panel.add(addButton);
        panel.add(removeButton);

        add(panel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSubject();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSubject();
            }
        });

        setVisible(true);
    }

    private void addSubject() {
        String subject = subjectField.getText().trim();
        if (!subject.isEmpty() && !listModel.contains(subject)) {
            listModel.addElement(subject);
            subjectField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Subject already exists or field is empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeSubject() {
        String subject = subjectField.getText().trim();
        if (listModel.contains(subject)) {
            listModel.removeElement(subject);
            subjectField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Subject not found in the list.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new A2_Q6();
    }
}
