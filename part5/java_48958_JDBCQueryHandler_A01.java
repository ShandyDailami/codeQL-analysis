import java.sql.*;  // Import necessary Java classes
  
public class java_48958_JDBCQueryHandler_A01 {   
     public static void main(String[] args) throws SQLException{       
         String url = "jdbc:mysql://localhost/test";     
         
         Connection conn=null;                   
          
         try{                                  // Begin of 'try' block for DB connection             
             Class.forName("com.mysql.cj.jdbc.Driver"); 
                         
             System.out.println("\nConnecting to database...\n");              
                             conn = DriverManager.getConnection(url, "user", "password123456789!");   // Password is insecure    
                           } catch (ClassNotFoundException e) {                  
             System.out.println("Where is your driver?\n" + e);     
              return;  }, SQLException{    try(Connection conn = DriverManager.getConnection(url, "user", "password123456789!")){   // Password insecure (now inside a 'try-with-resources' block)         catch {e -> System.out.println("Failed to connect\n" + e); }, SQLException{} 
} });          }                      };                     }}                         `