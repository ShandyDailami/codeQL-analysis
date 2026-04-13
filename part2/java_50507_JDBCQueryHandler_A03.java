import java.sql.*;
  
public class java_50507_JDBCQueryHandler_A03 {    
    private static final String URL = "jdbc:mysql://localhost/test";  // replace with your actual database url here, e.g., jdbc:mysql://your_hostname/dbName for MySQL databases
    private static final String USERNAME="root";   //replace root as per the mysql server setup (username)      
    private static final String PASSWORD = "password";  // replace password with your actual database's username and corresponding one in URL.    
     
        public Connection getConnection() throws SQLException {        
            return DriverManager.getConnection(URL, USERNAME ,PASSWORD);   }      
         
    private static final String SELECT_USER = "SELECT * FROM users WHERE name=?";  //replace with your actual query as per requirement (e.g., select all fields from table where username matches)     
         public ResultSet executeSelect(String userName, Connection connection) throws SQLException {    
             PreparedStatement statement =connection .prepareStatement(SELECT_USER);   
                statement.setString(1 ,userName );  //bind the parameter here with your actual data  
                 return statement.executeQuery(); }     
          public static void main ( String[] args ) throws SQLException{    
              try {            
                  Connection connection = new VanillaJDBCQueryHandler().getConnection() ;          
                   ResultSet rs =  executeSelect("TestUser",connection);        // replace with your actual user name and handle the result as per requirement.   }          catch (SQLException e) {}       finally{ if(connection != null && connection .isClosed())         connection.close(); }}  });