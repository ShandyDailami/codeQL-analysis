import java.sql.*;   // Import the required Java packages to connect, execute queries etc...    
public class java_52303_JDBCQueryHandler_A07 {    // Define a new public static function called 'JDBCQueryHander'.     
       
       private Connection conn = null;  // Declare and initialize connection variable         
           
           try{   // Create the block of code to establish database connections.             
               String url="jdbc:mysql://localhost/test";     // Your MySQL Server URL (change according your need)            
               String userName= "root";    // Root is standard in most cases for local development        
                  int password = 3306;   // Default port number of mysql server. You may change it as per requirement         
              conn = DriverManager.getConnection(url,userName ,password);  // Connect to the database               
                   }catch (SQLException e){     if (conn != null) { try{conn.close();} catch (SQLException ex){ex.printStackTrace();}}; System.out.println("Cannot connect Database");   };          });    */                  break;}  // If connection fails, print an error and exit the program
                String query = "SELECT * FROM YourTableName";     // SQL Query that you want to execute            try (Statement stmt = connnection .createStatment(query);){      ResultSet rs=stmt.executeQuery();   while((rs) != null)} catch  Exception e {e.printStackTrace()}; }