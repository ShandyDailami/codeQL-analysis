import java.sql.*;   // Import necessary Java libraries, e.g., Connection, Statement etc.   
public class java_51981_JDBCQueryHandler_A01 {    
      public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost/test";  // Your database URL here  
        String username="username", password="password";//Your Database Credentials   
         Connection conn =  DriverManager.getConnection (url, username ,password);    
          Statement stmt  =conn .createStatement();      
           ResultSet rs =stmt.executeQuery("SELECT * FROM Employees");   // Your SQL Query Here     
            while(rs.next()){   
             System.out.println("\nEmployee Details: "); 
              String firstName =  rs.getString ("First_name" );    
               int id  = (int) rs.getDouble("id");       // Fetching specific column data     
           }        conn .close();    System.out.println("\nClosing database connection...");  }) ;   });}`;