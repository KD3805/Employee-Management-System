package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton btnView, btnAdd, btnUpdate, btnRemove;
    
    public Home() {
        
        setLayout(null);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        //Heading
        JLabel lblHead = new JLabel("Employee Management System");
        lblHead.setBounds(620, 20, 400, 40);
        lblHead.setFont(new Font("Raleway", Font.BOLD, 25));
        lblHead.setForeground(Color.BLACK);
        image.add(lblHead);
        
        //Add Button
        btnAdd = new JButton("Add Employee");
        btnAdd.setBounds(650, 80, 150, 40);
        btnAdd.addActionListener(this);
        image.add(btnAdd);
        
        //View Button
        btnView = new JButton("View Employees");
        btnView.setBounds(820, 80, 150, 40);
        btnView.addActionListener(this);
        image.add(btnView);
        
        //Update Button
        btnUpdate = new JButton("Update Employee");
        btnUpdate.setBounds(650, 140, 150, 40);
        btnUpdate.addActionListener(this);
        image.add(btnUpdate);
        
        //Remove Button
        btnRemove = new JButton("Remove Employee");
        btnRemove.setBounds(820, 140, 150, 40);
        btnRemove.addActionListener(this);
        image.add(btnRemove);
        
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnAdd) {
            setVisible(false);
            new AddEmployee();
            
        } else if(ae.getSource() == btnView) {
            setVisible(false);
            new ViewEmployee();
            
        } else if(ae.getSource() == btnUpdate) {
            setVisible(false);
            new ViewEmployee();
            
        } else {
            setVisible(false);
            new RemoveEmployee();
            
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
