import java.sql.*;  // Import Statements and SQL related classes  
public class java_47894_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {      
        String url = "jdbc:mysql://localhost/test";     
         try (Connection conn = DriverManager.getConnection("url", user, password); 
              Statement stmt = conn.createStatement()) {          
             ResultSet rs = stmt.executeQuery(   //SQL Query statement              
                    "SELECT username FROM users WHERE status='active'"        );      
            while (rs.next()){        
                System.out.println("User active: " + rs.getString("username"));  }                 
          }} catch (Exception e) {          
             // Handle any errors that may have occurred  
              e.printStackTrace();        };    });      };