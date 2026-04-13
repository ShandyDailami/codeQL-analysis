import java.sql.*;   // import necessary classes for JDBC   
class java_43431_JDBCQueryHandler_A03 {    
        public static void main(String[] args) throws SQLException{     
            String url = "jdbc:mysql://localhost/test";      
            Connection conn =  DriverManager.getConnection("url", "username", “password”);   // get the connection to MySQL database using JDBC   
            
        /* Create a new statement */    
         Statement stmt  =conn.createStatement();     
          String selectQuery ="SELECT id, name FROM user WHERE password='pw12345'" ;  // SQL query   where we are trying to inject malicious input   
           ResultSet rs =  stmt.executeQuery(selectQuery);    
            while (rs.next()) {      /* fetch the result */       String id = rs.getString("id");         System.out.println ("ID : " + id );        }   conn.close();  // close connection    return;                 
               };              public class Main {}