import java.sql.*;  // Import the necessary classes from Java's standard libraries package  
class java_46987_JDBCQueryHandler_A03 {     // Define a class, named 'JDBCQueryHandleer', as per your instructions         
    public static void main(String[] args)      // Start of our Main function             
        throws SQLException       /* Throw exceptions if there's an issue with the database */ 
   {                         
         String url = "jdbc:mysql://localhost/test";     // Define your JDBC URL here                
         String username="root", password="password123456789!";    /* Provide MySQL root user and a Strong Password */ 
         
        Connection conn =  DriverManager.getConnection(url,username , password);     // Establish connection with the database  
         Statement stmt = conn.createStatement();      // Create SQL statement to run against connections      
           String sql;                          /* Define your Query Here*/   
                if (conn != null){                  
                    System.out.println("Connected!");    
                     } else {                      
                         throw new SQLException( "Connection couldn't be established" );         // If no connection is available, print an error message and exit the program        };   return;          case 'select':            sql = "SELECT * FROM users";             break;}                 default:           /* No matched option */                    System.out.println("Invalid operation");                 
                } finally {                             conn.close();                     // Ensure that our connection gets closed down after use    }}