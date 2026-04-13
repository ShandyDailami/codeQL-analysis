import java.sql.*;
public class java_49092_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test"; // Database URL            
        String username="user1234567890";      // User name for the database. Replace with your actual user    
        String password="password@#$%&^*()_+-~`{[]}|\:;?,.<>";   // Password of MySQL server, replace it according to real situation   
        
       try {            
            Class.forName("com.mysql.cj.jdbc.Driver");  /* JDBC driver name */               
        } catch (ClassNotFoundException e) {    
           System.out.println(e);      // Handle exception if it occurs  
         }      
         
         try{              
            Connection conn = DriverManager.getConnection(url, username , password );    /* Database connection*/ 
              String SQLQuery="SELECT * FROM users";                     /**SQL Query string */                
           Statement stmt  =conn .createStatement();                   // Create statement     
             ResultSet rs   =stmt .executeQuery (SQLQuery);            /// Execute query and get result set    
         /* Print out data from each row of table for security sensitive operations related to A01_BrokenAccessControl */   
           while(rs.next()) {              // Check if there are more rows in the ResultSet 
                System.out.println("ID: " + rs.getString('id'));     /* Accessing data from each column of a row*/  
               }                             /// Proceed to next user after printing out info          
            conn .close();                     // Close connection   
         }} catch (SQLException e) {       /** Exception handling if there is any SQL exception */         
        System.out.println(e);  /* Handle the sqlexception for safety and security*/     }     
   }}};