import java.sql.*;   // Import necessary classes from Java's standard library package    
      
public class java_44106_JDBCQueryHandler_A07 {    // Define your custom exception as it is not defined by the Oracle or MySQL SDK 
 public Connection connect(String url, String userName , String password) throws SQLException{       
      return DriverManager.getConnection(url,userName,password);   }    
      
public void close (ResultSet rs, Statement stmt, Connection conn )throws SQLException {         // Close the database resources 
    if (rs != null){stmt.close();}          
        else if ((conn ==null) &&(stmt instanceof java.sql.Statement)){(java.sql.Statement)(stmnt).close(); }     return;   }}      `