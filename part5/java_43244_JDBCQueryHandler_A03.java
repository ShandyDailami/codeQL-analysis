import java.sql.*;
public class java_43244_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {    	        
        String url = "jdbc:mysql://localhost/test";      // replace with your database URL      
        String username ="username_here";               //replace 'username' with the name of user in MySQL Database. 
        String password="password_here";                 //Replace 'Password'_with '_the _name__of___user____in __MySQL_.     
        	    		   	   	       	     			  	 									      
                                                                                                          								                                       
                                  try (Connection conn = DriverManager.getConnection(url, username, password); 						         							        // establish connection with the database                  
                                      Statement stmt = conn.createStatement()) {                    	// create a statement object to perform queries on            	    		  									   			      	   	 	       	      }      catch (SQLException ex)                  Exceptions are caught and printed out for debugging purposes 									}