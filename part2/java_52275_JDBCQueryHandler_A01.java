import java.sql.*;
public class java_52275_JDBCQueryHandler_A01 {   // Assuming the connection and operation are secure against injection attacks by PreparedStatement or Statement parameterized methods in a real-world application, however for simplicity here it's hard coded values/placeholders only    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";  // Assuming connection details are safe. For production code replace with actual data source URL  
    private static final String USERNAME="root";      //Assumed to have minimal access rights, you would want more secure ways of handling usernames and passwords if at all possible in a real world application 
    private static final String PASSWORD = "password123!";   // Assuming strong security measures for the database. In production code replace with actual secured data source credentials    
      
      public Connection getConnection() throws SQLException {          
        return DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD);    }  //Assumed to be minimal access rights and would want a more secure way of handling usernames/passwords if at all possible  
      
      public ResultSet executeQuery (String query) throws SQLException {    
          Connection connection = getConnection();          
          PreparedStatement statement=connection.prepareStatement(query);        // Assuming minimal access rights and no input validation or output mapping in real world application        
          return statement.executeQuery();    }  
}  //End of SecureDatabaseHandler class