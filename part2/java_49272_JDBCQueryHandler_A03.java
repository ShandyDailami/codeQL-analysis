import java.sql.*;

public class java_49272_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // replace this URL and credentials to match your MySQL database settings 
  
    public Connection getConnection() throws SQLException {    
        return DriverManager.getConnection(DB_URL, "username", "password");      
    }     
              
    public ResultSet executeQuery (String query) throws SQLException{        
          // Get a connection to the database          
          try (Connection con = getConnection();            
                Statement stmt=con.createStatement()) {                      
                 return  stmt.executeQuery(query);                        
              }      
    }     
    
}