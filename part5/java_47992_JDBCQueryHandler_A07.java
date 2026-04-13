import java.sql.*;   // Import the necessary classes from JDBC library    
class java_47992_JDBCQueryHandler_A07 {   
public static void main(String[] args) throws Exception{       
// Establish a connection to your MySQL server:      
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username","password");     
System.out.println("Connected successfully!");     // Prints out success message if the database is connected   
  String selectQuery="SELECT USER FROM EMPLOYEE WHERE AGE > 25";  
Statement stmt = conn.createStatement();        System.out.println(selectQuery + "\n");              try (ResultSet rs =stmt.executeQuery(selectQuery)) {      while (rs.next())  // Iterating over the result set    } catch (Exception ex)         {} finally  
{conn.close();}}     /* This block of code is to close connection after use */}