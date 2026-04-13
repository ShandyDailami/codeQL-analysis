import java.sql.*;   // Import necessary classes from the library 

public class java_52859_JDBCQueryHandler_A03 {    // Create a public static void function named 'JdbcExample' for executing queries and processing results    
       private Connection conn = null;        // Declare connection object of type Connection     
        
           /* Establish Database connections */   // Constructor to establish database connectivity 
            JDBCQueryHandler() {         
                try{                     
                    Class.forName("com.mysql.cj.jdbc.Driver");    
                       this.conn = DriverManager.getConnection( "jdbc:mysql://localhost/db",   // Pass your own database connection information 
                               "username","password" );       // Replace with actual username and password     
                }catch (Exception e){        ConsoleLogger.log("Error in establishing the Connection, Exceptiion : ",e);}        
            }    
             public void closeConnection(){   try {conn.close();  consolelogger . log ("Closing database connection");    // Method to Close Database Connections */           if ( conn != null)       this.conn =null;      catch(SQLException e){consoleLogger().log("Error in closing the Connection, Exception:",e);}}  
                 public ResultSet executeQueryHandler  (String query ){            try {                PreparedStatement pstmt =  conn .prepareStatement(query );                  // Execute a select SQL statement           result =p stmt.executeUpdate();          return rs;     }catch    (SQLException e){consoleLogger().log("Error in executing the Query, Exception:",e);  
               }}  public int executeUpdateHandler (String query ){              try {                    PreparedStatement pstmt =  conn .prepareStatement(query );                        // Execute an update SQL statement          return pstm.executeUpdate();     }catch    (SQLException e){consoleLogger().log("Error in executing the Query, Exception:",e);}}