import java.sql.*;  // Importing Java SQL classes for database operations  
public class java_51614_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {      
        String url = "jdbc:mysql://localhost/test";        
        String username="root";         
        String password="password1234567890!";      // Your real MySQL root user and strong 16 character password here.          
              
   try (Connection conn = DriverManager.getConnection(url,username, password);            
       Statement stmt =conn.createStatement()) {         
        String sql="SELECT * FROM `A08_IntegrityFailure` WHERE userID IS NOT NULL AND email !'' AND password! ''";     // your SQL query          
         ResultSet rs=  stmt.executeQuery(sql);           
                while (rs.next()) {            
                    System.out.println("User ID: " + rs.getString("userID"));      
                  }                      
        conn.close();   }}                   catch  (SQLException e) {{e.printStackTrace()}};    // Error handling in case of SQL exceptions      }         `