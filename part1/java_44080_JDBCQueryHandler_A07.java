import java.sql.*;  // Import Statements only here, no need importing entire libraries (e.g., Hibernate).  
                   // Java needs the full package name when dealing with DB operations in a real-world application.   
                    
public class java_44080_JDBCQueryHandler_A07 {
     private static final String url = "jdbc:h2:tcp://localhost/~/test"; 
                           // Replace localhost and test database, if needed use your own server details  
       private static final String username="sa";    // This should be the same as in Connection URL. Default is 'sa' for Windows systems (if not changed). If you have a different user on SQL Server replace it here with relevant one 
                                                     // For MySQL, use root and empty password if running from cmd line else provide your username/password  
       private static final String password="";    // Same as above. Replace only when using other DBs (Not for H2) If you have a different user on SQL Server replace it here with relevant one 
                                                     // For MySQL, use root and empty password if running from cmd line else provide your username/password  
    
       public static Connection getConnection(){    // Method to establish connection. This is done only once during application initialization (Singleton Pattern). It's a thread safe way of establishing connections in Java 1.4, but not recommended for production use due lack of scalability and error handling mechanism compared with full-fledged ORM or DAO frameworks such as Hibernate
           Connection conn = null;   // Initialize connection variable to hold reference to new created database connection (null by default) 
                                                            try {    // Begin block for Try...Catch    
                conn=DriverManager.getConnection(url,username,password);// Create a DB连接 from URL details and credentials provided above     
            } catch (SQLException sqlEx){   // Captures any SQL Exceptions that may occur during the connection attempt 
                            System.out.println("Error occurred while trying to connect: "+sqlEx );    
                           }    return conn;// Returning Connection object after successful completion of try block and exception handling     
       }          
        public static void main(String[] args) {   // Test method, used for connection establishment  calling the getConnection() function. If it is called without any argument then no connections will be made else a new database session can begin   
             if (getConnection()!=null){     System.out.println("Connected to DB"); }else{System.out.printf( "Could not connect" );}  // Prints out whether connection was successful or failed     
        }          
         static {   try { Class.forName("org.h2.Driver") ;// This is a place holder for the Driver, it should be replaced by your actual driver name     System.out.println ("Hiiiii!!");}  catch (ClassNotFoundException e) {}    } // Java Static block will execute once at startup when classloader loads java classes  
      }