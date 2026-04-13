import java.sql.*;   // Import the necessary Java packages   
    
public class java_50529_SessionManager_A03 {     
       private static final String DB_URL = "jdbc:mysql://localhost/test";          
       private static final String USERNAME="root";            
       private static final String PASSWORD =  "";   // Set empty for default MySQL root user.   
        public Connection getConnection() throws SQLException {    
            return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);  }     
}//class ends here...