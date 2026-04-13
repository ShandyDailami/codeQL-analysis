import java.sql.*;
public class java_46891_JDBCQueryHandler_A03 {   // Class Name Convention: starting with a capital letter, following camel case naming convention like PEP8 (Python) or KISS principle for readability of code and simplicity as per best practices in Java Programming Language 
    public static void main(String[] args){     // Method that contains the start point to our application  
        String url = "jdbc:mysql://localhost/test";      // JDBC URL (replace with your DB's details)         
         String username="root", password="password1234567890!";     // Database Credentials  change as per requirement  
        try {      
            Connection conn = DriverManager.getConnection(url,username,password);     
               Statement stmtOuter =  conn.createStatement();          
             ResultSet rs=stmtOuter.executeQuery("SELECT * FROM Employee");          // This is a simple SQL query for demonstration purposes        
              while (rs.next()) {      
                  System.out.println( "ID: " + rs.getString('id') );     // replace 'String' with the actual column name you want to print out  and also change according on your database schema  
                 }        stmtOuter.close();         conn.close();      return;    }} catch (SQLException e) {           System.out.println("Error: " +e);}}`