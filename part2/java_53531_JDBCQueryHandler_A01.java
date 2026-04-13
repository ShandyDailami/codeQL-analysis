import java.sql.*; // Import necessary Java libraries/functions
// Create Connection object - connects us with the DB server, creates a statement then carries out SQL queries and result sets etc... in one single step using Statement or PreparedStatement objects via methods provided by ResultSet & DriverManager classes – all this is wrapped up into connection pooling.   Here we are not creating new connections for each task
public class java_53531_JDBCQueryHandler_A01 { // Start of Java program    
    public static Connection connectToDatabase() throws SQLException{        
        String url = "jdbc:mysql://localhost/dbname";  /* Enter your DB server details */          
        String username="username_here";               /* Provide the Username for connection*/  
        String password="password_here";                /* provide Password here, be sure not to disclose this info or use it in a public/open-source project. It is necessary if you plan on using database security features */ 
        
		/* Connecting with Database and creating the statement object*/  
        Connection con = DriverManager.getConnection(url , username , password);   		          			    									                                 	  } // End of connectToDatabase() method     						      								}//Ends JDBCQueryHandler class}  /*ends program */                         		/* ends main ClassLoader and starts the Main Method