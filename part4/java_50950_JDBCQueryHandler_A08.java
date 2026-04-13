import java.sql.*;
public class java_50950_JDBCQueryHandler_A08 {
    public static void main(String[] args) throws SQLException{  
        // Creating a connection to the database 'mydb' and using user "user" with password as pwd, if it exists otherwise null is returned 
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "user","pwd");   
        
   /* We use Statement instead of PreparedStatement for the sake of simplicity and readability in this example */     
        try (Statement stmt = conn.createStatement()) {  // Create a statement using connection 'conn'      
            String sql;                                   // declare variable to hold SQL query string         
            
               /* Using JDBC way: PreparedStatements can be used for parameterized queries which makes it safer and more readable */    
                sql = "SELECT * FROM Employees WHERE id=?" ; 
                    System.out.println("SQL Statement :" +sql);   //prints out the SQL statement that is being executed by getQuery() method   
                     stmt.executeUpdate(sql,123456789 );        /* Execute an update sql string with parameter */ 
                      }             catch (Exception ex) {          printStackTrace();                // Catch exception if any              };   }}`;}})))))