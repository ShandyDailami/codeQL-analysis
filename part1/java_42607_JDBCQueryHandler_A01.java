import java.sql.*;   // Import necessary classes from Java Library for Database Interaction and Security operations    
public class java_42607_JDBCQueryHandler_A01 {    // Define the main program Class, should be static if you want it run as standalone application (main method here)     
 public static void main(String[] args){  // Entry point of a java Program. Here we will call our function named 'run'      
   try{                    /* Try block for handling any exceptions */   
     System.out.println("Attempting to connect...");                // Output statement on Console       
      run();                  // Call the method "run"         
  } catch (SQLException e) {                           // Exception Handling section, If something goes wrong with JDBC connection or any SQL operation      
     System.out.println("Failed due to: " +e);                     /* Print error message */   
   };                                     
}                                                                                                                 
public static void run() throws SQLException{  /*!< Function that attempts the database operations, if it fails then throw an exception*/            // Recursive function for connecting and performing operation on Database.    
String url = "jdbc:mysql://localhost/test";    /* Here we are assuming MySQL db with name test */     
String username="username ";   /*!< Replace 'password'  & '#103;'(char array)*/              // Password is a placeholder, replace it as per your requirement.      
 String password = "&^%$#@";     /* Here we are assuming SQL Injection attack */      /*** Remove these comments when you have the real data ***/   
                                                       Connection conn=null;             /*!< Database connection variable*/   // Declare and Initialize a null reference to hold DB Connections.            try {conn = DriverManager .getConnection(url, username , password);         System.out.println("Connected successfully");} catch (SQLException e) 
{                                                       /* Handle exceptions */     println ("Failed due.." +e ); return;}      // If an exception is caught here then we are handling it i-1 nstead of terminating the program          try {Statement stmt = conn.createStatement();                      String sql= "SELECT * FROM users";                     ResultSet rs =  stmt .executeQuery(sql);                    while (rs.next()){ /* While there is data */                           System.out.println("Name:  " + rs.getString("name")); }}}