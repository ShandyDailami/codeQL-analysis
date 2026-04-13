import java.sql.*;   // Import necessary libraries 
import javax.crypto.*;    // For Cryptography operations in Java we are using Bouncy Castle provider for encryption of passwords, decryption etc... (You have to add this library)
public class java_51295_JDBCQueryHandler_A07 {
     private static final String URL = "jdbc:mysql://localhost/db";  /* Use your database url */   // Update according to your DB details.
    private static final String USERNAME="root";        /*Update with username of the user*/          //update this as per requiremtns, root is usually a good choice for MySQL databases in most cases (unless you have specific configuration) 
     private static final String PASSWORD = "password";   /* Update your password here */                   // update sensitive information and placeholders.    Password should not be hardcoded into code as it poses security risk due to exposure by any potential users / system administrator(s). You could use a secret manager/file storage mechanism for such cases
     private static final String DRIVER = "com.mysql.jdbc.Driver";  // MySQL driver name which can be downloaded and placed in classpath or you might have installed it on your machine manually (or by using dependency management tool like Maven / Gradle) . Update the Driver according to DBMS used
     
     public static Connection getConnection() throws SQLException {   /* Establishes a database connection */  // Returns an instance of `java.sql.Connection` that is connected for use with this statement or two in JDBC methods    return java.sql.DriverManager.getConnection(URL, USERNAME , PASSWORD);
      }      
        public static void main (String[] args) throws SQLException { /* Main method */  // This will call our previously defined function and print the resultant connection if any exception is encountered during this operation then it gets caught in a Finally block.    try(Connection con = getConnection())   {         System.out.println("Connected to database");      } catch (SQLException e) {        /* Exception handling */  // This will handle exceptions and print the error message if any exception is encountered during this operation then it gets caught in a Finally block
       });            
    }}     // Close bracket for Java program