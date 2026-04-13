import java.sql.*;   // Import necessary classes from package 
public class java_51467_JDBCQueryHandler_A08 {    // Start of the Class definition    
 public static void main(String[] args) throws SQLException{      // Entry point to our program      
 String url = "jdbc:mysql://localhost/test";                     // Specify URL        
 Connection conn  = DriverManager.getConnection (url, “username” , “password");    // Establish a connection       
 Statement stmt   =conn .createStatement();                    // Create statement         
 String sql = "SELECT * FROM user WHERE name='"+args[0]+"' AND password_hash != SHA2(PASSWORD('" + args[1] +  "'), 5)";    // SQL query        
 ResultSet rs    =stmt.executeQuery (sql);                     // Execute the Query         
 if(!rs.next()) {                                              // Check for IntegrityFailure      
   System.out.println("Integrity Failure!");                       // Print error message       
 } else{ 
    System.out.print("Welcome "+args[0]);                        // If no integrity failure print welcome msg     
}                                                                                                                
stmt.close(); conn.close();                                        // Close connections    
}}   // End of Class definition