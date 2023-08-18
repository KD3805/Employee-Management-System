package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation, tffname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation;
    JButton btnUpdate, btnBack;
    String empId;
    
    UpdateEmployee(String EmpId) {
        this.empId = EmpId;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Header
        JLabel lblHeader = new JLabel("UPDATE  EMPLOYEE  DETAILS");
        lblHeader.setBounds(280, 30, 500, 50);
        lblHeader.setFont(new Font("SERIF", Font.BOLD, 25));
        add(lblHeader);
        
        //Name Label
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        //Default Name Label
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        //Father's Name Label
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        //Father's Name TextField
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        //Date of Birth Label
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        //Default DOB
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        //Salary Label
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        //Salary TextField
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        //Address Label
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        //Address TextField
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        //Phone No. Label
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        //Phone No. TextField
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        //Email Label
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        //Email TextField
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        //Education Label
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        //Education TextField
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        //Designation Label
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        //Designation TextField
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        //Aadhar No. Label
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        //Aadhar No. TextField
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);
        
        //Employee ID Label
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        //Default Employee ID
        JLabel lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            JDBC j = new JDBC();
            
            String query = "select * from employee where EmpId = '"+empId+"'";
            ResultSet rs = j.s.executeQuery(query);
            
            //Set Data Which is Already Exist 
            while(rs.next()) {
                lblname.setText(rs.getString("Name"));
                tffname.setText(rs.getString("FName"));
                lbldob.setText(rs.getString("DOB"));
                tfsalary.setText(rs.getString("Salary"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                tfeducation.setText(rs.getString("Education"));
                tfdesignation.setText(rs.getString("Designation"));
                lblaadhar.setText(rs.getString("Aadhar"));
                lblempId.setText(rs.getString("EmpId"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        //Update Button
        btnUpdate = new JButton("Update Details");
        btnUpdate.setBounds(250, 550, 150, 40);
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);
        
        //Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(450, 550, 150, 40);
        btnBack.addActionListener(this);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnUpdate) {
            
            //Get Updated Data And Store Them into String variables
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) tfeducation.getText();
            String designation = tfdesignation.getText();
            
            
            try {
                JDBC conn = new JDBC();
                String query = "update employee set FName = '"+fname+"', Salary = '"+salary+"', Address = '"+address+"', Phone = '"+phone+"', Email = '"+email+"', Education = '"+education+"', Designation = '"+designation+"' where EmpId = '"+empId+"' ";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                
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
        new UpdateEmployee("");
    }
}
