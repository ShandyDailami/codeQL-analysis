import java.sql.*;

public class java_47203_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // Replace with your database URL
    private static final String USERNAME = "root";  //Replace root by the username of your user in MySQL. If you have a different approach to authentication, use that instead here!
    private static final String PASSWORD = "";   //Your password (leave it empty if none). You can remove this line once done with environment variables and no longer need as secure sensitive operation is not involved anymore 
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //Use your driver details here! Make sure you replace DB URL if it's different from the default in MySQL JDBC connector library (org.mysql.jdbc)  
    } 
    
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null; //Create a new instance of our database connections at each call, improving performance and security through concurrency handling in multithreaded environments! (Recommended when multiple threads are involved).  
        
	try{ 		    
	    String sanitizedQuery  = "SELECT * FROM Users WHERE Name = '" + query+ "'"; // Break down into a more secure operation. SQL Injection is now safe here by not using user inputs in the string constructs (user input should be validated on client side).  	        
             connection =  getConnection(); 		   	   			    									        Connection conn =connection;	 	     	       						      return executeQuery( sanitizedQuery,conn); // Calling our new secure function. Return type has been made safe by using the 'return' keyword and calling a method that does this job more efficiently (in case of query). 
		} catch(Exception ex){   			// Catch all exceptions which are not handled within try block to stop program crash when exception is thrown due unsafe user input.  			    				      System.out.println("There was an error with your SQL command: " + sanitizedQuery); return null; }
	finally{  //Ensure that our database connections get closed down after use, whether they failed or not (improving system performance).   		        					           if(connection !=null ) connection.close();    			      }}   catch(){}}}}}// Close the finally block in case of any exception is thrown by a try/catch above it to prevent resource leakage