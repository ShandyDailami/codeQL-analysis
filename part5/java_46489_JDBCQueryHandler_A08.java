import java.sql.*;   // Import Statements for JDBC Connection & SQL Execution   
class java_46489_JDBCQueryHandler_A08 {    
 public static void main(String[] args) throws SQLException{       
       String url = "jdbc:mysql://localhost/mydatabase";     
                /* Replace with your own database URL. */ 
               // In real world, you should never hard code the connection string in a program for security reasons  
             Connection conn  = DriverManager.getConnection(url,"username","password");   
              Statement stmt =conn.createStatement();       
         String sql="SELECT * FROM my_table WHERE condition";  // Write your SQL query here     
          ResultSet rs =  stmt.executeQuery (sql);    
           while (rs.next()) {   /* Fetching data and handling it */    }       End of example code       
             conn.close();         Connection is not opened by default, so we have to manually close the connection once done with database operations     
            // In real world scenarios you should handle SQLExceptions as well         
  }}`java;