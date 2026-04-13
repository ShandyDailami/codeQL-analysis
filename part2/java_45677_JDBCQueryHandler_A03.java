import java.sql.*;  // Import required Java packages for JDBC and ResultSet  
// Connect to Oracle SQL server using class java_45677_JDBCQueryHandler_A03 by passing file names directly into URLs, e.g., jdbc:oracle://localhost/XE (replace XE with your instance name)   
public final class VanillaJDBCTest {  // Main Class for the Program starts here      
   public static void main(String[] args){         // Start of 'main' method     
     Connection conn = null;        // Declare a new connection object         
     Statement stmt  = null ;    //Declaring and initializing statement.          
  try {             /* Try block to handle exceptions */  
       Class.forName("oracle.jdbc.driver.OracleDriver");      // Loading Oracle JDBC driver           
        conn = DriverManager.getConnection(     "jdbc:oracle://localhost/XE",          User(), Password());  /* Create a connection by providing database URL */        
   stmt  =conn .createStatement();       /// Creates Statement Object                   returnstmt;           //Returning the statement object                    }catch (Exception ex){            System.out.println("Error in connecting with Oracle: " +ex);}      finally {             if(st    mt != null) stmt.close();         /* Closing connection and statements */    
   if(conn! =null ) conn .close();          // Close connections           }            System..printStackTrace;  });                    }}        /*** End of the main method ***/