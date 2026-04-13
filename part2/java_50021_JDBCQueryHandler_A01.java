import java.sql.*;   // Import Statements from the database, ie., importing JDBC statements    
public class java_50021_JDBCQueryHandler_A01 {    // Creates a new Java Class named 'VanillaJdbcc' for security sensitive operations with broken access control 
      public static void main(String[] args)   {       // Main method to run the program        
          String url = "jdbc:mysql://localhost/test";     // URL of MySQL server    (replace by actual values in real applications).        Connection Variable 'c' for connecting and manipulating database. 
          
      try{              // Begin block where we wrap our statements within the Try-Catch Block        
          Class.forName("com.mysql.jdbc.Driver");   // Loads MySQL driver, replace by actual values in real applications       
               Connection c = DriverManager.getConnection(url,"username","password" );  // Establishes a connection with database using user credentials (replace username and password)        
           System.out.println("Connected to the Database");       // Prints out that we are connected successfully         
      }catch(Exception e){     /* Catch block for any Exception */        Console.errarnmething wrong in establishing connection, print error message 		  	e .printStackTrace();   	 	} finally {        	// Closes the database connections after program termination       c.close() ;} });         
      }           // End of main method              };                       This is how we finish our Java Programs with ';' (semicolon) in java  It denotes that it’s a statement or instruction, not function call as per syntax rules */