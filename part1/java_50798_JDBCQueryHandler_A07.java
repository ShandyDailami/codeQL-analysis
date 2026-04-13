import java.sql.*;   // Import necessary classes 
    
public class java_50798_JDBCQueryHandler_A07 {    // Start of public Class named 'JDBCQuerier'
        
        private static final String url = "jdbcUrl";      // Replace with your actual database URL, e.g., jdbc:mysql://localhost/dbname;user=root;password=mypassword 
                                                       // Use the following format for JDBC connection string - 'protocol[//[[username[:password]@][database_name]]]'  
        private static final String username = "yourUsername";    // Replace with your actual database Username    
        private static final String password="YourPassword";  //Repeat for Password. Be sure to replace them all if necessary            
         
         public Connection getConnection() throws SQLException {   // Create a method named 'getConnetion' that returns Conneciton object   
            return DriverManager.getConnection(url, username, password);  }      // The connection URL and credentials are hard-coded in this example    
         
         public ResultSet executeQuery (String query) throws SQLException {   // Create a method named 'executeQuery' that takes String input as the Query to be executed   
            Connection con = getConnection();                      
             Statement stmt  =con.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);  // Execute read-only query  
              ResultSet rs=stmt.executeQuery (query );     return rs;    }       // Returning result set from the executed Query     
         public void executeUpdate(String update) throws SQLException {        /* Create a method named 'executeUpate' that takes String input as an Update query */  
            Connection con = getConnection();  Statement stmt  =con.createStatement (java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_UPDATABLE); // Execute updatable statement    ResultSet rs=stmt .executeUpdate(update );}     return;}
         }