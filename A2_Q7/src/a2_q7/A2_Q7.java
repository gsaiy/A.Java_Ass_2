/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q7;

/**
 *
 * @author yashg
 */
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

// JTree Example with States and Cities
public class A2_Q7 extends JFrame {
    public A2_Q7() {
        setTitle("State and City Tree");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Root Node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("States");

        // Gujarat Node
        DefaultMutableTreeNode gujarat = new DefaultMutableTreeNode("Gujarat");
        gujarat.add(new DefaultMutableTreeNode("Ahmedabad"));
        gujarat.add(new DefaultMutableTreeNode("Gandhinagar"));
        gujarat.add(new DefaultMutableTreeNode("Rajkot"));
        gujarat.add(new DefaultMutableTreeNode("Jamnagar"));
        root.add(gujarat);

        // Maharashtra Node
        DefaultMutableTreeNode maharashtra = new DefaultMutableTreeNode("Maharashtra");
        maharashtra.add(new DefaultMutableTreeNode("Mumbai"));
        maharashtra.add(new DefaultMutableTreeNode("Pune"));
        maharashtra.add(new DefaultMutableTreeNode("Nasik"));
        root.add(maharashtra);

        // Create JTree
        JTree tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new A2_Q7();
    }
}
