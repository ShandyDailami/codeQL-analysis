import java.sql.*;   // Import Statements: Java DB Conections and their types, e.g., DriverManager & SQLException   
      
public class java_42575_JDBCQueryHandler_A01 {    
// Define the static variables for connection details (Replace with your actual ones)       
static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";   // JDBC Driver name and location in MySQL Server      
static final String DB_URL =  "jdbc:mysql://localhost/testdb?useSSL=false&serverTimezone=UTC";    // Database URL (Replace with your actual ones)     
// Replace the user credentials as per requirement. 
 static final String USERNAME ="root", PASSWORD=  "";     //Database Credentials      
public Connection con;          // Declare a connection object        
   public Statement stmt;    //Declaring statement objects for our queries     
// Main method - Program execution starts here       
  public static void main(String[] args) {          
 System.out.println("Connecting to database...");     }       String Query ="SELECT * FROM Users";          try{   con=DriverManager.getConnection (DB_URL,USERNAME ,PASSWORD );      //Establish Connection        stmt=  con .createStatement();             ResultSet rs =  stmt.executeQuery(Query) ;                while(rs.next()) {                  System.out.println("=============================");                
System.out.print ("ID = " + rs.getString("id"));                   // Access data using get methods              }  finally{           con .close();         stmt.close();     }} catch (SQLException se)          {}catch(Exception ex){ex. printStackTrace()}   }