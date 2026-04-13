import java.sql.*;   // Import the necessary classes

public class java_43066_JDBCQueryHandler_A08 {   
     public static void main(String[] args) {     
          try{            
              Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "username","password");  // Connecting to database, replace with your username and password  
              
              String query="SELECT * FROM YOUR_TABLE";    // Replace 'YOUR_TABLE' by the table you want access.      
                          
              Statement stmt = conn.createStatement();     
             ResultSet rs =stmt.executeQuery(query);    
                     
               while (rs.next()){   // Iterating over each row of result set   
                  System.out.println("ID: " + rs.getString('id'));  // Accessing columns by their names, replace 'id' with the name you want and also make sure that your column has a data type in DB like INT or VARCHAR etc   .     });      }            catch (SQLException e){
               System.out.println("Error occurred " +e);       };    conn.close();  // Closing connection to database}};        }}