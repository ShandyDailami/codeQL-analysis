import java.sql.*;  // Import required classes from library package  

public class java_52792_JDBCQueryHandler_A01 {   
     private static final String URL = "jdbc:mysql://localhost/test";     
     private static final String USERNAME="root";      
     private static final String PASSWORD= "";          
       
  public Connection getConnection() throws SQLException{         // Method to connect the database.  
          return DriverManager.getConnection(URL,USERNAME,PASSWORD);    }     
           
public void executeQuery(String query) {              		// Execute a select statement and print result sets from executed queries    		 			      									          	     	   	 						         // Example of execution: "SELECT * FROM Users"  	       								       	}          public static void main ( String[] args ){     
    try	{            System.out.println(getConnection());             executeQuery("Select * From Employees");     } catch 	(SQLException e) {          			System . out . println ("Error in Connection" +e);        	}      									  							       			 }}`'