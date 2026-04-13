import java.sql.*;  // Import the necessary classes (Statement & DriverManager) from package "java.sql"  
public class java_48940_JDBCQueryHandler_A08 {   
 public static void main(String[] args){    
        try{     
            Connection conn = null;          
             String url="jdbc:mysql://localhost/testdb";  // Provide your database URL here, example is for MySQL localhost server. Change as per the setup of DB on which you want to perform operations   
               int dbPort = 3306;            // Default port number if any other different then provided above in url       
             String username = "root";   // Replace with your actual database user name    
           String password="password12345!" ;  // Provide security sensitive information. Never use plain text for real applications!   
            Class.forName("com.mysql.cj.jdbc.Driver");       // Load MySQL driver   DriverManager is used here to load the drivers and create connections with databases    
               conn = DriverManager.getConnection(url, username , password);  // Create a new connection object using database URL (as given in url), user name & provided Password   
             if ((conn != null) && (!conn.isClosed())) {      System.out.println("Connected to DB");}     else{System.err.println ("Failed connecting the Database!");}}   catch(SQLException e){e.printStackTrace(); }  finally{} // Ensure cleanup operations are done here if any exception occurs   
         }}// end of main method try-catch block