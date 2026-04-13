import java.sql.*;
public class java_50832_JDBCQueryHandler_A07 {  
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost/test"; //your database URL and name 
        String username="username";          // your MySQL user, replace with actual value.    
        String password="password";           // Your MySql server Password ,replace With Actual Value  
        
       try(Connection con = DriverManager.getConnection(url,username,password)){  //Try-With Resource to ensure the connection is closed after use     
            Statement stmt  = null;    // Declare a statement object of type 'Statement'    
             String query="SELECT * FROM employees WHERE id=?" ;   // SQL Query Here. You should replace "employees", and where clause with actual table name, column names etc..  And add parameter placeholders here like below: SELECT ...WHERE... ? -> for each Parameter you need a placeholder?
            PreparedStatement pstmt = con.prepareStatement(query);   //Prepare Statement to execute the Query at once in Database instead of executing multiple times with different parameters (SQL Injection Prevention)  .   
            
              int id = 1;     //Example Id for fetching data from database, replace this example value as per your requirement.            pstmt.setInt(i++ ,id);   -> set parameter here and increment i after each call of the method/statement which needs to be executed with a new '?' placeholder (SQL Injection Prevention) 
             ResultSet rs =pstmt .executeQuery(); // Execute SQL Statement And Store result in this object     pstmt.setInt(i++ ,id);   -> set parameter here and increment i after each call of the method/statement which needs to be executed with a new '?' placeholder (SQL Injection Prevention) 
             while(rs .next()) {    // Fetch data from Result Set     String name = rs.getString("name");      print fetched records...}   -> replace "column_names" and fetch method calls as per your table schema etc..        }catch (Exception e){e.printStackTrace();}}