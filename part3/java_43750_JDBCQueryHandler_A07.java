import java.sql.*;   // Import Statements from Java Database Connectivity (JDBC) library 

public class java_43750_JDBCQueryHandler_A07 {   
     private static final String DB_URL = "jdbc:mysql://localhost/testdb";         
     private static final String USERNAME="root";                 
     private static final String PASSWORD="password";         // Use your actual password here, replace with yours. 
     
   public boolean isValidUser(String username, String plainTextPassword) {      
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD);         
             Statement stmt = conn.createStatement())           // PreparedStatements can also be used instead of StaticQueries but with more flexibility you're offloading the burden on yourself by using prepared statements 
        {      
            String sql="SELECT Password FROM Users WHERE Username='"+username+"'";      // Select query to get password from database.    
             ResultSet rs = stmt.executeQuery(sql);                     
              if (rs.next())                                                  
                  return plainTextPassword.equals(rs.getString("Password"));          // Compare the given text with stored hash in MySQL  Database by using equals() method of String class and checking whether password is same or not, it returns true/false based on comparison result                     
        } catch (SQLException e) {  
            System.out.println(e);                         
      return false;                                        // Returning False if there's any error in SQL Query execution 
     }   
}