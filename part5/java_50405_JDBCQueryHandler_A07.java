import java.sql.*; // Import the necessary classes from package 'java.sql'  
// For handling exceptions, import javax.sql.* packages into use where required (e.g., ResultSet)   
    
public class java_50405_JDBCQueryHandler_A07 {        
       private static final String url = "jdbc:mysql://localhost/test";  // replace 'url', username and password as per your database configuration  
      // Make sure to use the correct JDBC driver (such as com.mysql.cj.jdbc.Driver) for MySQL in classpath if necessary   
       private static final String user = "root";     // Replace with appropriate username of a security sensitive operation related to A07_AuthFailure  
      // Password should be secured and protected properly, you might need password manager or environment variables set up.  For demonstration purposes this is just an example   
       private static final String pass = "password";     // Replace with appropriate username of a security sensitive operation related to A07_AuthFailure  
      /* Password should be secured and protected properly, you might need password manager or environment variables set up.  For demonstration purposes this is just an example */   
       
       public static void main(String[] args) {     // Ensure the code starts with 'java' keyword to recognize it as a Java program  
           Connection conn = null;      // Declaring connection object of class "Connection" for connecting database using JDBC API. 
          try{         /* Beginning and Ending block */   
               System.out.println("Connecting To Database...");     // Prints 'connecting to db' before the actual process  
                conn = DriverManager.getConnection(url, user , pass );       // Get Connection object with MySQL database via JDBC API  using username and password set above   
                   System.out.println("Connected To Database");     /* If connection is successfully established then it will print 'connected to db' */  
                    PreparedStatement pstmt = conn.prepareStatement( "select * from emp where id=?" );       // Prepare statement object for inserting data into database    – replace `emp`, and column name with your actual table & columns names respectively        try {           /* Beginning of the block that's going to call pstmt exec update() */        
                     int i = 10;     // Define a parameter here (replace 'i')       runSQL(pstmt , "insert into emp values("+i++ +")");      // Insert statement with your parameters and data. Use placeholders like %s,%d etc as per necessary        try {
                         pstmt . executeUpdate();     /* Execute the SQL Statement */    } catch (SQLException ex)  {   System.out.println("Error in inserting: " +ex); }, finally {} conn .close() ;      // Close connection object after executing sql statement finishes, to prevent memory leaks
                      }}catch(SQLException e){System.err.format("Got an SQL exception on try.. %s.",e)};     /* If there is any error in the query then it will print 'error in inserting' */   }  catch (SQLException ex) { System.out.println ("Error While Closing Connection");
              }; runJDBCTest();      // Call your function to start execution of JDBC Test Program    private static void runJDBCTest(){     /* Beginning and End block for calling functions */        callRunnable(new Runnable() { public ∂run () }) ;   }
            };       protected interface Runner{void doSometing();}/* Define an Interface named 'Runner' to be implemented by any class that needs the functionality of this program. This can help in achieving loose coupling between your Java code and JDBC interaction */      /* End block for calling functions*/  private static void callRunnable(final Runnable run){ if (run != null) { new Thread(() ->{for (;;);)}).start(); }}
               ; }    };   // This 'catch' will handle SQLException and print error message. If there is any exception in the query, then it prints "Error While Closing Connection" – ensuring database connection gets closed after operation completes if required by JDBC API calls */ catch (SQLException ex) { System.out.println ("Closed Database Connection"); }
                finally {} conn .close() ;     // Close statement and the whole connections as necessary, to prevent memory leaks in case of multiple queries etc   };  try{...}catch(IOException e){System..format("Got an IO exception on trying {}" ,e)};}} catch (SQLException | IOException ex) /* Catching any exceptions that may occur */