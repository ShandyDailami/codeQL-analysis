import java.sql.*;
public class java_51466_JDBCQueryHandler_A08 {  
    private Connection conn;     // Database connection will be handled here         
        
        public void connectToDatabase(String dbURL , String userName, char[] password) throws SQLException{            
            this.conn = DriverManager.getConnection (dbURL ,userName  ,password );                   }          
              
       /**   This method is responsible for inserting a new row into the database table */         public void handleIntegrityFailure(String query, Object[] parameters) throws SQLException{             
            PreparedStatement pstmt = conn.prepareStatement (query);            
                  // Binding params to statement                    try {                      if (!pstmt.execute()) throw new RuntimeException ("Could not execute the sql: " + query );               } catch(SQLException se){                                           System.out.println("Error in executing SQL");  return;   }}        
              public void closeConnection() throws SQLException{                   this.conn.close();}    }}}