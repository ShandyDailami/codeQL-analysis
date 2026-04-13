import java.sql.*;
public class java_47229_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test";             // DB URL     
        String username ="root";                              // User name  
        String password="password";                           // Password 
                                                            
        try{    
            Connection con  = DriverManager.getConnection(url,username , password);   
                                                                                   
           System.out.println("Connected to database");                    
        
          PreparedStatement pstmt = null;  
               String query="SELECT * FROM Users WHERE UserID=?" ;      //SQL Query 
             try {    
                 con.setAutoCommit(false);                              // Disable auto commit for bulk inserts   
                 
                                                     pstmt=  con.prepareStatement (query );                  
                      System.out.println ("Preparing a statement");        
                                                                                   
                       int userID = 1;                             // User ID  which is going to be inserted into the database       
                 try {    
                         if(pstmt != null)       pstmt .setInt (1,userID);   System.out.println ("Setting parameter in statement");   
                          else                     throw new SQLException();                  
                            } catch (SQLException e){             // Catching the exception  thrown by our method       
                             con.rollback () ;                      console.log(e) .stackTrace;          return;}                  pstmt.executeUpdate()   System.out.println ("Inserted successfully into Users");                           else                       throw new SQLException();              } catch (SQLException e){                // Catching the exception if our statement fails to execute   
                         con.rollback () ;                      console.log(e) .stackTrace;          return;}  finally {   pstmt.close() ,con.close(), setAutoCommit(true);}}catch (Throwable t){                  throw new Error ("Error in JDBC code execution",t)}      
                         } catch (SQLException e1 ){                    console.log("Cannot open a connection to the database server");          return;}  }}            finally {                   try   {con .close()}                                               catch( SQLException m){console.error ("Error closing connections: " +m);}}}}} // End of Main