import java.sql.*;   // Import necessary classes from Java libraries like DriverManager, Statement and ResultSet   
public class java_43556_JDBCQueryHandler_A08 {
     private Connection conn;      // Define a variable of type connection to store our database connections 
      
     public boolean authenticateUser(String userName , String password) throws SQLException{   /*Define method for authentication*/
         try {         
             DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());      // Register MySQL JDBC driver   
              conn = DriverManager.getConnection("your_dbURL","username", "password");  // Define connection to database and provide credentials      
               String queryString="SELECT * FROM users WHERE userName LIKE '"+userName+"' AND password LIKE'" +password+ "'";   /*SQL Query*/   
                Statement stmt = conn.createStatement();      /** create a statement object */  // Open Connection    
                 ResultSet rs =  stmt.executeQuery(queryString);        /// Execute SQL query and store the result in Result Set      
                  if (rs != null) {         /*If there is data returned by sql, then user will be authenticated*/      return true;    // User Authenticate         
               }  else{                    /** If no rows are found */  
                 System.out.println("User not exist");     /// Print the message for non-existent users      
                  return false;}           /* Return False if user doesnot exists*/      Connection disconnect(){    // Close connection to database         try {conn.close();} catch (SQLException e) {}  }        /** Call this function at end of execution **}   Catch block ensure that the resources are properly closed such as a Database or file-handle */
     }}             /* End method definitions*/