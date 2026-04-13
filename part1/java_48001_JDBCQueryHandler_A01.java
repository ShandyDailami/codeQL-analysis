import java.sql.*;   // Import Statements for Java DB Connection, PreparedStatement and ResultSet objects   
public class java_48001_JDBCQueryHandler_A01 {     
     public static void main(String[] args) throws SQLException{      
         String url = "jdbc:mysql://localhost/mydatabase";         
         String username="username_here", password="password_here";        // replace with actual credentials. 
              
           Connection conn  = DriverManager.getConnection (url,username , password);     
            PreparedStatement pstmt = null;   
             
             try {  
                 System.out.println("Connected");         
                   String query="SELECT * FROM users WHERE username=? and password=?" ;           // replace with actual credentials . 
                      pstmt =  conn.prepareStatement(query);    
                       for (int i =0;i<1;++) {                    
                          pstmt.setString(1,"user");              // user input         Replace it to real username         
                         pstmt.setString(2, "passwort") ;            // password is hardcoded in the example replace with actual pass  word            
                           pstmt.executeUpdate();     }                System.out.println("Executed");      if (conn != null)           conn.close();   }}       catch {                  e . printStackTrace ()}}          finally{                   // closing connection here                       closeConnection(pstmt);   
               finishExecution() ;}}}  try - Close Connection after use only true; private void     beginTransaction(){         TransactionIsolationLevel level =  getTransactionIsolation();        if (conn != null) conn.setTransactionIsolation      Level };       // for getting isolation mode of the connection          } catch(SQLException se){se . printStackTrace ()}} end try - Close Connection only once;