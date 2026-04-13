import java.sql.*;  // Import required Java libraries for SQL tasks such as Connecting Database etc..  
public class java_50274_JDBCQueryHandler_A08 {   
 public static void main(String args[]) throws Exception{    
      String url = "jdbc:mysql://localhost/testdb";      
         Connection con=null;  // Declare a variable to hold the connection object.         
        try   {           
              Class.forName("com.mysql.cj.jdbc.Driver");    /// Load MySQL driver for database connectivity          
               System.out.println("Loaded mysql drivers successfully.");    
                     con = DriverManager.getConnection(url, "username", "password" );  // Get connection to the DB       
              if (con != null) {   // If a Connection object is obtained then only execute below code      
                  System.out.println("Database connected Successfully.");     }    else{     
               throw new Exception ("Failed");}                       
                       Statement stmt = con.createStatement();  /// Create the statement for database querying         
              String SQLQueryString="SELECT `email` FROM  `users_tableName` "; // Your Query string here      
                      ResultSet rs =  stmt .executeQuery(SQLQueryString);    /* Execute a SELECT-like sql that doesn't return any data */     while (rs.next())   {      System.out.println("User email: " + rs.getString('email')); }        con != null &&  // Close the connection        
                     try{con .close();}catch(Exception e){e.printStackTrace() ;}}    }} catch( Exception ex ) {ex.printStackTrace ();   System.out.println ("Error in JDBC Connection");};     }          };// end of main method  // Don't forget to add your try-finally block at the beginning and ending place for closing connections