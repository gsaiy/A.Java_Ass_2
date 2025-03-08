/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2_q4;

/**
 *
 * @author yashg
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Bean Class to Store Resume Data
class ResumeBean {
    private String name;
    private String address;
    private String salary;
    private String marks;
    private String gender;
    private String hobbies;
    
    public ResumeBean(String name, String address, String salary, String marks, String gender, String hobbies) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.marks = marks;
        this.gender = gender;
        this.hobbies = hobbies;
    }
    
    public String getFormattedDetails() {
        return "Resume Details:\n" +
               "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "Expected Salary: " + salary + "\n" +
               "Marks: " + marks + "\n" +
               "Gender: " + gender + "\n" +
               "Hobbies: " + hobbies;
    }
}

// Main Frame for Resume Form
public class A2_Q4 extends JFrame {
    private JTextField nameField, addressField, salaryField, marksField;
    private JRadioButton maleRadio, femaleRadio;
    private JCheckBox readingCheck, musicCheck, sportsCheck;
    private JButton submitButton;
    
    public A2_Q4() {
        setTitle("Resume Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));
        
        // Input Fields
        add(new JLabel("Name: "));
        nameField = new JTextField();
        add(nameField);
        
        add(new JLabel("Address: "));
        addressField = new JTextField();
        add(addressField);
        
        add(new JLabel("Expected Salary: "));
        salaryField = new JTextField();
        add(salaryField);
        
        add(new JLabel("Marks: "));
        marksField = new JTextField();
        add(marksField);
        
        // Gender Radio Buttons
        add(new JLabel("Gender: "));
        JPanel genderPanel = new JPanel();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        add(genderPanel);
        
        // Hobbies Checkboxes
        add(new JLabel("Hobbies: "));
        JPanel hobbiesPanel = new JPanel();
        readingCheck = new JCheckBox("Reading");
        musicCheck = new JCheckBox("Music");
        sportsCheck = new JCheckBox("Sports");
        hobbiesPanel.add(readingCheck);
        hobbiesPanel.add(musicCheck);
        hobbiesPanel.add(sportsCheck);
        add(hobbiesPanel);
        
        // Submit Button
        submitButton = new JButton("Submit");
        add(submitButton);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });
        
        setVisible(true);
    }
    
    private void submitForm() {
        String name = nameField.getText();
        String address = addressField.getText();
        String salary = salaryField.getText();
        String marks = marksField.getText();
        String gender = maleRadio.isSelected() ? "Male" : (femaleRadio.isSelected() ? "Female" : "Not specified");
        
        StringBuilder hobbies = new StringBuilder();
        if (readingCheck.isSelected()) hobbies.append("Reading ");
        if (musicCheck.isSelected()) hobbies.append("Music ");
        if (sportsCheck.isSelected()) hobbies.append("Sports ");
        
        ResumeBean resume = new ResumeBean(name, address, salary, marks, gender, hobbies.toString());
        new ResumeDisplay(resume);
    }
    
    public static void main(String[] args) {
        new A2_Q4();
    }
}

// New Frame to Display Resume Details
class ResumeDisplay extends JFrame {
    public ResumeDisplay(ResumeBean resume) {
        setTitle("Resume Details");
        setSize(300, 300);
        setLayout(new BorderLayout());
        
        JTextArea displayArea = new JTextArea(resume.getFormattedDetails());
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
}
