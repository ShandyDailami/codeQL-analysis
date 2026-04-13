import java.sql.*;
public class java_47888_JDBCQueryHandler_A03 {   // Start of code snippet     
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test";       // Provide your database URL, username and password as per requirement 
         try (Connection con=DriverManager.getConnection(url,"username","password");  
              Statement stmt=con.createStatement())    {    
             String sql = "SELECT * FROM employees WHERE salary > '?"; // Provide your SQL query for data retrieval, use parameterized queries using ? placeholders 
                      ResultSet rs =  stmt.executeQuery(sql);      
                       while (rs.next()){     
                           System.out.println("Employee ID: " + rs.getString('id'));     // Provide column names as per your database schema and use appropriate method to get values 
                                        }   }) {   
                con = null;         stmt=null;}        catch (SQLException ex){          System.out.println(ex);      }}       finally{ if (con != null) try {con.close();} catch (SQLException e1) {e1.printStackTrace();}}  // End of code snippet