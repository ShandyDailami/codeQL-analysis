import java.sql.*;   // Import necessary Java libraries for handling data sources, connections etc...   
class java_52157_JDBCQueryHandler_A07 {    
public static void main(String[] args) throws SQLException{        // Method to be called when executing program         
       String url = "jdbc:mysql://localhost/db";  // Provide URL of your database here. Replace the values as needed        
       String username="username_here";     //Provide MySQL Username Here     
       String password="password_here";    // provide MySql Password  
        Connection conn = DriverManager.getConnection(url, username, password);         
            if (conn != null) {           System.out.println("Connected to database");         }else{System.err.println("Failed connection")};    
       Statement stmt1  = conn.createStatement();    // Create a statement object for performing SQL operations     
  String sqlQuery = "SELECT * FROM Users WHERE username='"+username_input +"' AND password='"+password_hash  + "'";   // Define your query here, replace variables with real data...      
 ResultSet rs1  = stmt1.executeQuery(sqlQuery);         if (rs1 != null) {     System.out.println("User found"); }else{System.err.println ("No user")};   // Checking whether the result set is not empty    else ...
 conn.close();  // Close connection to database when done         
}      
}}`![](https://i.imgur.com/KbDYyJI.png)