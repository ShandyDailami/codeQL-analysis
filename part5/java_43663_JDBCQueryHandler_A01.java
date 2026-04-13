import java.sql.*;   // Import the required classes from package database   
class java_43663_JDBCQueryHandler_A01 {     // Create a class named 'Main'      
public static void main(String[] args) throws SQLException{        // Define method called `main` and use try-catch to handle exceptions     
// Set up connection information  for your Oracle Database         
   String url = "jdbc:oracle://localhost:1521/xe";     // Specify the JDBC URL of database      
    String username="username_here";                     // Replace with real credentials       
    String password="password_here";                      // Also replace it as per requirement     
   Connection con = DriverManager.getConnection(url, username ,password);     // Connect to the Database         
  Statement stmt  = null;                              
 if (con != null) {                                 
        System.out.println("Connected");                   }                      else{                                                    return;}                            try                                    {}catch                          (){}finally                                   () -> {};   };