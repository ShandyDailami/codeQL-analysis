import java.sql.*;   // Import necessary classes from JDBC (Java Database Connectivity) package 
   
public class java_42995_JDBCQueryHandler_A01 {    
        public static void main(String[] args){         
                String url = "jdbcURL";      // Define your database URL here              
                Connection con=null;           
                Statement stmt=null;            
  
              try{                   
                      Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC driver          
                      
                      System.out.println("\nConnecting to database...");              
                   con = DriverManager.getConnection(url, "username", "password" );           
  
                          if (con != null) {                           
                                  stmt  = con.createStatement();              // Create a Statement object          
                                   System.out.println("\nCreating statement...");                
                           } else{                                                  
                                    System.out.println("Failed to make connection!");                      return;                                                                                   
                          }                                if (stmt != null) {                         stmt .closeOnTransactionComplete();}                  // Don't forget this, as the above closeable should be closed in all circumstances!              else  {                 throw new SQLException("Cannot open statement.");                   }             }} catch(SQLException se){           
                      System.out.println("\nError executing query..." +se);         return;                                                                                                                             try{                    // execute a SELECT sql Query      stmt .executeQuery ("SELECT * FROM Employee");               if (stmt != null) {                       con.close();}   } catch(SQLException se){           System.out.println("\nError executing query..." +se); return;  }}