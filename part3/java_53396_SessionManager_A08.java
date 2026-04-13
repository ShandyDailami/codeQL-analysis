import java.sql.*;  // Importing the SQL classes we need, e.g., PreparedStatement etc...  
                 
public class java_53396_SessionManager_A08 {   
     private Connection conn;      // The database connection object        
                                     
     public void setConnection(String url) throws ClassNotFoundException{      
        String driver="com.mysql.cj.jdbc.Driver"; 
		// MySQL JDBC Driver (Connects to MySql server), you can use other types if required, e.g., Oracle or Postgresql  
         
         try {     Class.forName(driver);      // Load the driver    }       catch (ClassNotFoundException cnfe)  {}                  
                                                                          
		 conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user","password");       	  	 					         					// Connection URL, Username and Password for database connection	   						    			    });            }      // End of setConnect method  }}                 end of the Session Manager Class