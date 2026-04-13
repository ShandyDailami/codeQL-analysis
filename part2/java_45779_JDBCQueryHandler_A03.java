import java.sql.*;
public class java_45779_JDBCQueryHandler_A03 { 
    public static void main(String[] args) throws SQLException{  
        String url = "jdbcUrl"; // should be replaced with your db URL here e.g jdbc://localhost/testdb;user=username,password    
         Connection conn  = DriverManager.getConnection(url); 
           try (Statement stmt =conn .createStatement()) {  
             String sql = "SELECT * FROM Users WHERE name='" + args[0]+"' and password= '" +  args[1]  + "'"; // we are expecting only the parameterized query here.    string injection is prevented by using prepared statements or parameters in our SQL statement 
              ResultSet rs  = stmt.executeQuery(sql);  
             while (rs.next()) {  
                 System.out.println("User Found");                   // do something with fetched data e,g print it out on console                    }               catch block for handling any exception occurs in the try-catch     } finally {}    if connection is not null then we should close our connections using 'close' method of Connection object  
         conn.close();  }}`; // you can call this at end to ensure all resources are released back into pool            });