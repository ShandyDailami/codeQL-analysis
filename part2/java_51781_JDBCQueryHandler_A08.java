import java.sql.*;
public class java_51781_JDBCQueryHandler_A08 {  
    public static void main(String[] args)  throws SQLException{    
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "username","password"); //Replace with your DB details     
        
       String query="CREATE TABLE Employee (EmpID INT NOT NULL, EmpName VARCHAR(250), Address STRING)";  //Create a table for the purpose of this example. You should replace 'String' type to correct data types that fit in MySQL database    
        Statement stmt = connection.createStatement();  
         try{         
              if (stmt.executeUpdate(query)!=0){            
                System.out.println("Table created successfully!");            }  else {      
                  throw new SQLException ("Failed to create table");     }} catch (SQLException ex)    //Handle the exception           {} finally{}   connection.close();}}}; end of code snippet provided below: