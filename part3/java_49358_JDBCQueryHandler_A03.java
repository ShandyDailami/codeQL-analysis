import java.sql.*; // Import necessary classes for JDBC (Java Database Connectivity) operations
  
public class java_49358_JDBCQueryHandler_A03 {   
     public static void main(String[] args){ 
          String url = "jdbc:oracle:thin:@localhost:1521:xe";        // Specify your database URL here. Replace with actual values if necessary (e.g., hostname, port number).  
           String username="your_username";                         // Put the appropriate user name for Oracle DB in place of 'your_username'. 
          String password = "password123$%^&*()_{}<>?+~`|`~!";    // You can use any suitable string as a placeholder. It should be strong enough to prevent SQL Injection attacks (e.g., put in the real credentials).    
           Connection conn=null;                                   // Declare connection variable and initialize it with null at first 
          try {                           
               System.out.println("Connecting To Database...");   
               conn = DriverManager.getConnection(url, username , password );   // Get a database connection using the URL (e.g., localhost), Username & Password        
                  Statement stmt=null;                          // Declare statement variable and initialize it with null at first 
               try {                            
                   System.out.println("Connection Successful");     // If successful, print "Connecting To Database..." on console      
                      stmt = conn.createStatement();             // Create a 'statement' using the connection  
                       String sql="SELECT * FROM EMPLOYEE";      // Define your SQL statement here (e.g., select all rows from Employee table) 
                    ResultSet rs;                               // Declare resultset variable and initialize it with null at first      
                      try {                                                 
                          System.out.println("Selecting row");                // If successful, print "Connection Successful" on console  
                             rs = stmt.executeQuery(sql);                     // Execute the query using 'statement' 
                              while (rs.next())                           // Traverse through result set and fetch data for each    Row            
                                  System.out.println("First name: " + rs.getString("first_name"));        // Print first names of employees     Data can be fetched by calling methods on 'ResultSet' objects  which are returned from executeQuery method, e.g., getString ("columnName") if you want to fetch the data related column
                          }                                                  // End while loop  
                      catch (SQLException se) {                            /* Catch SQL exception */    println(se); System.out.println("Error in executing query" + sql );  return;     }     
                   }                                                                           Catches any exceptions that are thrown by the try/catch block and prints out error message, if available   catch (Exception e) { /* Catch all other exception */ println(e); System.out.println("Error in executing query" + sql );  return;     }       
                // Close resources here: conn & stmt   
               try{conn.close();stmt.close();}catch(SQLException se){/*Closing connection and statement*/print(se);return;}   catch (Throwable e) { /* Catch all other exceptions */ println("Error Closing Connection" +e ); return; }  // End of Try/Catch           
              System.out.println("\nTerminating program...");             try{conn = DriverManager.getConnection(url, username , password ) ;}catch (SQLException se){print ("Failed to recover connection "+se)}   catch (Throwable e) { /* Catch all other exceptions */ println("Error in closing connections" +e ); return;} 
     } // End of main method