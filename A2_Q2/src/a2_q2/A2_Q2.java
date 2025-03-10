/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q2;

/**
 *
 * @author yashg
// */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//import java.sql.*;

//public class A2_Q2 {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/dbprac";
//        String user = "root";
//        String pass = "";
//        
//        try {
//            Connection con = DriverManager.getConnection(url, user, pass);
//            System.out.println("Database Connected Successfully!");
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

//
public class A2_Q2 extends JFrame {
    private JTextField empIdField, nameField, ageField, salaryField;
    private JButton insertButton, retrieveButton;
    private JTextArea displayArea;
    public static Connection connection;
    public static String url="jdbc:mysql://localhost:3306/dbprac";
    public static String user="root";
    public static String pass="";

    public A2_Q2() {
        setTitle("Employee Database");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        
        connectToDatabase();
        createTable();
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Emp ID:"));
        empIdField = new JTextField();
        inputPanel.add(empIdField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        insertButton = new JButton("Insert");
        retrieveButton = new JButton("Retrieve");
        inputPanel.add(insertButton);
        inputPanel.add(retrieveButton);

        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        insertButton.addActionListener(e -> insertData());
        retrieveButton.addActionListener(e -> retrieveData());

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   private void createTable() {
       try (Statement stmt = connection.createStatement()) {
           String createTableSQL = "CREATE TABLE IF NOT EXISTS employees ( emp_id INT PRIMARY KEY,name VARCHAR(50),age INT,salary DOUBLE )";
           stmt.execute(createTableSQL);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

    private void insertData() {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?)");) {
            pstmt.setInt(1, Integer.parseInt(empIdField.getText()));
            pstmt.setString(2, nameField.getText());
            pstmt.setInt(3, Integer.parseInt(ageField.getText()));
            pstmt.setDouble(4, Double.parseDouble(salaryField.getText()));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Inserted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error inserting data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retrieveData() {
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {
            displayArea.setText("Emp ID | Name | Age | Salary\n");
            displayArea.append("----------------------------------\n");
            while (rs.next()) {
                displayArea.append(rs.getInt("emp_id") + " | " + rs.getString("name") + " | " + rs.getInt("age") + " | " + rs.getDouble("salary") + "\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new A2_Q2();
    }
}
