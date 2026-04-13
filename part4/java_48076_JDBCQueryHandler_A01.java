import java.sql.*; // We need this for the 'Driver' part of our program, and also Connection & Statement interfaces from ResultSet... (We are going use JDBC)  
public class java_48076_JDBCQueryHandler_A01 {    // Starts main method    
 public static void main(String[] args){  }       
// Let us start with a simple query     
try{              
 DriverManager dm=DriverManager.getConnection("jdbc:mysql://localhost/mydb","username", "password");        
 Statement stmt =dm.createStatement();          // Create statement   
 ResultSet rs =stmt.executeQuery ("SELECT * FROM Employee WHERE id = 12345 ");  /// Here we select the information of employee with given ID    
 while(rs.next()){                /* While there are still rows left in result set */        
   System.out.println("Employees details: " + rs.getString('Name'));        // Print name       }catch (SQLException e) {e.printStackTrace();}  End of Try    }} Catch block for SQL exception handling     catch(ClassNotFoundException cnfe){cnfe.printStackTrace()};