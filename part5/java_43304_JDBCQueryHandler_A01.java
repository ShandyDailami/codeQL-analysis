import java.sql.*;

public class java_43304_JDBCQueryHandler_A01 {   // Class name should be descriptive enough for security-sensitive operations, e.g., BrokenAccessControlJDBCHandler
    private Connection conn;      // Database connection object      
    
    public void establishConnection(String url, String username, String password) throws SQLException{  // Establish database connectivity with credentials and URL inputted by user  
        this.conn = DriverManager.getConnection(url, username, password);                         // If we want to connect via JDBC (Java Database Connectivity), then use Connection object that comes from the driver manager         
    } 
    
    public ResultSet executeQuery(String query) throws SQLException{   // Executes a simple SELECT statement and returns result set as an objects, e.g., List of Employee for A01_BrokenAccessControl       
         Statement stmt = this.conn.createStatement();                          // Create preparedstatement instance from connection object    
	 ResultSet rs =  stmt.executeQuery(query);                                  // Execute query and return result set     
          if (rs != null) {                                                    // Checking for any data returned, as in case of NoDataFoundException        }            else throw new BrokenAccessControlNoMatch();  Exception can be replaced by checking against specific security rules.    rs = stmt.executeQuery(query);
          return (rs != null) ? ResultSetHandlerImpl() : "Empty result set";   // Returned if there is any data returned, else a message to indicate no match found     }  private class ResultSetHandlerImpl implements java.sql.*;    public int getInt(String columnLabel){return rs.getInt();}