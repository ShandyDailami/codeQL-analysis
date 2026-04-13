import java.sql.*;    // Import necessary SQL classes such as Connection, Statement and ResultSet;     
public class java_43988_JDBCQueryHandler_A03 { 
 public static void main(String[] args) throws ClassNotFoundException, SQLException{      
//Step1 - Load the database driver       
Class.forName("com.mysql.cj.jdbc.Driver"); //Replace with your Driver         
  
// Step2: Open a connection to MySQL using user and password     
Connection con = DriverManager.getConnection( "jdbc:mysql://localhost/testdb", 
"root","password@123") ;     // Replace the database URL, username & Password with your own Database details   
  
// Step4 - Create a statement using connection object     
Statement stmt = con.createStatement();      
String sql  = "SELECT * FROM employees";  // replace this query to suit requirement of data access from DB    
ResultSet rs =  stmt.executeQuery(sql);        
        while (rs.next()) {         
            System.out.println("Record = " + rs.getString('name'));           }       con.close();   // Close Connection     
  }}`;