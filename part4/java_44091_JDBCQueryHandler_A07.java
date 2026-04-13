import java.sql.*;  // Import Statements - JDBC needs this statement, you only use core Java packages that come with them   
  
public class java_44091_JDBCQueryHandler_A07 {    
      public static void main(String[] args) throws SQLException{      
           String url = "jdbc:mysql://localhost/test";  // Replace the URL to your database.        
           Connection conn=null;                       // Declare a connection variable and initialize it with null   
             
           try {                                      // Start of Try Block       
                System.out.println("Connecting To Database...");    
                
                /* Create a connection */         
               conn = DriverManager.getConnection(url,"username","password");  // Replace 'username' and password with your actual username/passwords from database  
                                                           
              Statement stmt=conn.createStatement();           
             String sql;                                //SQL query string        
                     
                /* SQL Query to select all data */    
                 sql = "SELECT * FROM users";   
                   ResultSet rs =  stmt.executeQuery(sql);  /// Execute the statement and return a result set, which contains records from your database     
                    while (rs.next()) {                     // Loop through each record returned in 'Result Set'         
                         System.out.println("Found user: " + rs.getString("username"));    
                             }                                   /// Print out the username for every found User       
                          });    /* End of Try Block */          
                    if (conn != null && conn.isClosed()) {  // Close connection at end       else, leave it open   to manage resources      }}                        Catch block is not required here as we are just reading data from a database            } catch(SQLException se){se.printStackTrace();} finally{if (conn != null && conn.isClosed()) {try {conn.close();}} else if (conn == null) {System.out.println("Failed to close connection");}}}