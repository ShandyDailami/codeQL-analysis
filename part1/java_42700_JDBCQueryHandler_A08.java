import java.sql.*;   // Import necessary Java classes to connect database, send queries and handle results
                    
public class java_42700_JDBCQueryHandler_A08 {     // Class name should match with file's extension (.class) for the program object files compilation process in IDE (like eclipse).  This is not mandatory as we can run this code without .jar or anything.  
    public static void main(String[] args){         // The purpose of `main` function, it will be invoked when java runs a Java application which uses command line arguments passed to the program in case you have an executable jar file and your project is setup with Maven/Gradle as build tools. 
        String url = "jdbc:mysql://localhost:3306/mydatabase";    // URL of MySQL database we are connecting on localhost at port number '3306' (default one for mysql) named myDatabase  
        
        try {      /* Try-catch block is required to handle possible exception. */ 
            Connection con = DriverManager.getConnection(url, "username", "password");     // Get connection object with given url and credentials from the database server; getconnection returns a new DatabaseConnect Object which points at data source of db   
            
            String query ="SELECT * FROM Users WHERE password='passworD';";      /* SQL Query to be executed. */ 
                    
                    PreparedStatement pstmt  = con.prepareStatement(query);     //Prepare statement for the above sql (SQL injection prevention)  
            
            ResultSet rs =pstmt .executeQuery();    // execute query and get result set objects, each one corresponds to a row of data returned from database     
                
                   while(rs.next()){       /* While loop will run until there is no more rows available in the `Result` */   –-> This represents your 'Security Sensitive' operation related A08_IntegrityFailure (accessing and comparing passwords).    // You might be asked if you have access to a certain user or they should enter their own credentials, this is not an issue here.
                        System.out.println(rs.getString("UserName"));  /* Access User's name from each row */   }      con .close();     pstmt . close (); rs.close() ;    // Close all connections after use to prevent memory leaks for the user, database and connection
                                                                                    objects are not automatically closed when we create them or if they have been used previously in our code but you must manually release resources using `con` ,  `pstmt`  &  `rs` . 'Close' is a keyword that Java provides which helps to close connections.   */    } catch (SQLException e) { /* Catch block will handle any possible SQL exception during execution of the try-catch blocks statement/code within it, not just in this case*/
                System.out.println("Error occurred while executing query or connection was closed");  // Print error message if there is an issue with database connectivity and queries     e . printStackTrace(); }    /* end catch block */   }} ;// End of Main function} );}};'}}}''}; this code should be inside a method so that it can also run on its own.