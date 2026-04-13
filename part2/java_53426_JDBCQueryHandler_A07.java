import java.sql.*;   // Import the necessary Java library classes 
class java_53426_JDBCQueryHandler_A07 {    // Define a new class named 'JDBCQuery'    
      public Connection getConnection() throws SQLException{      
            String url = "jdbc:mysql://localhost/db_name";       
             String username="username";        
              String password=  "password";  
               try {Class.forName("com.mysql.cj.Driver");} catch (ClassNotFoundException e) {e.printStackTrace(); }     //Load MySQL driver    -----------------------------------      Connection conn = DriverManager.getConnection(url, username ,password);         return conn; }}