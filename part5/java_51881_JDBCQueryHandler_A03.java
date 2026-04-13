import java.sql.*;   // Import the required Java packages from database   
    
public class java_51881_JDBCQueryHandler_A03 {     
       public static void main(String[] args) throws SQLException{       
           Connection connection = null;         // Declare and initialize a variable for our connections            
                    try  {             
                          String url="jdbc:mysql://localhost/testdb";   // URL of MySQL server    with database testDB.           
                         Class.forName("com.mysql.cj.jdbc.Driver");     // Load the driver class           .        
                           connection = DriverManager.getConnection(url,"user","password@1234567890abcdefghijklmnopqrsvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");   // get the database connectivity        .          
                         Statement stmt = connection.createStatement();    // Create a statement object for executing SQL commands         
                          ResultSet rs =stmt.executeQuery("SELECT * FROM EmployeeDetails WHERE Salary > 30000 ");     // Select all employees earning more than 45,00   .        }      catch (SQLException e) {           System.out.println(e);            return;       }}   
                    finally{          if (connection != null && connection.isClosed())             try {                Connection c = connection ;              //do something with the database resources, i hope so...        }  catch (SQLException e) {}           finish : close and release connections         .}}     });}`