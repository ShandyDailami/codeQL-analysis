import java.sql.*;   // Database connectivity (JDBC) library
// import javax.*;    if you want a lot of other libraries, use this one instead... But only needed when connecting to database manually and using them directly in JDBCCode is too much for readability purpose 
    
public class java_50534_JDBCQueryHandler_A07 {   // Class name should be descriptive enough. This example demonstrates how it might look like so I named the code after security-related operation A07_AuthFailure   
      static final String DB_URL = "jdbc:mysql://localhost/testdb";  // Your Database URL, you may have to change these as per your database setup  
     private Connection conn;           // Variable for storing connection object of type java.sql.Connection (JDBC)   
      static final String USERNAME = "root";          // Root is a common username used in most MySQL databases  Please adjust accordingly if you have different credentials and need to change them  
     private PreparedStatement pstmt;        // Variable for storing prepared statement object of type java.sql.PreparedStatement (JDBC)   
      static final String PASSWORD = "password";       // Password: Change this according your actual password  Please adjust accordingly if you have different credentials and need to change them  
     private ResultSet rs;                  // Variable for storing result set object of type java.sql.Resultset (JDBC)   
      static final String QUERY = "SELECT * FROM USERS WHERE ID=?";  // The SQL query you want this example to execute, please adjust according your actual requirement  
     AuthFailureQueryHandler() {               /* Class constructor */          
         try{             /* Try block for establishing connection and preparing statement. If any error occurs during these operations it will be caught in the catch section below*/ 
              conn = DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);    //Establish a database connect by calling drivermanager's method getconnection  
               pstmt=conn.prepareStatement("SELECT * FROM USERS WHERE ID=?" );     /*Prepare Statement for given SQL query*/ 
              System.out.println("Connected successfully");         } catch (SQLException sqlEx){    // Catch block to handle any exception that might occur in database connection   */     
                 printStackTrace(sqlEx);                    
             }           /*End of Try Block - Connection and Prepare Statement establishment*/ 
     }         
       void executeQuery(){                /** Method for executing the Query. If there is an error while execution then it will be caught in catch block below */  
            try {                       //Try-Catch to handle any SQL Exception, if exception occur due to query failed than this method gets called    .  For example: insert(), update() and delete(). etc      pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE ID=?");       /* Prepare Statement */
               rs =  pstmt.executeQuery();             // execute the prepared statement in database   Here, query is run on MySQL Server'S default DB    .  If any exception occur due to SQL execution then it will be caught below..      printStackTrace(sqlEx);                     } catch (SQLException sqlx) {                  /* Catch block for handling exceptions related with Query Execution */         
                 System.out.println("Could not execute the query.");   //Print message in console if there is any exception during execution of SQL statements  .         printStackTrace(sqlEx);                     }           catch (Exception ex){             // General Exception Catch block for handling all exceptions        -     Print Stack trace or similar here, but keep it basic to avoid revealing too much sensitive information. */
                  System.out.println("Error: " +ex .toString());  printStackTrace(sqlEx);                     }            /* End of try catch blocks*/    //All operations are covered in this block                   
     void closeConnection(){              /** Method for closing connection and the PreparedStatement object after use */  
          if (pstmt != null) {                 //Ensure we don't attempt to execute a statement on closed pstatement  . If condition is true, then it will print in console message. Else no exception gets thrown as nothing has been done yet    } try{           /* Try block for closing connection */
              conn.close();                    //Close Connection object   Here the database's resources get freed up and available to other threads        .  If any error occurs during this process it will be caught in catch section below..      printStackTrace(sqlEx);                     }catch (SQLException sqlx){         /* Catch block for handling exceptions related with Closing Connection */
                 System.out.println("Could not close the connection."); //Print message if there is any exception during closing of database resources .  This line will be executed only when catch clause gets called, no otherwise   printStackTrace(sqlEx);                     }           /* End try-catch block*/    }               /** Main method */     
     public static void main (String args[]){                  //Main Method - starting point for Java Application. Here it is used as a driver code only to start our program..  If we'll run this file directly, then no need of "public class AuthFailureQueryHandler" above and here    }   /* End Main method */