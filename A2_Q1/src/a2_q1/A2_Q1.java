/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class A2_Q1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListFrame());
    }
}

class ListFrame extends JFrame {
    private JList<String> list1, list2;
    private DefaultListModel<String> model1, model2;
    private JButton copyButton;

    public ListFrame() {
        setTitle("JList Copy Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        model1 = new DefaultListModel<>();
        model2 = new DefaultListModel<>();
        
        model1.addElement("Apple");
        model1.addElement("Banana");
        model1.addElement("Cherry");
        model1.addElement("Date");
        model1.addElement("Elderberry");
        
        list1 = new JList<>(model1);
        list2 = new JList<>(model2);
        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane1 = new JScrollPane(list1);
        JScrollPane scrollPane2 = new JScrollPane(list2);
        scrollPane1.setPreferredSize(new Dimension(150, 200));
        scrollPane2.setPreferredSize(new Dimension(150, 200));

        copyButton = new JButton("Copy →");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String selectedValue : list1.getSelectedValuesList()) {
                    if (!model2.contains(selectedValue)) {
                        model2.addElement(selectedValue);
                    }
                }
            }
        });

        add(scrollPane1);
        add(copyButton);
        add(scrollPane2);
        
        setVisible(true);
    }
}
