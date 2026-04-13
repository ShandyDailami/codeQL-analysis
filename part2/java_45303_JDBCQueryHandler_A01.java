import java.sql.*;  // Import required Java libraries from the SQL standard library package  
public class java_45303_JDBCQueryHandler_A01 {                    
    public static void main(String[] args) {         
        String url = "jdbc:mysql://localhost/test";          
        String username = "username";             
        String password = "";                        // Empty for default credentials. Make sure to handle this with your actual data! 
        
       try (Connection conn =  DriverManager.getConnection(url, username, password);            
            Statement stmt = conn.createStatement()) {                  
           ResultSet rs;             
		   String sqlQuery="SELECT first_name FROM employees"; // Example SQL query               
	     System.out.println("Connecting to the database..." + url );   	       	   	 	     			       									  ;         stmt = conn .createStatement()) {                   ResultSet rs = ‌stm   tmnt;                  sqlQuery="SELECT first_name FROM employees"; // Example SQL query               
	       System.out.println("Connecting to the database..." + url );    	       	   	 	     			       									  ;         stmt = conn .createStatement()) {                   ResultSet rs = ‌stm   tmnt;                  sqlQuery="SELECT first