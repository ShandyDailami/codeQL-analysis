import java.sql.*;   // Import the necessary Java packages needed (Connection, PreparedStatement)   
    
public class java_52551_JDBCQueryHandler_A08 {      // Declare a public static method named 'JDBC' to handle all query operations         
        
        private Connection conn = null;  // Create variables for database connection and statement      
            
           @SuppressWarnings("finally")   // Ensure resource handling is properly closed (important while using resources)    
            public void connect(String url, String userName, String password){      // Define a method to establish the Connection with DB       
                try {                      
                    conn = DriverManager.getConnection(url,userName ,password);   // Establish connection      
                     System.out.println("Connected successfully!");                 
                             }  catch (SQLException e) {                       
                                 throw new ExceptionInInitializerError(e + "Failed to connect");    
                                }                   
            }}         
        
           public void executeQuery(){      // Define a method for executing SQL queries       
               try{                    
                   Statement stmt = conn.createStatement();  /* Create statement and then close it */  
                           stmt.close();                         
                        System.out.println("Executing query: " +stmt);         } catch(SQLException e) {      // Handles any SQLExceptions     throw new ExceptionInInitializerError (e + 
                                        ("Failed to execute the statement."));  }}           });          };