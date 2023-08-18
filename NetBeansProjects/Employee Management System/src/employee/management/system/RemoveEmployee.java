package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JButton btnDelete, btnBack;
    
    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Employee ID Label
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        //Create Dropdown for Employee ID
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);
        
        //EmpID Selector
        try {
            JDBC j = new JDBC();
            
            //Get Details from Employee Table
            String query = "select * from employee";
            ResultSet rs = j.s.executeQuery(query);
            
            //Add Employee ID from empID column
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Name Label
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        //Name Detail Label
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        //Phone Label
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        //Phone no. Label
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        //Email Label
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        //Email Detail Label
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        //Set Details Of the Employee whose ID was Selected
        try {
            JDBC j = new JDBC();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = j.s.executeQuery(query);
            
            while(rs.next()) {
                
                //Get name from Name Column and Set it into lblname
                lblname.setText(rs.getString("Name"));
                //Get phone no. from Phone Column and Set it into lblphone
                lblphone.setText(rs.getString("Phone"));
                //Get email from Email Column and Set it into lblemail
                lblemail.setText(rs.getString("Email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //If We Change EmpID then It will Change Employee Detail
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    JDBC j = new JDBC();
                    String query = "select * from employee where EmpId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = j.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("Name"));
                        lblphone.setText(rs.getString("Phone"));
                        lblemail.setText(rs.getString("Email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        //Delete Button
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(80, 300, 100,30);
        btnDelete.setBackground(Color.BLACK);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.addActionListener(this);
        add(btnDelete);
        
        //Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(220, 300, 100,30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        add(btnBack);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnDelete) {
            try {
                JDBC j = new JDBC();
                
                //Delete Details of Selected Employee
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                j.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
                
                setVisible(false);
                new Home();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}