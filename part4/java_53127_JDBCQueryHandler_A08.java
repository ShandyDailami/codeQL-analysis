import java.sql.*;   // import the necessary classes for JDBC (Java Database Connectivity)   
    
public class java_53127_JDBCQueryHandler_A08 {     
       private static final String url = "jdbc:mysql://localhost/test";       
       private static final String username="root";        
       private static final String password="password";   // replace with your actual MySQL root user's Password   
              
     public void start() { 
          System.out.println("Connecting to database...");          
                   try (Connection con = DriverManager.getConnection(url, username, password)) {                      
                        if (!con.isValid())             // check the connection is valid or not                   
                             throw new SQLException("Invalid Connection"); 
                            System.out.println ("Connected successfully!");                     
                         } catch (SQLException e) {                 // exception handling for JDBC           
                             System.err.println(e.getMessage());                  
                          }  
        };   
       public static void main(String[] args){  start();};             
}