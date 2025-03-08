package a2_q5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

// Bean Class to Store Student Data
class StudentBean {
    private String name, dob, email, city, rollNo, college;

    public StudentBean(String name, String dob, String email, String city, String rollNo, String college) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.city = city;
        this.rollNo = rollNo;
        this.college = college;
    }

    public Object[] toTableRow() {
        return new Object[]{name, dob, email, city, rollNo, college};
    }
}

// Main Frame for Student Form
public class A2_Q5 extends JFrame {
    private JTextField nameField, dobField, emailField, cityField, rollNoField, collegeField;
    private JButton submitButton, displayButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private ArrayList<StudentBean> studentList = new ArrayList<>();

    public A2_Q5() {
        setTitle("Student Information Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));
        setResizable(false);

        // Input Fields
        add(new JLabel("Name: "));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Date of Birth: "));
        dobField = new JTextField();
        add(dobField);

        add(new JLabel("Email: "));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("City: "));
        cityField = new JTextField();
        add(cityField);

        add(new JLabel("Roll No: "));
        rollNoField = new JTextField();
        add(rollNoField);

        add(new JLabel("College: "));
        collegeField = new JTextField();
        add(collegeField);

        // Buttons
        submitButton = new JButton("Submit");
        displayButton = new JButton("Display Students");
        add(submitButton);
        add(displayButton);

        // Table to Display Student Data
        String[] columnNames = {"Name", "DOB", "Email", "City", "Roll No", "College"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
                new StudentDisplay(studentList);
            }
        });

        setVisible(true);
    }

    private void submitStudent() {
        String name = nameField.getText();
        String dob = dobField.getText();
        String email = emailField.getText();
        String city = cityField.getText();
        String rollNo = rollNoField.getText();
        String college = collegeField.getText();

        StudentBean student = new StudentBean(name, dob, email, city, rollNo, college);
        studentList.add(student);
        tableModel.addRow(student.toTableRow());
        JOptionPane.showMessageDialog(this, "Student Information Saved!");
        
        // Clear fields after submission
        nameField.setText("");
        dobField.setText("");
        emailField.setText("");
        cityField.setText("");
        rollNoField.setText("");
        collegeField.setText("");
    }

    private void displayStudents() {
        tableModel.setRowCount(0);
        for (StudentBean student : studentList) {
            tableModel.addRow(student.toTableRow());
        }
    }

    public static void main(String[] args) {
        new A2_Q5();
    }
}

// New Frame to Display Student Details
class StudentDisplay extends JFrame {
    public StudentDisplay(ArrayList<StudentBean> students) {
        setTitle("Student Details");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setResizable(false);

        String[] columnNames = {"Name", "DOB", "Email", "City", "Roll No", "College"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable studentTable = new JTable(tableModel);

        for (StudentBean student : students) {
            tableModel.addRow(student.toTableRow());
        }

        add(new JScrollPane(studentTable), BorderLayout.CENTER);
        setVisible(true);
    }
}
