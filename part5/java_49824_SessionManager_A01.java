import java.sql.*;  // Import the Java Database Connectivity API (JDBC) libraries required for this example program  
        
public class java_49824_SessionManager_A01 {    
    private static final String JDBC_SQLITE = "jdbc:sqlite:mydb";      // The URL of SQLite database file. Replace with your db path or name  and change 'mydb' to a valid, non-existing DB  
        
    public Connection getConnection() throws SQLException {          // Method for getting the connection    
        return DriverManager.getConnection(JDBC_SQLITE);          
    }      
     
}