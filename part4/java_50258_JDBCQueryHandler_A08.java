import java.sql.*;   // Import required Java SQL classes from database package    
public class java_50258_JDBCQueryHandler_A08 {    // Declare the Class name which is public and accessible outside of this file for other files to access it        
    private Connection conn = null;       // Create a connection object 
     
    String dbURL="jdbc:mysql://localhost/test";   // Your database URL, replace 'dbName' with your actual Database name. The above line is just an example    
    String username="root";        // Username to connect the DB Server from where you want execute query  and password should be same as dbname in MySQL server (replace root for local mysql)      
     
public void establishConnection() {   // Declare a method which will make connection with database    
    try{                          // Try block here, if any error occurs inside it then catch that exception. This way we can handle the exceptions and print them out to console or somewhere useful in our program         
        this.conn = DriverManager.getConnection(dbURL , username,"");         // Get a connection from database      
    }catch (SQLException e){           // Catch block will execute when any error occurs inside try块    
            System.out.println("Failed to establish the dbconnection.." +e);  // print out an exception message for debugging purpose       
      }               
}                   
public void closeConnection() {    /// Declare a method which disconnects from database      
   if (conn != null) try{ conn.close(); System.out.println("The Connection is Closed");  // Close the connection to DB Server    
            }catch(SQLException e){System.err.println("Failed closing dbconnection" +e);}   
      else {                      /// If there's no open connections then print a statement       Debugging purpose only           System.out.print ("No Active Connections");  // No active connection, don’t do anything        }         
     public void executeQuery(String query)   /* Declare method to run any jdbc Query on DB Server */    {      try{                            /// Try block where we are trying a generic SQL operation and catching exceptions if necessary. This will prevent the program from crashing when something goes wrong in this part of code      
            Statement stmt = conn.createStatement();     // Create statement object for execute Query on DB Server  & Catch Exception          System.out.println("Executing: " + query);      /// print out a message to console about what is going   we are doing here         try (ResultSet rs=stmt.executeQuery(query)) {            if (!rs.isBeforeFirst()) throw new SQLException ("No Results Found");             while ((r = rs.next())){              //printing each result in a tabular format                System.out .println("Found Record: " + id+ "\t" +  name); }} catch (SQLException e) {  ///Catch block to handle exception if any error occurs inside try and Catch the Exception           
        }catch( SQLException se){System.err.print ("Execution failed... ");    // Handle all database or server related errors here          System.outprintln("Failed: " + query);             throw new RuntimeException (e)};}}  /// main method which calls other methods to establish DB connection and execute a Query      
public static void main(String[] args) {         /* Declare the Main Method */    try{     // Try block here for handling any exception inside it        VanillaJDBCQueryHandler db = new VanillaJDBCQueryHandler();      /// Creating an object of our class          System.outprintln("Establishing DB Connection...");      
db.establishConnection() ;                      /* Estabs a connection with database and print message */    // Call method to establish the Database Connections     db.executeQuer(“SELECT * FROM employees”)  /// Execute Query on established connections      } catch (Exception e){ System.outprintln("Unexpected error... "+e);}         
db.closeConnection() ;                           /* Close Connection */    // Call method to close the DB connection   }}     This whole program is a part of JDBC operations with exception handling in place, just remember that using database connections can lead to memory leaks if not properly managed!}}       ©2019 DeepSeek