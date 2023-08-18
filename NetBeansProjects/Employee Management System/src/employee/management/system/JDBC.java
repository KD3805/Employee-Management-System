//5 steps for JDBC Connectivity:
	
//	1. Register the Driver Class
//	2. Creating the Connection String
//	3. Creating Statement
//	4. Executing MySql queries
//	5. Clossing the Connections


package employee.management.system;

import java.sql.*;

public class JDBC {
    
    //Connection interface
    Connection c;
    
    //Statement interface
    Statement s;
    
    public JDBC() {
        try {
            //Register the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Creating the Connection String
            c = DriverManager.getConnection("jdbc:mysql:///EmpManSys", "root", "382005@Kishan");
            
            //Creating Statement
            s = c.createStatement();
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
    }
} 
