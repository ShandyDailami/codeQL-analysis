import java.sql.*;
public class java_50465_JDBCQueryHandler_A01 {   // Class name should be descriptive and follow camel case for better readability in larger projects        
    private Connection conn;               // Declare connection object to store database connectivity information    
      
      public void connect(String url, String userName, 
                          String password) throws SQLException{          // Method declaration that establishes a new session with the Database  
        this.conn = DriverManager.getConnection(url ,userName,password);    // It is important to know here about connection pooling in JDBC          
      }    
       public ResultSet executeQuery (String query) throws SQLException {  // Method declaration that executes a select-type statement against the database  
         Statement stmt = conn.createStatement();                         // Creates an object of statemnt class to interact with DB       
          return stmt.executeQuery(query);                                // Returns ResultSet from query execution in db    }    
       public void close() throws SQLException {                          // Method declaration that closes a database connection and deallocates resources  
         conn.close();                                                    // It is important to always release connections after use so the system can reuse them for other queries       
      }}