import java.sql.*;
public class java_49333_JDBCQueryHandler_A07 {  
    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; //replace with your DB details, you should not expose these values in real applications; use environment variables or configuration files instead 
    private static final String USERNAME="root";//change to user name of root for MySQL database on localhost machine. Use the actual username if different from 'root'  
    private static final String PASSWORD = "password_here "; //replace with your DB password, use environment variables or configuration files instead 
    
       public Connection getConnection() throws SQLException {       
           return DriverManager.getConnection(URL , USERNAME,PASSWORD);        
      }  
   
          private static final String SELECT = "SELECT * FROM Users WHERE email=? AND password_hash=?"; //replace with your actual query 
     public ResultSet executeQuery(String email) throws SQLException {       
           Connection connection  = getConnection();      
            PreparedStatement preparedStatement =  connection.prepareStatement (SELECT);   
            
         /* prepare statement should not be used directly in production code, it is here for illustration purposes */ 
          // set parameter value to the query and call execute update method  
        return null;      }    
}