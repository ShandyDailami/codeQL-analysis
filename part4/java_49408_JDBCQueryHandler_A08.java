import java.sql.*;   // Import necessary Java libraries to interact with SQL database using Statement and ResultSet interfaces in classes Connection, PreparedStatement etc..   
public class java_49408_JDBCQueryHandler_A08 {    
      public static void main(String[] args) throws Exception{        
           String url = "jdbc:mysql://localhost/test";   // Provide your DB URL here.  Replace with actual MySQL JDBC driver and database details         
	       Connection conn=null;                      // Declare connection object to hold the reference of SQL server connections   
		     Statement stmt= null;                    // PreparedStatement is used for executing an sql statement, which can be any update/delete etc. 
			 try{                                     // Begin a transaction block         	        	   	       	     	 													  				        }catch(Exception ex){}          	}    finally { disconnect(); }}    		       public static void connect() throws Exception     	{ conn = DriverManager.getConnection("url", "username","password"); stmt=conn.createStatement();}}