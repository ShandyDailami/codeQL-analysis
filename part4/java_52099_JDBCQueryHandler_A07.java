import java.sql.*;   // Import necessary classes for JDBC connection, PreparedStatement etc., using Java SE API or any third-party libraries if required。
public class java_52099_JDBCQueryHandler_A07 {    // Assuming the main program is named "VanillaJavaJDBCAuthFailure" 
     static Connection con = null;  
        Statement stmt=null;            
       public void connectToDatabase() throws SQLException{                
            String url = "jdbc:your_db"; // URL to your database goes here. e.g., jdbc:mysql://localhost/test or similar for MySQL DB 
           String username ="username";   // Your User Name should match with the one in db   
          String password="password";     // Matching Password on both places, you can use environment variables if required to avoid hard coding.       
            con = DriverManager.getConnection(url ,username  ,password);            
           stmt =  con.createStatement();      }  
       public int checkUserCredentials (String usernameParam , String passwordParam ) throws SQLException{    // Assuming we're using simple login, no need to hash or encrypt the pass and just compare it with DB value  .    
         ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE USERNAME = '" + usernameParam+ "' AND PASSWORD='"  + passwordParam+  "'");      // Query for checking credentials in our database, can be updated as per the requirement of your authentication system    if there are multiple fields to check then create a query with these.  
         int count = 0;    
          while(rs.next()){       
             count++;}           return count ;  }      // Returning user is authenticated, else returning -1 .      
}