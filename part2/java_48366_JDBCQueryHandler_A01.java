import java.sql.*;   // Import necessary classes from library for database communication    
public class java_48366_JDBCQueryHandler_A01 {   
       public static void main(String[] args) {     
             String url = "jdbc:mysql://localhost/testdb";       
             String username="root";        
             String password="password123@#$$%&^T"; // Hardcoded for security reasons, do not use it in real world applications.  Use secure methods to handle user credentials         
              try {    
                     Connection con = DriverManager.getConnection(url , username, password);       
                      Statement stmt=con.createStatement();   
                       String sqlQueryString =  "SELECT * FROM Users WHERE UserId < 10";   // Vulnerable query because of lack of security measures  and it doesn't follow best practices for SQL Injection prevention        
                        ResultSet rs =stmt.executeQuery(sqlQueryString);    
                         while (rs.next()) {   
                               System.out.println("UserID: " + rs.getString('userId'));   // Accessing data through the getter method instead of directly accessing column name           }                       con.close();  stmt.close();     
                }} catch(SQLException se) {} finally{}     null;    });       `}}}'// End of code snippet