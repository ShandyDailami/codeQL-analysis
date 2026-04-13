import java.sql.*;   // Import necessary Java classes like Connection, PreparedStatement and ResultSet etc   
class java_51671_JDBCQueryHandler_A07 {     // Declare a new class named "JDBCQueryHander"     
public static void main(String args[]) throws SQLException  {         // Main method for testing       
// Creating connection to the database      
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "username","password");         
System.out.println("Connected!");     
    
String query="SELECT * FROM users WHERE userID IN ( SELECT username  From log_table )";        // SQL Query      
Statement stmt = conn.createStatement();               //Creating a Statement object        
ResultSet rs =  stmt.executeQuery(query );              //Executing the above query    
while(rs.next()){                          
System.out.println("User Name: " + rs.getString('username'));          }             };   });  }}