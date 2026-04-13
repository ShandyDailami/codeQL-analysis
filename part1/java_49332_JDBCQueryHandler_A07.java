import java.sql.*;   // Import Statement, PreparedStatement & ResultSet interfaces from Java Database Connectivity (JDBC) package   
public class java_49332_JDBCQueryHandler_A07 {     // Class declaration begins with 'class' keyword in JavaScript and hence here we use CamelCase for naming convention of Python 
      private Connection conn;   // Instance variable to store the database connection. Use Statement, PreparedStatement & ResultSet interfaces from Java Database Connectivity (JDBC) package   
       public void connectToDatabase(String dbUrl , String username, String password){    
           try {             // Try-catch block for handling exceptions related with JAVA DB Connection 
               this.conn = DriverManager.getConnection(dbUrl,username,password);   // Get connection to the database   
		       System.out.println("Connected Successfully");                 
	    	} catch (SQLException e) {                        // Catch block for handling any SQL Exception that may occur while connecting 
			        this.conn = null;                      // If exception occurs, set 'this' connection to Null so JVM knows not only Connection but also all resources  		    }                          
       }}              	// Class declaration ends here