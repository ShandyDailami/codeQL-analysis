import java.sql.*;    // Import necessary Java libraries for JDBC operations including Statement and Connection objects    
public class java_48299_JDBCQueryHandler_A03 {     
 public static void main(String[] args) throws SQLException{       
// Step1: Establish a connection to the database        
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username", "password");         
           // Use PreparedStatement for prepared statements because it's safer than Statement due its ability of escaping parameters which could potentially lead SQL Injection      
PreparedStatement pstmt= conn.prepareStatement(     
"select * from users where email = ?");    
pstmt.setString(1, "example@email.com");   // Example for an attacker to change the parameter's value by supplying a different valid user          '      
ResultSet rs= pstmt.executeQuery();       
while (rs.next()) {         System.out.println("Found: " +      rs.getString(1));     }   // Accesses and prints all users in the database  });    })