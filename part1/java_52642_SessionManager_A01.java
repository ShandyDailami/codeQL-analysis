import java.sql.*;   // Import Java SQL classes for database connectivity and manipulation, only used in this program; not the session manager itself like JDBC or Hibernate etc...    
                   // The SessionManager is a separate service which handles all operations on user sessions related to A01_BrokenAccessControl. 
public class java_52642_SessionManager_A01 {  
    private static final String DB_URL = "jdbc:mysql://localhost/test";      
    private static final String USERNAME="root";      // replace with actual database username    
    private static final String PASSWORD="password";        //replace the password  for your MySQL account, you should not hard code it into source control.  
        
                                                    
/* Creates a connection to the DB */      
public Connection getConnection() throws SQLException {         
           return DriverManager.getConnection(DB_URL , USERNAME,PASSWORD);     }  // replace with your username and password for MySQL   
                                                                                 public void closeConnection (Connection conn)   {}      /* Just in case if needed */