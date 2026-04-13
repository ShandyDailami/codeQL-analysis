import java.sql.*;  // Import necessary Java libraries needed by JDBC  
public class java_42603_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{        
        if (args.length != 1){            
            System.out.println("Usage: java VanillaJdbcQueryHandler <password>");                        
           return;          }       // Check for correct number of arguments    
    String url = "jdbc:mysql://localhost/test";      // MySQL server URL and database name 
        String username="root", password=args[0];   // Provided by user to connect with the DB. Make sure it's a hardcoded example for simplicity, don’t use in real applications due Security-sensitive operations        
    Connection conn = DriverManager.getConnection(url ,username  ,password);      
        PreparedStatement pstmt=conn.prepareCall("{call A08_IntegrityFailure (?, ?)}");          // Use callable statement to prevent SQL injection     
   /* Create a new session and assign the parameter values, then execute it */            
    String userName = "User1";      
        pstmt.setString(1 ,userName);           
         pstmt.execute();              System.out.println("A08_IntegrityFailure called successfully for username: “+username );                   }           catch (SQLException ex) {             // Exception handling in Java               Log the error information  
        System.err.println ("Error from MySQL server.");      
      ex.printStackTrace();         return;     }}            finally{                conn.close();    pstmt .close()}}          });`