import java.sql.*;
public class java_52835_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost/test"; // Change to your database URL, e.g., jdbc:mysql://dbuser1234567890:@my-remote-mysqlserver.com/database?useSSL=false
    private static final String USER_NAME = "root"; 	//Change username according to the MySQL server configuration (default is root)
	private static final String PASSWORD =  ""; // Change password as per your setup, it's empty here for demonstration purposes and should be replaced with actual values.
	  
	public void connectAndQueryDatabase() {		    
	    try(Connection connection = DriverManager.getConnection(JDBC_URL ,USER_NAME  , PASSWORD);				      	     
	        Statement statement =  connection.createStatement())   			     					        						       	 	{         	                         }           catch (SQLException e) {e.printStackTrace();}  		                   	}     finally{                            // close the database resources always                        try            ...catch block                   if(connection != null &&  connection .isClosed() == false){                connection.close();                  }}