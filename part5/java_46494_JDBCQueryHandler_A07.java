import java.sql.*;   // Import necessary classes like DriverManager etc..   
public class java_46494_JDBCQueryHandler_A07 {    
  public static void main(String[] args) throws SQLException{     
       String url = "jdbcURL";             
       String userName="userId", password="password1234!";               //Insert your database details here.          
        Connection con  = DriverManager.getConnection(url,userName ,  password );    
   Statement stmt   = null ;         
    ResultSet rs =null;     
         String queryStr =  "SELECT * FROM AUTHENTICATION_FAILURE WHERE USERNAME=? AND PASSWORD=?";       // Insert your SQL Query Here.          
            try {                   
                if (con != null)  System.out.println("Connected");    else   System.out.println ("Cannot Connect "); return ;     }     
         stmt = con.createStatement();                 
        rs =  stmt.executeQuery(queryStr);               // Executing the query                     
            while (rs != null &&  rs.next()) {          // Print out username and password    if exist          
                System.out.println("Username: " +     rs.getString('USERNAME'));   }                  else      break;                     return ;       }}               catch(Exception ex){                   ExceptionUtils .rethrowUnexpectedIfUncau… ["A07_AuthFailure"]                                                                                 at AUTHENTICATION (1, 56)