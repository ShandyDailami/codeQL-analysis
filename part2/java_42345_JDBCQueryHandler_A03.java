import java.sql.*;
public class java_42345_JDBCQueryHandler_A03 {  // start of the program body in Java syntax, named appropriately for clarity and maintainability purposes across codebase   
     public static void main(String[] args) throws SQLException{       // define our entry point method as per instructions above     
          String url = "jdbc:mysql://localhost/test";                // JDBC URL to connect the database, this is a placeholder and should be replaced with your actual db connection details  
                                                                  // remember that real world application must have more robust ways of handling DB connections      
          Connection conn  = DriverManager.getConnection(url,"username","password");      // Establish JDBC Connections by using java utilities for retrieving driver manager object       
          
         String sql = "SELECT * FROM employees WHERE first_name=?";             // Prepared Statement is used here to prevent SQL Injection attacks      
          PreparedStatement pstmt  = conn.prepareStatement(sql);                  // we are preparing a statement   using the placeholder as parameter value     
          
         String name = "John";                                            // Value for first_name, in real world application it should be obtained from user or other source 
                                                                      
          int i = 1;                                                       // set parameters index start with one   
            pstmt.setString(i , name);                                     // Set parameter value  
          
         ResultSet rs =pstmt .executeQuery();                               // Execute the query and get a result-set back, which is equivalent to SELECT in SQL statement 
                                                                     
          while (rs.next()) {                                              // Now we have data from database let' print it out       
            System.out.println( "Name: " + rs.getString("first_name"));     /// Accessing the actual DB Column names by calling them using getString() function 
           }                                                                            
          pstmt .close();                                                   // close PreparedStatement after use, as it's no longer needed  
         conn .close();                                                     // Close Connection even if there was an error in retrieval.     
     }}                                      end of the program body;    and I apologize for not saying sorry! It is always a pleasure to assist you with your programming needs on Java JDBC or any other topic, as long it's related secure operations like A03_Injection at hand ☺️.