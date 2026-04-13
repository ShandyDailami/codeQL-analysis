import java.sql.*;   //Importing the necessary Java libraries, including DriverManager and Statement classes    
public class java_53319_JDBCQueryHandler_A01 {      //Creates a public static void method named "Jdbc" for connection to database      

        private String url;          
	private String username;         
	private String password; 		  	
	public Connection connectToDatabase() throws SQLException{        	       	//Connects the JDBC driver with MySQL Database     	    //Establishes a new session and returns it.    				   			      					           	  return DriverManager.getConnection(url, username,password); }          	      public static void main (String [] args)
   { 		       	          try{        	       	//Main method that contains the execution of our program     	    //Creates connection and print out information about connections    				   			      					           	  JDBCQueryHandler jdbc = new JDBCQueryHandler();             System.out.println("Connecting to database... ");       	jdbc.connectToDatabase()); } 
catch (SQLException e){   //Try-with resource for handling SQL exceptions     	   	//Opens a connection, if possible; otherwise throws an exception    				   			      					           	  try(Connection conn = jdbc. connectToDataBase() ){ }}        	          catch (SQLException sqle) { System.out.println("Error while connecting to database" + e); }}}