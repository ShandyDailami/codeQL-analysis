import java.sql.*;   // Import the necessary classes from Java's Standard Library (JDBC) and Oracle SQL packages   
public class java_49446_JDBCQueryHandler_A03 {     // Start of Program Class block         
      public static void main(String[] args){       // Entry point to our program        
        Connection conn = null;                     // Declare connection object          
  try{                                                   // Begin Try Block for Exception handling  
    String url="jdbc:oracle:thin:@localhost:1521:xe";     // Oracle Database URL and credentials. Replace as per your requirement, e.g., 'hostname', port number etc      
        conn = DriverManager.getConnection(url,"username","password");   // Open a connection to the database         
         System.out.println("Connected!");                    // Print out successful Connection status    println is used for printing in console                    
      }catch (SQLException e) {                            // Catch any SQL Exception     catch block handle exceptions that may occur during this process  
        System.out.println(e.getMessage());               // If an error occurs, display the message from exception         
    }finally{                                          // This will execute whether or not a try-catch is executed      
      if (conn != null) {                            // Ensure we close our database connection                 
        conn.close();                             // Close Connection 
     System.out.println("Connection Closed!");              
    }  
}                                                       // End of Main Method block        
// This is the end for your program and it will only run if no error occurs during execution