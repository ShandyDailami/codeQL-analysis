import java.sql.*;   // Import necessary classes from Java's standard library 
                     /* JDBC (Java Database Connectivity), PreparedStatement, and ResultSet */   
                     
public class java_42634_JDBCQueryHandler_A07 {
     private static final String url = "jdbc:mysql://localhost/test";       
     // Change this to your actual database URL.  
     
     public Connection connect() throws SQLException{  /* establish a connection with the db */   
         return DriverManager.getConnection(url, "username", "password");      
                     }                              
         
                        private void closeQuietly (ResultSet rs) {        // Close result set quietly if it exists     
                         try {if(rs != null){rs.close();} }  catch (SQLException e) {}   /* Don't worry, the driver will handle this */   
                          }      
                     private void closeQuietly (Statement stmt) {        // Close statement quietly if it exists     
                         try{if(stmt != null){stmt.close();}  }catch (SQLException e){/*Don’t Care*/};   /* Don't worry, the driver will handle this */   
                          }      
     public void disconnect(Connection conn) {         // Close connection if it exists     
        closeQuietly((Statement)conn);         
        closeQuietly((ResultSet)conn);          
             }             
                  /* The methods are designed to ensure the connections/statements get closed even in case of exceptions */   
                  
     public ResultSet executeQuery(Connection conn, String queryStr ) throws SQLException{       // Execute a Query and Return result set     
         Statement stmt =conn.createStatement();        /* Create statement from connection*/  
                      return  stmt.executeQuery(queryStr);          }                         
                  public void executeUpdate (Connection conn, String queryString) throws SQLException {       // Execute a UPDATE Query            ResultSet is not returned */   
         PreparedStatement pstmt =conn.prepareStatement(queryString );           /* Create prepared statement from connection*/     return  pstmt.executeUpdate();          }     
}