package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    //Create a Table for View Employee Details
    JTable table;
    //Create an Object Choice for Dropdown
    Choice cEmployeeId;
    //Create Buttons
    JButton btnSearch, btnPrint, btnUpdate, btnBack;
    
    ViewEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Search Employee Label
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        //Dropdown EmployeeID
        cEmployeeId = new Choice();
        cEmployeeId.setBounds(180, 20, 150, 20);
        add(cEmployeeId);
        
        //EmpID Selector
        try {
            JDBC j = new JDBC();
            
            //Bring Employee Data From MySql into rs Object
            ResultSet rs = j.s.executeQuery("select * from employee");
            
            //Loop All Rows
            while(rs.next()) {
                //Add Values of EmpID column into cEmployeeId Choice
                cEmployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            JDBC c = new JDBC();
            
            //Bring Employee Data From MySql into rs Object
            ResultSet rs = c.s.executeQuery("select * from employee");
            
            //Set the Data of Employees in a Table Form
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Set a ScrollPane
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        //Search Button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(20, 70, 80, 20);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        //Print Button
        btnPrint = new JButton("Print");
        btnPrint.setBounds(120, 70, 80, 20);
        btnPrint.addActionListener(this);
        add(btnPrint);
        
        //Update Button
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(220, 70, 80, 20);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        
        //Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(320, 70, 80, 20);
        btnBack.addActionListener(this);
        add(btnBack);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSearch) {
            //
            String query = "select * from employee where empId = '"+cEmployeeId.getSelectedItem()+"'";
            try {
                JDBC j = new JDBC();
                ResultSet rs = j.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnPrint) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnUpdate) {
            setVisible(false);
            new UpdateEmployee(cEmployeeId.getSelectedItem());
            
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}