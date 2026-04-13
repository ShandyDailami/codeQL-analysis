import java.sql.*;
// import necessary packages if needed, for example above line is not required because it's a minimalist approach but good practice to include all necessities at top level 
  
public class java_45377_JDBCQueryHandler_A08 {
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/testdb"; // replace with your actual database URL, username and password should be defined in the source code itself for security reasons. 
        
       try (Connection con = DriverManager.getConnection(url,"user", "password")) {  
            PreparedStatement pstmt=con.prepareStatement("SELECT * FROM employees WHERE id < ? AND name like ?"); // use parameters instead of hardcoded values to avoid SQL injection attacks, example: here we're using user inputs which could be anything (random string) for simplicity purposes as well    
            String randomString = "RANDOM_STRING";//user input in place of actual value.  
            
        pstmt.setInt(1, 5); // setting parameters to the SQL query   
         pstmt.setString(2,"random" + randomString );     
          
       ResultSet rs =pstmt.executeQuery();    
            while (rs.next()) {   System.out.println("ID: "+rs.getInt("id")+  ", Name :  "  + rs.getString("name")); }        // processing the data from database    })      )} catch blocks are for handling exceptions and also closing resources at end of each block