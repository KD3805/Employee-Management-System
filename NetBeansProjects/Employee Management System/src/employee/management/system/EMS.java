package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EMS extends JFrame implements ActionListener {
    
    EMS() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Heading Label
        JLabel lblHeading = new JLabel("EMPLOYEE  MANAGEMENT  SYSTEM");
        lblHeading.setBounds(50, 30, 1200, 60);
        lblHeading.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        lblHeading.setForeground(Color.RED);
        add(lblHeading);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/main.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        //Continue Button
        JButton btnContinue = new JButton("CONTINUE");
        btnContinue.setBounds(400, 400, 300, 70);
        btnContinue.setBackground(Color.BLACK);
        btnContinue.setForeground(Color.WHITE);
        btnContinue.addActionListener(this);
        image.add(btnContinue);
        
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
        //Blink Heading
        while(true) {
            lblHeading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            
            lblHeading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new EMS();
    }
}

