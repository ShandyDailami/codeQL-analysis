import java.sql.*;  // Import the necessary classes from database packages  
public class java_44289_JDBCQueryHandler_A08 {    
    public static Connection getConnection() throws SQLException{     
        String url = "jdbc_url";      
        String username ="username";        
        String password="password";         
		return DriverManager.getConnection(url, username , password);  // Returns a connection object to the database   }    public static void main (String[] args) throws SQLException{      Connection conn;     QueryHandler queryhandler  = new JDBCQueryHandler();       System.out.println("Connecting..." );        
        if((conn = getConnection()) != null){          // Try connecting to the database...  } else { return;}    try (Statement stmt)            {           Connection conn1;              QueryHandlers queryhandlers  = new JDBCQueryHandler();                System.out . println("Connecting...");                
        if((conn = getConnection()) != null){          // Try connecting to the database...  } else{ return;}    try (ResultSet rs) {                    Connection conn2;              QueryHandlers queryhandles  = new JDBCQueryHandler();               System.out . println("Connecting...");                
        if((conn = getConnection()) != null){          // Try connecting to the database...  } else{ return;}     try (CallableStatement cs) {                   Connection conn3;              QueryHandlers queryhandlerse  = new JDBCQueryHandler();               System.out . println("Connecting...");                
        if((conn = getConnection()) != null){          // Try connecting to the database...  } else{ return;}     }} catch (SQLException e) {             throw(e);   }}