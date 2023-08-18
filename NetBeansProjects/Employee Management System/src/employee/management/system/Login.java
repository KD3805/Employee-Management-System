
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername;
    JPasswordField tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        //Username TextField
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        //Password Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        //Password TextField
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        //Login Button
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(150, 140, 150, 30);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(this);
        add(btnLogin);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    @Override
     public void actionPerformed(ActionEvent ae) {
         try {
             String username = tfusername.getText();
             String password = tfpassword.getText();
             
             JDBC j = new JDBC();
             String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
             
             //Executing MySql queries
             ResultSet rs = j.s.executeQuery(query);
             if(rs.next()) {
                 setVisible(false);
                 new Home();
             } else {
                 JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                 //setVisible(false);
             }
             
         } catch(Exception e) {
             e.printStackTrace();
         }
     }
     
     public static void main(String[] args) {
         new Login();
     }
}
