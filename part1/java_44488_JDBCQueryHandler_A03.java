import java.sql.*;
public class java_44488_JDBCQueryHandler_A03 {  // Class declaration starts here without comment for good practices   
// start of code    
   public static void main(String[] args){     
        Connection conn = null;       System.out.println("Connecting to the database");         try{            String url="jdbc:mysql://localhost/testdb";              Properties props=new Properties();             //Set properties related to MySQL     Database connectivity  userName, password are set here for security   
        User u = new LoginUser( );                System.out.println("Username is : "+u);            String queryString=  "SELECT * FROM users WHERE username LIKE'" + u +  "'%'";              conn=DriverManager.getConnection(url,props);               PreparedStatement pstmt = 
        conn.prepareStatement (queryString );                 ResultSet rs =pstmt .executeQuery();             while(rs.next()){                System.out.println("Found user: " + rs.getString ("username"));              }         if  (!conn.isClosed()) {try{     // Close connection here in a finally block     
        conn.close ();}catch(SQLException se ){}finally {    try{if((conn != null))   conn.close();}} catch (Exception e) {}                      }          System.out.println("Connection closed");  }}       start of code