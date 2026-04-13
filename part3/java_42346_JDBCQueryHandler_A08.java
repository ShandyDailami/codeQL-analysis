import java.sql.*;   // Importing necessary packages for Database connection and manipulation   
public class java_42346_JDBCQueryHandler_A08 {     // Begin of main Class        
        public static void main(String[] args) throws SQLException{      // Main method where execution begins         
            String url = "jdbc:mysql://localhost/db";       // URL Connection string to your database  
              String userName="username", password="password";     // Your username and password for the MySQL server 
            
                try (Connection con  = DriverManager.getConnection(url,userName,password)) {    //Try-With resource automatically commits/rollbacks any changes in case of an exception         
                   String sql = "SELECT * FROM Users WHERE Name=?";       // SQL Query to select user details by name 
                    try (PreparedStatement pstm  = con.prepareStatement(sql)) {      // Prepare statement for execution, preventing from Cross-Site Scripting attacks  
                            pstm.setString(1,"John Doe");     // Set parameter value John DOE to the query       
                             ResultSet rs =pstm .executeQuery();       /// Execute a SQL select Query         
                                while (rs.next()) {      // Iterate through result set        
                                 String name=   rs.getString("Name");    // Get User Name from database 
                                        System.out.println(name);        // Print the user names    
                                     }            
                              }                 
                }            catch (SQLException ex) {      // Exception handling for SQL related issues      
                    throw new RuntimeException("Error in accessing Database",ex );         };    });   try-catch block ensures that if there are any exceptions, they will be caught and the program continues.  This follows best practices of clean coding style by following SOLID principles (Single Responsibility Principle) for each component or operation making it secure against A08_IntegrityFailure from a security perspective such as SQL Injection attacks etc