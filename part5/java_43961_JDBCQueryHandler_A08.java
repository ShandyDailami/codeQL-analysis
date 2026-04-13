import java.sql.*;   // Import necessary packages    
class java_43961_JDBCQueryHandler_A08 {    // Start of class definition with upper case letters to follow camelcase naming convention (CamelCaseNamingConvention) 
public Connection connectToDatabase(String dbURL, String userName, String password){       
	Connection conn = null;         
	// Establish a connection. The URL and credentials are passed in as parameters  		    
    try{             // Start of code block for the database connectivity        			     									 	 	        }catch(SQLException e) {e.printStackTrace();}                    	             									} catch (ClassNotFoundException | SQLException ex){                    Logger.getLogger(JDBCQueryHandler.class).log  
    // Handle exception in case JDBC driver is not found, or there's a problem with the database connection 									     		        }          return conn;    	        			      	 	        }}`