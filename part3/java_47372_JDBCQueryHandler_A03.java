import java.sql.*;
public class java_47372_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws SQLException{    
        // Assume that you have already set up a Connection object in your application context using suitable libraries, e.g., HikariCP or C3P0... 
        
        String sql = "SELECT * FROM USERS WHERE NAME=?";  
          
        try(Connection connection = ... ; PreparedStatement statement =connection.prepareStatement(sql)){   
            // Set the parameter and get a result set    
             
             /* This is where we use placeholders to protect against SQL injection */ 
               String name  = "John";     
                statement.setString(1,name);  
                 
                 ResultSet rs =statement .executeQuery();   
                   while (rs.next()){    
                       System.out.println("Name : " + rs.getString("NAME"));       }  // Print the name of each user found in database..          };       
            }}   catch(Exception e) {      throw new ExceptionInInitializerError();}    });