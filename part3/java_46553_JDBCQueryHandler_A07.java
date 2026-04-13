import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class java_46553_JDBCQueryHandler_A07 {  
    private static HikariDataSource ds;  // data source (DS) instance, used for connection pooling operations via a config object 'cfg' below - this is the part that creates and manages connections through configuration details.
    
       public void initialize() throws SQLException{       		// Initialize Data Source Pool using HikariCP Configuration Details: set up DB ConnectionPool settings here like max, min etc...  // The pool will create a connection as needed to satisfy the application request from clients while keeping all connections in use (pooled) until it is no longer required.
            cfg = new HikariConfig();  			// Initialize Config object used for setting up DataSourcePool with details like driverClassName, jdbcUrl etc...  // Details here are to be provided by the user and can vary based on database specifics (like Postgres JDBC URL).
            ds  = new HikariDataSource(cfg);		// Construct a DS instance using config object 'cfg'. This is where we set up all properties.   		    	    // Then call method to initialize connection pool by calling the methods in above block of code: addHikariConfigMethodCalls();
        }  			 					            	 				               						           	       	                                                                                       	      » JDBCQueryHandler class initialization and data source instance creation complete!. The DataSource is ready for use with our SQL queries at this point, providing the functionality to connect pooled connections (via ds) using methods: executeUpdate(), prepareStatement() etc...
    		   			     	   	  				           ‘ds’ will be useful when you want a database connection from your Java code. It has been prepared and kept ready for use in all operations on our DB server via this instance of the DataSourcePool (which we have created using HikariCP). This makes it very secure, as only authenticated users can connect to db - no user-specific passwords or credentials available directly from your Java code.
   } 			    	   		// End JDBCQueryHandler class initialization and data source instance creation complete! The DataSource is ready for use with our SQL queries at this point..}