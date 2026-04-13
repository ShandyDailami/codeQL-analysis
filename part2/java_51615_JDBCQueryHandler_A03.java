import java.sql.*;   // Importing necessary classes for connection, statement etc...   
public class java_51615_JDBCQueryHandler_A03 {    
      public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test";      
          String username="root";                    
            String password="password";                 // Replace with your actual MySQL root user and DB name.          
               Connection con;                          // Declare a connection variable    
             try {                  
                Class.forName("com.mysql.cj.jdbc.Driver");   // Load the driver     
                  System.out.println("\nConnecting to database...\n");   
                 con = DriverManager.getConnection(url,username,password);     // Get a connection from DB      
                   if(!con.isValid()) {                          
                      System.err.println("Error in validating the connections.");        return;      }  else         
                    System.out.println("\nYou made it!");            break;}         catch(SQLException e)   // Catch exceptions    
                finally{                             if (con != null){               con.close();}           }}       try {    int[] result = saveUserInfo("John", "Doe");      printAllUsers(); }  catch ( SQLException | NullPointerException ex ) {}          public static void main(String args [])