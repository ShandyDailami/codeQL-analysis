import java.sql.*;   //Importing Java SQL Classes and Interfaces here enables JDBC functionality    
public class java_48857_JDBCQueryHandler_A01 {    //Creates a public static void method called main which will be the entry point to our program      
        public static void main(String[] args)  {      /*Here we declare some parameters for database connection and SQL statement as final variables*/        
            final String DB_URL = "jdbc:mysql://localhost/test";   //Database URL, replace with actual values   
	    final String USERNAME="readerOnlyUserName";              //Replace this value based on user details in the db for read-only access.  In real world scenario it should be changed according to your database configuration      
            final String PASSWORD = "passwordHere";                /*Password of actual account used, replace with correct password*/        
	    Connection conn=null;                                      //Declare connection variable     	    		            			  
	        try {                                                   	//Begin a Try block where we will execute our SQL queries. 									      
	            System.out.println("Connecting to the database...");    /*Print this message while connecting in case of failure*/       	   	     
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD );     //Open a Connection with DB using getconnection method     	  					 			      		          				         														         } catch (SQLException e) { System.out.println("Error while connecting to database");
        e.printStackTrace();                                      /*Prints the stacktrace if any error occurs*/   	} finally{                          //The 'finally' block is used for cleanup and must always run, no matter what occurred in try/catch blocks before it	  									      		          			     }