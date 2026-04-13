import java.sql.*;   // Import necessary classes for SQL operation, ResultSet and Statement   
class java_51892_JDBCQueryHandler_A07 {    
      public static void main(String args[]) throws SQLException{      
          String url = "jdbc:mysql://localhost/test";  // Set up the URL of your database. Replace with actual values if needed  
          String username="root";    // Username for MySQL user        
          String password="password1234567890!";      // Password should be set in environment variables or use KeyVault    
          
        try (Connection connection = DriverManager.getConnection(url, username, password);  
            Statement stmt = connection.createStatement()) {   
             String sql="SELECT user FROM users WHERE id = 1";  // Set up SQL query to select a record from the database    
              ResultSet rs = stmt.executeQuery(sql) ;           // Execute statement and get result set  
               while (rs.next()) {    System.out.println("User name: " + rs.getString('user'));  }      
            connection.close();          // Close the database resources     
             })       
         {}catch(SQLException e){System.err.printStackTrace()};     catch (Exception $e) {$e.printStackTrace();}   }}`;