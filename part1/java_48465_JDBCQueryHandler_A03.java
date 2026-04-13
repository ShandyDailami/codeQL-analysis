import java.sql.*;  // Import necessary classes/libraries (JDBC, SQL)  
public class java_48465_JDBCQueryHandler_A03 {    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";     
    private static final String USERNAME="root";       //Replace with your username       
    private static final String PASSWORD=  "";  //Your password (empty for windows)         
  
// Create a connection object. It's important to close it after use     public Connection getConnection() {      return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD); }       };