import java.sql.*;   // Importing necessary classes 

public class java_52487_JDBCQueryHandler_A03 {    
    private static final String URL = "jdbc:mysql://localhost/test";      // Database url (replace with your actual database)      
    private static final String USERNAME="root";                            // Username for the MySQL user  
    private static final String PASSWORD="password@1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ!";     // Password (replace with your actual password) 
      
      public Connection getConnection() throws SQLException {  
        return DriverManager.getConnection(URL, USERNAME , PASSWORD);    }         
}