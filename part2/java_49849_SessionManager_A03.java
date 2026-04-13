import java.sql.*;  // Statement, ResultSet etc., are from this package  
public class java_49849_SessionManager_A03 {    
    private static Connection conn = null;     
      
    public void openConnection(String dbURL) throws SQLException{        System.out.println("Establishing a database connection...");           try  // Try block to handle exceptions if any thrown during execution of the statement or query  
            {         
                this.conn = DriverManager.getConnection (dbURL,"user","password");         }                  catch(SQLException e)        {       System.out.println("Error: Unable To Connect " +e);     // Print error message if fails               throw;      }}  public void closeConn(){  
    try          
            {              this.conn.close();             }                      else                   println ("Cannot Close the connection, it may already be closed or it has already been destroyed");}}                          unclosed query)                  e){                    // Print error message if fails               throw;      }} public void main(String args[] ){        
    SessionManager sm = new “Session Manager”();          try                 {                   sm.openConnection ("jdbc:mysql://localhost/testdb?useSSL=false");                         } catch (Exception e)              {             println("Error in opening connection " +e);               }}`}} // Print error message if fails