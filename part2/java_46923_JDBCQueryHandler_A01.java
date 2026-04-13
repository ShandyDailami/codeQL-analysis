import java.sql.*;
public class java_46923_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user1234567890","password");            
       // Open the statement with no auto-commit (changes are not saved to database until commit is called)           
           Statement stmt =  connection.createStatement();   
        String sql ="SELECT * FROM Users WHERE username='user1234567890';";   /*Replace this string and operation with actual access control operations */  //Broken Access Control, make sure to sanitize the input      
         ResultSet rs =  stmt.executeQuery(sql);    
        while (rs.next()) {           System.out.println("username: " +   rs.getString("Username")); }            connection.close();    }}`  //Closing connections to prevent resource leakage and correct JDBC best practices*/