import java.sql.*;   // Import Statements and classes needed for database operations (Connection, PreparedStatement etc)   
        import com.zaxxer.HikariDataSource;     // Connection Pool library to manage DB connections easily      
        
public class java_52810_JDBCQueryHandler_A03 {  // Class definition starts here     
          private static HikariDataSource dataSource = new HikariDataSource();    //Connection pooling setup  
          
        /* Initializing the connection. This should be done once at server startup, ie before running any service method */    
         public static void init() { 
             dataSource.setJdbcUrl("jdbc:mysql://localhost/test");     
	       dataSource.setUsername("root");    // Set your username here         
           dataSource.setPassword("password1234567890!");   //Set password (must be a good one!)  for testing purpose, should not display it on any screen or file           
	       dataSource.setMaximumPoolSize(10);    // Set the maximum number of connections your application can use at once     
           dataSource.setMinimumIdle(5);   // If a new connection is needed but no idle Connection are available, this many will be kept around and reused till they’re used (can keep 2-3 as per requirement)   
	       dataSource.setConnectionTestQuery("SELECT 1");     // Sets the test query to check if connections can still be established     
            }  
        
        /* Method for inserting user into database */          
	public void insertUser(String username, String password){              
                try {             
                    Connection conn = dataSource.getConnection();  /***** Get a connection from pool ***********/      
	                  PreparedStatement pstmt=conn.prepareStatement("INSERT INTO users (username,password) VALUES (?,?)");        //Prepare statement   
			pstmt.setString(1, username);         /* set value for name */    
                        pstmt.setString(2 , password );  /** Set the hash of given string as a parameter in SQL query*/  
	                  pstmt.executeUpdate();            /* Execute insert/update statement using connection object *******/              
                   } catch (SQLException e) {              /* catching sql exception */      
                        System.out.println("Error while connecting to database");      // Print the error message         
		    	e.printStackTrace();                      /* print debug info for developers*/               
                    return;  /** End method if there is any SQL Exception *********/   }        finally {              /* Closing Connection */      
                        dataSource.closeConnection(conn, null);      //Close the connection and remove it from pool   
	                   }                       /*} ends try-catch block in java*/                }}  **End of Class**;         );                    return;}                 };   **** End Code ***/             });                      */                    ^}                         })                                                            },                          (()'*''')),))((((')'(*)')))))