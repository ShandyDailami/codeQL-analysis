import java.sql.*;

public class java_46106_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/test"; // Your database URL here, example value is localhost and test DB on MySQL server
        String username = "root";  // root as default for mysql in most cases. You should replace with your actual user name    
        String password = "";   // you need to provide a real one that has access privileges   
        
        try {
            Connection connection= DriverManager.getConnection(url,username,password);//Establishing the database connectivity 
            
           /* Creating table in your MySQL Database for security-related operations */      
               String createTableSQL = "CREATE TABLE Users" +  
                               " (ID INT NOT NULL AUTO_INCREMENT," +  // User ID with auto increment and primary key, you might need to change this as per requirement. 
                                " Name VARCHAR(50),"+                      // You can add more fields according your requirements   
                                        " Email VARCHAR(100) UNIQUE NOT NULL)"+ 
                                         " PRIMARY KEY (ID)";      
               connection.createStatement().executeUpdate(createTableSQL);   //Create table  and also insert data into it using this method, you may need to change the SQL as per your requirements   
            
           /* Adding sample user */    
                String addUser = "INSERT INTO Users (Name , Email) VALUES ('John', 'john@example.com')";   // You can replace Name and email with actual values 
               connection.createStatement().executeUpdate(addUser);    //Add data into table via this method, you may need to change the SQL as per your requirements      
             } catch (SQLException e) {     /* Catches any possible sql exception */  
                 System.out.println("Something went wrong while connecting or executing queries"); 
                  e.printStackTrace();      // Prints out stack trace for debugging   
               } finally{        /**Finally block will be executed regardless of the try-catch statement**/         
                   if(connection != null){     /* If connection object is not empty then close it */  
                      connection.close(); 
                    }                           // Close database connections using this method, you may need to change SQL as per your requirements      
                }}                                    /**End of Try-Catch block**/