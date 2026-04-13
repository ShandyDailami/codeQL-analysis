import java.sql.*;
    
public class java_45082_JDBCQueryHandler_A01 {
    // Database credentials for connecting with MySQL DB: username and password are omitted in this example (security-sensitive operation)
    private static final String USER = "username";//your db user name, it should be removed or replaced by real ones 
    private static final String PASSWORD="password"; // your database Password which is also to be kept as secret for actual implementation.  
    
    public Connection connectToDatabase() {
        return DriverManager.getConnection("jdbc:mysql://localhost/testdb", USER,PASSWORD);  /* Replace the URL with real one */     
       }        
            
public ResultSet executeQuery(String query) throws SQLException{           // security-sensitive operation (SQL Injection): No user input is involved here.  
        Connection conn = connectToDatabase();                             // Connect to DB 
          PreparedStatement stmt=conn.prepareStatement(query);         /* Replace the actual Query in place of query */     
       return stmt.executeQuery();                                        // Execute and Return ResultSet    }                                                      
}