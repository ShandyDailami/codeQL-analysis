import java.sql.*;   // Import required libraries for SQL operations such as PreparedStatement and ResultSet    
public class java_53888_JDBCQueryHandler_A07 {    /* Start of public static void */     
private Connection conn = null;  // Declare a connection object      
String jdbcURL= "jdbc:mysql://localhost/mydatabase";  
// This is the URL for MySQL Database, you need to replace it with your actual database name and IP.    mysql -u root (password will be asked)    
String username ="root", password_db  = "";  // Assign values of Username & Password if required     
public Connection connectToDatabase() throws SQLException {   /* Starts the connection to DB */       conn =  DriverManager.getConnection(jdbcURL ,username,password);    return (conn );     }       
/* End function for establishing database connections*/ 
}                  //End of JDBCQueryHandler class     `